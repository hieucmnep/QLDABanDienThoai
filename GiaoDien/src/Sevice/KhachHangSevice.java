/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.HoaDonCT;
import Model.KhachHang;
import Model.SanPham;
import dbconnect.DBConnector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class KhachHangSevice {

    public ArrayList<KhachHang> GetAll() {
        ArrayList<KhachHang> KH = new ArrayList<>();
        Connection cnt = DBConnector.getConnection();
        String Sql = "SELECT * FROM KhachHang";
        try {
            PreparedStatement psm = cnt.prepareStatement(Sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("IDKH"));
                kh.setMaKH(rs.getString("MAKH"));
                kh.setTenKH(rs.getNString("TENKH"));
                kh.setGioiTinh(rs.getString("GIOITINH"));
                kh.setSdt(rs.getString("SDT"));
                kh.setEmail(rs.getString("EMAIL"));
                kh.setNgaySinh(rs.getDate("NGAYSINH"));
                kh.setDiaChi(rs.getNString("DIACHI"));
                kh.setTrangThai(rs.getBoolean("TRANGTHAI"));
                KH.add(kh);
            }
            psm.close();
            rs.close();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KH;
    }

    public Integer add(KhachHang kh) {
        Integer row = null;
        try {
            Connection cnt = DBConnector.getConnection();
            PreparedStatement psm = cnt.prepareStatement("INSERT INTO KHACHHANG (MAKH, TENKH, NGAYSINH, GIOITINH, SDT, TRANGTHAI, DIACHI, EMAIL) VALUES (?,?,?,?,?,?,?,?)");
            psm.setString(1, kh.getMaKH());
            psm.setString(2, kh.getTenKH());
            psm.setDate(3, new java.sql.Date(kh.getNgaySinh().getTime()));
            psm.setString(4, kh.getGioiTinh());
            psm.setString(5, kh.getSdt());
            psm.setBoolean(6, kh.isTrangThai());
            psm.setString(7, kh.getDiaChi());
            psm.setString(8, kh.getEmail());
            row = psm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return row;
    }

    public Integer Xoa(KhachHang kh) {
        Integer row = null;
        try {
            Connection cnt = DBConnector.getConnection();
            String sql = "DELETE KHACHHANG WHERE MAKH = ?";
            PreparedStatement ps = cnt.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            row = ps.executeUpdate(); //
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public Integer update(KhachHang kh) {
        Integer row = null;
        try {
            Connection cnt = DBConnector.getConnection();
            String sql = "UPDATE KHACHHANG SET MAKH=?, TENKH=?, NGAYSINH=?, GIOITINH=?, SDT=?, TRANGTHAI=?, DIACHI=?, EMAIL=? WHERE IDKH=?";

            try (PreparedStatement psm = cnt.prepareStatement(sql)) {
                psm.setString(1, kh.getMaKH());
                psm.setString(2, kh.getTenKH());
                // Assuming kh.getNgaySinh() returns a java.sql.Date
                psm.setDate(3, new java.sql.Date(kh.getNgaySinh().getTime()));
                psm.setString(4, kh.getGioiTinh());
                psm.setString(5, kh.getSdt());
                psm.setBoolean(6, kh.isTrangThai());
                psm.setString(7, kh.getDiaChi());
                psm.setString(8, kh.getEmail());
                psm.setInt(9, kh.getId());
                row = psm.executeUpdate();
            }

            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed, for example, log it or throw a custom exception
        }
        return row;
    }

    public ArrayList<KhachHang> joinTables() {
        ArrayList<KhachHang> KH = new ArrayList<>();
        Connection cnt = DBConnector.getConnection();
        String sql = "SELECT KHACHHANG.IDKH,TENKH,SDT,HOADONCT.NGAYMUA,HOADONCT.SOLUONG,DONGIA,TONGTIEN,HOADONCT.TRANGTHAI,TENSP\n"
                + "FROM HOADONCT JOIN KHACHHANG ON  HOADONCT.MAKH = KHACHHANG.MAKH\n"
                + "			JOIN SANPHAMCT ON SANPHAMCT.MASPCT = HOADONCT.MASPCT\n"
                + "			JOIN SANPHAM ON SANPHAM.MASP = SANPHAMCT.MASP";
        try {
            PreparedStatement psm = cnt.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("IDKH"));
                kh.setTenKH(rs.getNString("TENKH"));
                kh.setSdt(rs.getString("SDT"));
                HoaDonCT so = new HoaDonCT();
                so.setNgayMua(rs.getString("NGAYMUA"));
                so.setSoLuong(rs.getInt("SOLUONG"));
                so.setDonGia(rs.getFloat("DONGIA"));
                so.setTongTien(rs.getFloat("TONGTIEN"));
                so.setTrangThai(rs.getString("TRANGTHAI"));
                SanPham sp = new SanPham();
                sp.setTenSP(rs.getString("TenSP"));
                kh.setHoaDonCT(so);

                kh.setSanpham(sp);

                kh.setHoaDonCT(so);

                KH.add(kh);
            }
            psm.close();
            rs.close();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KH;
    }

    public ArrayList<KhachHang> Search(String keyword) {
        ArrayList<KhachHang> result = new ArrayList<>();
        Connection cnt = DBConnector.getConnection();
        String sql = "SELECT * FROM KhachHang WHERE TENKH LIKE ? OR MAKH LIKE ? OR EMAIL LIKE ? OR SDT LIKE ?";

        try {
            PreparedStatement psm = cnt.prepareStatement(sql);
            String likeKeyword = "%" + keyword + "%";
            psm.setString(1, likeKeyword);
            psm.setString(2, likeKeyword);
            psm.setString(3, likeKeyword);
            psm.setString(4, likeKeyword);

            ResultSet rs = psm.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("IDKH"));
                kh.setMaKH(rs.getString("MAKH"));
                kh.setTenKH(rs.getNString("TENKH"));
                kh.setGioiTinh(rs.getString("GIOITINH"));
                kh.setSdt(rs.getString("SDT"));
                kh.setEmail(rs.getString("EMAIL"));
                kh.setNgaySinh(rs.getDate("NGAYSINH"));
                kh.setDiaChi(rs.getNString("DIACHI"));
                kh.setTrangThai(rs.getBoolean("TRANGTHAI"));
                result.add(kh);
            }

            psm.close();
            rs.close();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public ArrayList<KhachHang> SearchGD(String keyword) {
    ArrayList<KhachHang> result = new ArrayList<>();
    Connection cnt = DBConnector.getConnection();
    String sql = "SELECT KHACHHANG.IDKH, TENKH, SDT, HOADONCT.NGAYMUA, HOADONCT.SOLUONG, DONGIA, TONGTIEN, HOADONCT.TRANGTHAI, TENSP " +
            "FROM HOADONCT " +
            "JOIN KHACHHANG ON HOADONCT.MAKH = KHACHHANG.MAKH " +
            "JOIN SANPHAMCT ON SANPHAMCT.MASPCT = HOADONCT.MASPCT " +
            "JOIN SANPHAM ON SANPHAM.MASP = SANPHAMCT.MASP " +
            "WHERE KHACHHANG.TENKH LIKE ? OR KHACHHANG.MAKH LIKE ? OR KHACHHANG.EMAIL LIKE ? OR KHACHHANG.SDT LIKE ?";


    try {
        PreparedStatement psm = cnt.prepareStatement(sql);
        String likeKeyword = "%" + keyword + "%";
        psm.setString(1, likeKeyword);
        psm.setString(2, likeKeyword);
        psm.setString(3, likeKeyword);
        psm.setString(4, likeKeyword);

        ResultSet rs = psm.executeQuery();

        while (rs.next()) {
            KhachHang kh = new KhachHang();
            kh.setId(rs.getInt("IDKH"));
            kh.setTenKH(rs.getNString("TENKH"));
            kh.setSdt(rs.getString("SDT"));

            HoaDonCT so = new HoaDonCT();
            so.setNgayMua(rs.getString("NGAYMUA"));
            so.setSoLuong(rs.getInt("SOLUONG"));
            so.setDonGia(rs.getFloat("DONGIA"));
            so.setTongTien(rs.getFloat("TONGTIEN"));
            so.setTrangThai(rs.getString("TRANGTHAI"));

            SanPham sp = new SanPham();
            sp.setTenSP(rs.getString("TENSP"));

            kh.setHoaDonCT(so);
            kh.setSanpham(sp);

            result.add(kh);
        }

        psm.close();
        rs.close();
        cnt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return result;
}

public ArrayList<KhachHang> InHoaDon() {
    ArrayList<KhachHang> list = GetAll();
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();
    Row row;
    Cell cell;

    // write the column headers
    row = sheet.createRow(0);
    String[] headers = {"IDKH", "TENKH", "SDT", "NGAYMUA", "TENSP", "SOLUONG", "GIABAN", "TONGTIEN", "TRANGTHAI"};
    for (int c = 0; c < headers.length; c++) {
        cell = row.createCell(c);
        cell.setCellValue(headers[c]);
    }

    for (int r = 0; r < list.size(); r++) {
        row = sheet.createRow(r + 1);
        KhachHang KH = list.get(r);
        cell = row.createCell(0);
        cell.setCellValue(KH.getId());
        cell = row.createCell(1);
        cell.setCellValue(KH.getTenKH());
        cell = row.createCell(2);
        cell.setCellValue(KH.getSdt());

        HoaDonCT hoaDonCT = KH.getHoaDonCT();
        if (hoaDonCT != null) {
            cell = row.createCell(3);
            cell.setCellValue(hoaDonCT.getNgayMua());
            cell = row.createCell(5);
            cell.setCellValue(hoaDonCT.getSoLuong());
            cell = row.createCell(6);
            cell.setCellValue(hoaDonCT.getDonGia());
            cell = row.createCell(7);
            cell.setCellValue(hoaDonCT.getTongTien());
            cell = row.createCell(8);
            cell.setCellValue(hoaDonCT.getTrangThai());
        }

        SanPham sanPham = KH.getSanpham();
        if (sanPham != null) {
            cell = row.createCell(4);
            cell.setCellValue(sanPham.getTenSP());
        }
    }

    try {
        File f = new File("D:\\InHoaDon.xlsx");
        FileOutputStream fis = new FileOutputStream(f);
        workbook.write(fis);
        fis.close();
        JOptionPane.showMessageDialog(null, "In Thành Công");
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi mở file");
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi ghi file");
    }
    return list;
}
}
