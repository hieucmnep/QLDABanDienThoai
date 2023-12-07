/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.SanPham;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.ImageIcon;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.HoaDon;
import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.HoaDon;

/**
 *
 * @author LE DINH LINH
 */
public class BHservice {

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT SANPHAM.*, SANPHAMCT.MASPCT, SANPHAMCT.SOLUONG "
                + "FROM SANPHAM "
                + "INNER JOIN SANPHAMCT ON SANPHAM.MASP = SANPHAMCT.MASP WHERE SOLUONG > 0"
        ); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                String maSPCT = resultSet.getString("MASPCT");
                sanPham.setMaSPCT(maSPCT);
                sanPham.setIdSP(resultSet.getInt("IDSP"));
                sanPham.setMaSP(resultSet.getString("MASP"));
                sanPham.setTenSP(resultSet.getString("TENSP"));
                sanPham.setThuongHieu(resultSet.getString("THUONGHIEU"));
                sanPham.setChip(resultSet.getString("CHIP"));
                sanPham.setCamera(resultSet.getString("CAMERA"));
                sanPham.setKichThuoc(resultSet.getFloat("KICHTHUOC"));
                sanPham.setChatLieu(resultSet.getString("CHATLIEU"));
                sanPham.setHeDieuHanh(resultSet.getString("HEDIEUHANH"));
                sanPham.setDungLuongPin(resultSet.getString("DUNGLUONGPIN"));
                sanPham.setGia(resultSet.getFloat("GIA"));
                sanPham.setTrangThai(resultSet.getInt("TRANGTHAI"));

                // Lấy giá trị từ cơ sở dữ liệu dưới dạng String
                String hinhAnhString = resultSet.getString("HINHSP");

                // Chuyển đổi String thành ImageIcon
                ImageIcon hinhAnhIcon = new ImageIcon(hinhAnhString);

                // Gán ImageIcon cho đối tượng SanPham
                sanPham.setHinhSP(hinhAnhIcon);

                // Lấy số lượng từ cơ sở dữ liệu
                int soLuong = resultSet.getInt("SOLUONG");
                // Gán số lượng cho đối tượng SanPham
                sanPham.setSoluong(soLuong);

                danhSachSanPham.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachSanPham;
    }

    private String taoMaHoaDon(Connection conn) {
        String maHD = "";
        try {
            String sqlGetCount = "SELECT TOP 1 MAHD FROM HOADON ORDER BY CONVERT(INT, SUBSTRING(MAHD, 3, LEN(MAHD))) DESC";
            try (PreparedStatement pstmtCount = conn.prepareStatement(sqlGetCount); ResultSet rsCount = pstmtCount.executeQuery()) {
                if (rsCount.next()) {
                    String latestMaHD = rsCount.getString("MAHD");
                    int count = Integer.parseInt(latestMaHD.substring(2)) + 1;
                    maHD = "HD" + String.format("%04d", count);
                } else {
                    // Nếu chưa có hóa đơn nào trong CSDL, bắt đầu từ 1
                    maHD = "HD00001";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maHD;
    }

    public HoaDon themHoaDon(String maNV, String maKH, String maSPCT, boolean daThanhToan, Date ngayMua) {
        Connection conn = null;
        PreparedStatement pstmtHoaDon = null;
        ResultSet rsHoaDon = null;
        HoaDon newHoaDon = null;

        try {
            conn = dbconnect.DBConnector.getConnection();
            String maHD = taoMaHoaDon(conn);

            String sqlInsertHoaDon = "INSERT INTO HOADON (MAHD, MANV) VALUES (?, ?)";
            pstmtHoaDon = conn.prepareStatement(sqlInsertHoaDon, Statement.RETURN_GENERATED_KEYS);
            pstmtHoaDon.setString(1, maHD);
            pstmtHoaDon.setString(2, maNV);

            pstmtHoaDon.executeUpdate();

            rsHoaDon = pstmtHoaDon.getGeneratedKeys();
            if (rsHoaDon.next()) {
                themHoaDonCT(maHD, maSPCT, maKH, ngayMua);

                newHoaDon = new HoaDon();
                newHoaDon.setMaHD(maHD);
                newHoaDon.setMaNV(maNV);
                newHoaDon.setMaKH(maKH);
                newHoaDon.setTrangThai("Chưa Thanh Toán");
                newHoaDon.setNgayMua(ngayMua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các tài nguyên kết nối
            try {
                if (rsHoaDon != null) {
                    rsHoaDon.close();
                }
                if (pstmtHoaDon != null) {
                    pstmtHoaDon.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return newHoaDon;
    }

    public void themHoaDonCT(String maHD, String maSPCT, String maKH, Date ngayMua) {
        Connection conn = null;
        PreparedStatement pstmtHoaDonCT = null;

        try {
            conn = dbconnect.DBConnector.getConnection();
            String sqlInsertHoaDonCT = "INSERT INTO HOADONCT (MAHD, MASPCT, MAKH, TRANGTHAI, NGAYMUA) VALUES (?, ?, ?, N'Chưa Thanh Toán', ?)";
            pstmtHoaDonCT = conn.prepareStatement(sqlInsertHoaDonCT);
            pstmtHoaDonCT.setString(1, maHD);
            pstmtHoaDonCT.setString(2, maSPCT);
            pstmtHoaDonCT.setString(3, maKH);
            pstmtHoaDonCT.setDate(4, new java.sql.Date(ngayMua.getTime()));

            pstmtHoaDonCT.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các tài nguyên kết nối
            try {
                if (pstmtHoaDonCT != null) {
                    pstmtHoaDonCT.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> tatCaMaKhuyenMai() {
        ArrayList<String> tatCaMaKhuyenMai = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT MAKM FROM KHUYENMAI")) {

            while (resultSet.next()) {
                tatCaMaKhuyenMai.add(resultSet.getString("MAKM"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tatCaMaKhuyenMai;
    }

    public static float layPhanTramGiamGia(String maKhuyenMai) {
        float phanTramGiamGia = 0.0f;
        try (Connection connection = DBConnector.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT PhanTramGiamGia FROM KHUYENMAI WHERE MAKM = ?")) {
            preparedStatement.setString(1, maKhuyenMai);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    phanTramGiamGia = resultSet.getFloat("PhanTramGiamGia");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanTramGiamGia;
    }

    public void thanhToan(String maHD, String maKH, float tienKhachDua, float tienTraLai,
            String hinhThucThanhToan, float tongTien, String ghiChu, String maKM, float giamGia,
            int soLuong, float donGia, String maSPCT) {
        Connection conn = null;
        PreparedStatement pstmtThanhToan = null;

        try {

            conn = dbconnect.DBConnector.getConnection();
            conn.setAutoCommit(false);
            String sqlUpdateThanhToan = "UPDATE HOADONCT SET MAKH = ?, SOLUONG = ?, TIENKHACHDUA = ?, TIENTRALAI = ?, NGAYMUA = ?, HINHTHUCTHANHTOAN = ?, TONGTIEN = ?, GHICHU = ?, MAKM = ?, GIAMGIA = ?, DONGIA = ?, TRANGTHAI = N'Đã Thanh Toán'  WHERE MAHD = ?";
            pstmtThanhToan = conn.prepareStatement(sqlUpdateThanhToan);
            pstmtThanhToan.setString(1, maKH);
            pstmtThanhToan.setInt(2, soLuong);
            pstmtThanhToan.setFloat(3, tienKhachDua);
            pstmtThanhToan.setFloat(4, tienTraLai);
            pstmtThanhToan.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            pstmtThanhToan.setString(6, hinhThucThanhToan);
            pstmtThanhToan.setFloat(7, tongTien);
            pstmtThanhToan.setString(8, ghiChu);
            pstmtThanhToan.setString(9, maKM);
            pstmtThanhToan.setFloat(10, giamGia);
            pstmtThanhToan.setFloat(11, donGia);
            pstmtThanhToan.setString(12, maHD);

            pstmtThanhToan.executeUpdate();

         
            String sqlUpdateSoLuongTonKho = "UPDATE SANPHAMCT SET SOLUONG = SOLUONG - ? WHERE MASPCT = ?";
            PreparedStatement pstmtCapNhatTonKho = conn.prepareStatement(sqlUpdateSoLuongTonKho);
            pstmtCapNhatTonKho.setInt(1, soLuong);
            pstmtCapNhatTonKho.setString(2, maSPCT);

            pstmtCapNhatTonKho.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmtThanhToan != null) {
                    pstmtThanhToan.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<SanPham> timKiemSanPhamTheoTen(String tenSanPham) {
        ArrayList<SanPham> danhSachKetQua = new ArrayList<>();
        try (Connection connection = dbconnect.DBConnector.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT SANPHAM.*, SANPHAMCT.SOLUONG "
                + "FROM SANPHAM "
                + "INNER JOIN SANPHAMCT ON SANPHAM.MASP = SANPHAMCT.MASP "
                + "WHERE SANPHAM.TENSP LIKE ?"
        )) {
            preparedStatement.setString(1, "%" + tenSanPham + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSP(resultSet.getInt("IDSP"));
                sanPham.setMaSP(resultSet.getString("MASP"));
                sanPham.setTenSP(resultSet.getString("TENSP"));
                sanPham.setThuongHieu(resultSet.getString("THUONGHIEU"));
                sanPham.setChip(resultSet.getString("CHIP"));
                sanPham.setCamera(resultSet.getString("CAMERA"));
                sanPham.setKichThuoc(resultSet.getFloat("KICHTHUOC"));
                sanPham.setChatLieu(resultSet.getString("CHATLIEU"));
                sanPham.setHeDieuHanh(resultSet.getString("HEDIEUHANH"));
                sanPham.setDungLuongPin(resultSet.getString("DUNGLUONGPIN"));
                sanPham.setGia(resultSet.getFloat("GIA"));
                sanPham.setTrangThai(resultSet.getInt("TRANGTHAI"));

                // Lấy giá trị từ cơ sở dữ liệu dưới dạng String
                String hinhAnhString = resultSet.getString("HINHSP");

                // Chuyển đổi String thành ImageIcon
                ImageIcon hinhAnhIcon = new ImageIcon(hinhAnhString);

                // Gán ImageIcon cho đối tượng SanPham
                sanPham.setHinhSP(hinhAnhIcon);

                // Lấy số lượng từ cơ sở dữ liệu
                int soLuong = resultSet.getInt("SOLUONG");
                // Gán số lượng cho đối tượng SanPham
                sanPham.setSoluong(soLuong);

                danhSachKetQua.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKetQua;
    }

    public void huythanhToan(String maHD, String maKH, float tienKhachDua, float tienTraLai,
            String hinhThucThanhToan, float tongTien, String ghiChu, String maKM, float giamGia,
            int soLuong, float donGia, String maSPCT) {
        Connection conn = null;
        PreparedStatement pstmtThanhToan = null;

        try {

            conn = dbconnect.DBConnector.getConnection();
            conn.setAutoCommit(false);
            String sqlUpdateThanhToan = "UPDATE HOADONCT SET MAKH = ?, SOLUONG = ?, TIENKHACHDUA = ?, TIENTRALAI = ?, NGAYMUA = ?, HINHTHUCTHANHTOAN = ?, TONGTIEN = ?, GHICHU = ?, MAKM = ?, GIAMGIA = ?, DONGIA = ?, TRANGTHAI = N'Hủy'  WHERE MAHD = ?";
            pstmtThanhToan = conn.prepareStatement(sqlUpdateThanhToan);
            pstmtThanhToan.setString(1, maKH);
            pstmtThanhToan.setInt(2, soLuong);
            pstmtThanhToan.setFloat(3, tienKhachDua);
            pstmtThanhToan.setFloat(4, tienTraLai);
            pstmtThanhToan.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            pstmtThanhToan.setString(6, hinhThucThanhToan);
            pstmtThanhToan.setFloat(7, tongTien);
            pstmtThanhToan.setString(8, ghiChu);
            pstmtThanhToan.setString(9, maKM);
            pstmtThanhToan.setFloat(10, giamGia);
            pstmtThanhToan.setFloat(11, donGia);
            pstmtThanhToan.setString(12, maHD);

            pstmtThanhToan.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmtThanhToan != null) {
                    pstmtThanhToan.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
