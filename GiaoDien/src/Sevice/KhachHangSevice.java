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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                kh.setNgaySinh(rs.getString("NGAYSINH"));
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
            psm.setInt(1, kh.getId());
            psm.setString(1, kh.getMaKH());
            psm.setString(2, kh.getTenKH());
            psm.setDate(8, Date.valueOf(kh.getNgaySinh()));
            psm.setString(4, kh.getGioiTinh());
            psm.setString(5, kh.getSdt());
            psm.setBoolean(6, kh.isTrangThai());
            psm.setString(7, kh.getDiaChi());
            psm.setString(3, kh.getEmail());

            row = psm.executeUpdate();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer Xoa(KhachHang kh) {
        Integer row = null;
        try {
            Connection cnt = DBConnector.getConnection();
            String sql = "DELETE NHANVIEN WHERE MAKH = ?";
            PreparedStatement ps = cnt.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.executeQuery();
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

            PreparedStatement psm = cnt.prepareStatement(sql);
            psm.setString(1, kh.getMaKH());
            psm.setString(2, kh.getTenKH());
            psm.setDate(3, Date.valueOf(kh.getNgaySinh()));
            psm.setString(4, kh.getGioiTinh());
            psm.setString(5, kh.getSdt());
            psm.setBoolean(6, kh.isTrangThai());
            psm.setString(7, kh.getDiaChi());
            psm.setString(8, kh.getEmail());
            psm.setInt(9, kh.getId());  // Adding the condition for WHERE clause

            row = psm.executeUpdate();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
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
                // Create a HoaDonCT object to store details from HOADONCT
                HoaDonCT so = new HoaDonCT();
                so.setNgayMua(rs.getString("NGAYMUA"));
                so.setSoLuong(rs.getInt("SOLUONG"));
                so.setDonGia(rs.getFloat("DONGIA"));
                so.setTongTien(rs.getFloat("TONGTIEN"));
                so.setTrangThai(rs.getString("TRANGTHAI"));
                SanPham sp =  new SanPham();
                sp.setTenSP(rs.getString("TenSP"));
                // Add the HoaDonCT object to KhachHang
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

    public ArrayList<KhachHang> InHoaDon() {
        ArrayList<KhachHang> list = GetAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row;
        Cell cell;

        // write the column headers
        row = sheet.createRow(0);
        String[] headers = {"IDKH", "TENKH", "DONGIA", "SDT", "NGAYMUA", "SOLUONG", "NGAYMUA", "DONGIA", "TONGTIEN", "TRANGTHAI"};
        for (int c = 0; c < headers.length; c++) {
            cell = row.createCell(c);
            cell.setCellValue(headers[c]);
        }

        // write the data rows
        for (int r = 0; r < list.size(); r++) {
            row = sheet.createRow(r + 1);
            KhachHang KH = list.get(r);
            cell = row.createCell(0);
            cell.setCellValue(KH.getMaKH());
            cell = row.createCell(1);
            cell.setCellValue(KH.getTenKH());
            cell = row.createCell(2);
            cell.setCellValue(KH.getNgaySinh());
            cell = row.createCell(3);
            cell.setCellValue(KH.getEmail());
            cell = row.createCell(4);
            cell.setCellValue(KH.getDiaChi());
            cell = row.createCell(5);
            cell.setCellValue(KH.getGioiTinh());
            cell = row.createCell(6);
            cell.setCellValue(KH.getSdt());
            cell = row.createCell(7);
            cell.setCellValue(KH.isTrangThai());
            cell = row.createCell(8);
        }

        try {
            File f = new File("D://danhsach.xlhd");
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

    public ArrayList<KhachHang> timKiemMaKH(String ma) {
        ArrayList<KhachHang> lskh = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ma);  // Use LIKE to search for partial matches
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("IDKH"));
                kh.setMaKH(rs.getString("MAKH"));
                kh.setTenKH(rs.getNString("TENKH"));
                kh.setGioiTinh(rs.getString("GIOITINH"));
                kh.setSdt(rs.getString("SDT"));
                kh.setEmail(rs.getString("EMAIL"));
                kh.setNgaySinh(rs.getString("NGAYSINH"));
                kh.setDiaChi(rs.getNString("DIACHI"));
                kh.setTrangThai(rs.getBoolean("TRANGTHAI"));
                lskh.add(kh);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lskh;
    }

}
