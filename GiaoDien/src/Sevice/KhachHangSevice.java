/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.HoaDonCT;
import Model.KhachHang;
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
//            psm.setInt(1, kh.getId());
            psm.setString(1, kh.getMaKH());
            psm.setString(2, kh.getTenKH());
            psm.setDate(3, Date.valueOf(kh.getNgaySinh()));
            psm.setString(4, kh.getGioiTinh());
            psm.setString(5, kh.getSdt());
            psm.setBoolean(6, kh.isTrangThai());
            psm.setString(7, kh.getDiaChi());
            psm.setString(8, kh.getEmail());

            row = psm.executeUpdate();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer Delete(KhachHang kh) {
        int idToDelete = 1; // Đặt giá trị cần xóa
        try {
            Connection cnt = DBConnector.getConnection();
            String sql = "DELETE FROM KhachHang WHERE IDKH = ?";
            PreparedStatement psm = cnt.prepareStatement(sql);
            psm.setInt(1, idToDelete);
            int rowsAffected = psm.executeUpdate();
            psm.close();
            cnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idToDelete;
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
            row = psm.executeUpdate();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
 public ArrayList<KhachHang> InHoaDon() {
        ArrayList<KhachHang> list = GetAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row;
        Cell cell;

        // write the column headers
        row = sheet.createRow(0);
        String[] headers = {"MAHD", "MASPCT", "DONGIA", "SOLUONG", "TIENKHACHDUA", "TIENTRALAI", "NGAYMUA", "HINHTHUCTHANHTOAN", "TONGTIEN", "TRANGTHAI", "GHICHU", "GIAMGIA"};
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
            File f = new File("D://danhsach.xlsx");
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
        String sql = "SELECT * FROM KHACHHANG where MAKH = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ma); // Thiết lập giá trị cho tham số 1
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
        return lskh ;
    }

     public ArrayList<KhachHang> timKiemTenKH(String Ten) {
        ArrayList<KhachHang> lskh = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM KHACHHANG where TenKH = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, Ten); // Thiết lập giá trị cho tham số 1
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
        return lskh ;
    }
     public ArrayList<KhachHang> timKiemNgaySinh(String NgaySinh) {
        ArrayList<KhachHang> lskh = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM KHACHHANG where NGAYSINH = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, NgaySinh); // Thiết lập giá trị cho tham số 1
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
        return lskh ;
    }
}
