/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.HoaDonCT;
import dbconnect.DBConnector;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class HoaDonCTDAO {

    public ArrayList<HoaDonCT> getAllHoaDonCT() {
        ArrayList<HoaDonCT> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM HOADONCT";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaSPCT(rs.getString("MASPCT"));
                hdct.setDonGia(rs.getFloat("DONGIA"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));
                hdct.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                hdct.setTienTraLai(rs.getFloat("TIENTRALAI"));
                hdct.setNgayMua(rs.getString("NGAYMUA"));
                hdct.setHinhThucTT(rs.getString("HINHTHUCTHANHTOAN"));
                hdct.setTongTien(rs.getFloat("TONGTIEN"));
                hdct.setTrangThai(rs.getString("TRANGTHAI"));
                hdct.setGhiChu(rs.getString("GHICHU"));
                hdct.setGiamGia(rs.getString("GIAMGIA"));
                lsnv.add(hdct);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsnv;
    }

    public ArrayList<HoaDonCT> timKiemMaHD(String ma) {
        ArrayList<HoaDonCT> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM HOADONCT where MAHD = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ma); // Thiết lập giá trị cho tham số 1
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaSPCT(rs.getString("MASPCT"));
                hdct.setDonGia(rs.getFloat("DONGIA"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));
                hdct.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                hdct.setTienTraLai(rs.getFloat("TIENTRALAI"));
                hdct.setNgayMua(rs.getString("NGAYMUA"));
                hdct.setHinhThucTT(rs.getString("HINHTHUCTHANHTOAN"));
                hdct.setTongTien(rs.getFloat("TONGTIEN"));
                hdct.setTrangThai(rs.getString("TRANGTHAI"));
                hdct.setGhiChu(rs.getString("GHICHU"));
                hdct.setGiamGia(rs.getString("GIAMGIA"));
                lsnv.add(hdct);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsnv;
    }

    public ArrayList<HoaDonCT> timKiemMaSP(String maSP) {
        ArrayList<HoaDonCT> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM HOADONCT where MASP = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, maSP); // Thiết lập giá trị cho tham số 1
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaSPCT(rs.getString("MASPCT"));
                hdct.setDonGia(rs.getFloat("DONGIA"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));
                hdct.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                hdct.setTienTraLai(rs.getFloat("TIENTRALAI"));
                hdct.setNgayMua(rs.getString("NGAYMUA"));
                hdct.setHinhThucTT(rs.getString("HINHTHUCTHANHTOAN"));
                hdct.setTongTien(rs.getFloat("TONGTIEN"));
                hdct.setTrangThai(rs.getString("TRANGTHAI"));
                hdct.setGhiChu(rs.getString("GHICHU"));
                hdct.setGiamGia(rs.getString("GIAMGIA"));
                lsnv.add(hdct);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsnv;
    }

    public ArrayList<HoaDonCT> timKiemNgayTao(String NgayTao) {
        ArrayList<HoaDonCT> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM HOADONCT where NGAYMUA = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, NgayTao); // Thiết lập giá trị cho tham số 1
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaSPCT(rs.getString("MASPCT"));
                hdct.setDonGia(rs.getFloat("DONGIA"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));
                hdct.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                hdct.setTienTraLai(rs.getFloat("TIENTRALAI"));
                hdct.setNgayMua(rs.getString("NGAYMUA"));
                hdct.setHinhThucTT(rs.getString("HINHTHUCTHANHTOAN"));
                hdct.setTongTien(rs.getFloat("TONGTIEN"));
                hdct.setTrangThai(rs.getString("TRANGTHAI"));
                hdct.setGhiChu(rs.getString("GHICHU"));
                hdct.setGiamGia(rs.getString("GIAMGIA"));
                lsnv.add(hdct);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsnv;
    }

    public ArrayList<HoaDonCT> timKiemTheoTT(String trangThai) {
        ArrayList<HoaDonCT> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM HOADONCT WHERE TRANGTHAI = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, trangThai); // Thiết lập giá trị cho tham số 1
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaHD(rs.getString("MAHD"));
                hdct.setMaSPCT(rs.getString("MASPCT"));
                hdct.setDonGia(rs.getFloat("DONGIA"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));
                hdct.setTienKhachDua(rs.getFloat("TIENKHACHDUA"));
                hdct.setTienTraLai(rs.getFloat("TIENTRALAI"));
                hdct.setNgayMua(rs.getString("NGAYMUA"));
                hdct.setHinhThucTT(rs.getString("HINHTHUCTHANHTOAN"));
                hdct.setTongTien(rs.getFloat("TONGTIEN"));
                hdct.setTrangThai(rs.getString("TRANGTHAI"));
                hdct.setGhiChu(rs.getString("GHICHU"));
                hdct.setGiamGia(rs.getString("GIAMGIA"));
                lsnv.add(hdct);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsnv;
    }

    public ArrayList<HoaDonCT> InHoaDon() {
        ArrayList<HoaDonCT> list = getAllHoaDonCT();
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
            HoaDonCT hdct = list.get(r);
            cell = row.createCell(0);
            cell.setCellValue(hdct.getMaHD());
            cell = row.createCell(1);
            cell.setCellValue(hdct.getMaSPCT());
            cell = row.createCell(2);
            cell.setCellValue(hdct.getDonGia());
            cell = row.createCell(3);
            cell.setCellValue(hdct.getSoLuong());
            cell = row.createCell(4);
            cell.setCellValue(hdct.getTienKhachDua());
            cell = row.createCell(5);
            cell.setCellValue(hdct.getTienTraLai());
            cell = row.createCell(6);
            cell.setCellValue(hdct.getNgayMua());
            cell = row.createCell(7);
            cell.setCellValue(hdct.getHinhThucTT());
            cell = row.createCell(8);
            cell.setCellValue(hdct.getTongTien());
            cell = row.createCell(9);
            cell.setCellValue(hdct.getTrangThai());
            cell = row.createCell(10);
            cell.setCellValue(hdct.getGhiChu());
            cell = row.createCell(11);
            cell.setCellValue(hdct.getGiamGia());
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
}
