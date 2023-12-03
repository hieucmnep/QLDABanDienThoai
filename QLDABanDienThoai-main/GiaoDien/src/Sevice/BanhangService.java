/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Sevice.BanHang;
import model.SanPham;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import Model.HoaDon;
import Model.SanPham_model;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author LE DINH LINH
 */
public class BanHangService {

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        try (Connection connection = dbconnect.DBConnector.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT SANPHAM.*, SANPHAMCT.SOLUONG "
                + "FROM SANPHAM "
                + "INNER JOIN SANPHAMCT ON SANPHAM.MASP = SANPHAMCT.MASP"
        ); ResultSet resultSet = preparedStatement.executeQuery()) {

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
                    maHD = "HD" + String.format("%05d", count);
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

    public HoaDon themHoaDon(String maNV, String maKH, boolean daThanhToan, java.util.Date ngayMua) {
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
                themHoaDonCT(maHD, maKH, true, (Date) ngayMua);

                newHoaDon = new HoaDon();
                newHoaDon.setMaHD(maHD);
                newHoaDon.setMaNV(maNV);
                newHoaDon.setMaKH(maKH);
                newHoaDon.setTrangThai(daThanhToan ? 1 : 0);
                newHoaDon.setNgayMua(ngayMua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void themHoaDonCT(String maHD, String maKH, boolean par, Date ngayMua) {
        Connection conn = null;
        PreparedStatement pstmtHoaDonCT = null;

        try {
            conn = dbconnect.DBConnector.getConnection();
            String sqlInsertHoaDonCT = "INSERT INTO HOADONCT (MAHD, MAKH, TRANGTHAI, NGAYMUA) VALUES (?, ?, 0, ?)";
            pstmtHoaDonCT = conn.prepareStatement(sqlInsertHoaDonCT);
            pstmtHoaDonCT.setString(1, maHD);
            pstmtHoaDonCT.setString(2, maKH);
            pstmtHoaDonCT.setDate(3, new java.sql.Date(ngayMua.getTime()));  // Chuyển đổi ngày mua sang java.sql.Date

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

    public ArrayList<String> layTatCaMaKhuyenMai() {
        ArrayList<String> tatCaMaKhuyenMai = new ArrayList<>();
        try (Connection connection = dbconnect.DBConnector.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT MAKM FROM KHUYENMAI")) {

            while (resultSet.next()) {
                tatCaMaKhuyenMai.add(resultSet.getString("MAKM"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tatCaMaKhuyenMai;
    }

   public void themThanhToan(String maHD, String maKH, float tienKhachDua, float tienTraLai,
        String hinhThucThanhToan, float tongTien, String ghiChu, String maKM, int soLuong) {
    Connection conn = null;
    PreparedStatement pstmtThanhToan = null;

    try {
        // Kiểm tra giá trị không âm
        if (tienKhachDua < 0 || tienTraLai < 0 || tongTien < 0 || soLuong <= 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị không âm và số lượng lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        conn = dbconnect.DBConnector.getConnection();
        String sqlUpdateThanhToan = "UPDATE HOADONCT SET MAKH = ?, DONGIA = ?, SOLUONG = ?, TIENKHACHDUA = ?, TIENTRALAI = ?, NGAYMUA = ?, HINHTHUCTHANHTOAN = ?, TONGTIEN = ?, GHICHU = ?, MAKM = ?, TRANGTHAI = 1 WHERE MAHD = ? AND MASPCT = ?";
        pstmtThanhToan = conn.prepareStatement(sqlUpdateThanhToan);
        pstmtThanhToan.setString(1, maKH);
        pstmtThanhToan.setFloat(2, 0); // Bạn cần cập nhật giá trị đơn giá tương ứng
        pstmtThanhToan.setInt(3, soLuong);
        pstmtThanhToan.setFloat(4, tienKhachDua);
        pstmtThanhToan.setFloat(5, tienTraLai);
        pstmtThanhToan.setDate(6, new java.sql.Date(System.currentTimeMillis()));  // Giả sử ngàyMua là ngày hiện tại
        pstmtThanhToan.setString(7, hinhThucThanhToan);
        pstmtThanhToan.setFloat(8, tongTien);
        pstmtThanhToan.setString(9, ghiChu);
        pstmtThanhToan.setString(10, maKM);
        pstmtThanhToan.setString(11, maHD);
        pstmtThanhToan.setString(12, "CT1"); // Đối với chi tiết hóa đơn, bạn cần chỉ định mã sản phẩm chi tiết

        pstmtThanhToan.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Đóng tất cả các tài nguyên kết nối
        try {
            if (pstmtThanhToan != null) {
                pstmtThanhToan.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}
