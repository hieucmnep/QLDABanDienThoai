/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dbconnect.DBConnector;
import dbconnect.Mycombobox;
import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import view.SanPham;

public class Sanpham_sql {

    public ArrayList<SanPham_model> getlist() {
        ArrayList<SanPham_model> ls = new ArrayList<>();
        try {
            Connection cn = DBConnector.getConnection();
            String sql = "SELECT SANPHAM.MASP,TENSP,THUONGHIEU,GIA,TRANGTHAI,LOAIRAM,TENMAU,HINHSP\n"
                    + "FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                    + "JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                    + "JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM\n"
                    + "where SANPHAMCT.hidden = 1";
            PreparedStatement stm;
            stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham_model sp = new SanPham_model();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setThuonghieu(rs.getString(3));
                sp.setGia(rs.getFloat(4));
                sp.setTrangthai(rs.getInt(5));
                sp.setSpct(new SPChiTiet(rs.getString(6), rs.getString(7)));
                sp.setHinhanh(rs.getString(8));
                ls.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public ArrayList<Mycombobox> thuonghieu() {
        ArrayList<Mycombobox> lsth = new ArrayList<>();
        try {
            Connection cn = DBConnector.getConnection();
            String sql = "SELECT THUONGHIEU FROM SANPHAM";
            PreparedStatement stm;
            stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Mycombobox th = new Mycombobox();
                th.setThuonghieu(rs.getString(1));
                lsth.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsth;
    }


    public ArrayList<SanPham_model> serchtheoTen(String name,String ma) {
        ArrayList<SanPham_model> listByName = new ArrayList<>();
        ResultSet rs = null;
        Connection cn = DBConnector.getConnection();
        try {
            String sql = "SELECT SANPHAMCT.MASP,TENSP,THUONGHIEU,GIA,TRANGTHAI,LOAIRAM,TENMAU,HINHSP\n"
                    + "FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                    + "JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                    + "JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM\n"
                    + "where (TENSP LIKE N'%" + name + "%' or SANPHAMCT.MASP LIKE N'%" + ma + "%') AND SANPHAM.hidden = 1";
            PreparedStatement pstm = cn.prepareStatement(sql);
            //pstm.setString(1, name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham_model sp = new SanPham_model();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setThuonghieu(rs.getString(3));
                sp.setGia(rs.getFloat(4));
                sp.setTrangthai(rs.getInt(5));
                sp.setSpct(new SPChiTiet(rs.getString(6), rs.getString(7)));
                sp.setHinhanh(rs.getString(8));
                listByName.add(sp);
            }

            // Đóng kết nối
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByName;
    }

    public ArrayList<SanPham_model> serchtheoThuonghieu(String name) {
        ArrayList<SanPham_model> listByName = new ArrayList<>();
        ResultSet rs = null;
        Connection cn = DBConnector.getConnection();
        try {
            String sql = "SELECT SANPHAMCT.MASP,TENSP,THUONGHIEU,GIA,TRANGTHAI,LOAIRAM,TENMAU,HINHSP\n"
                    + "FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                    + "JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                    + "JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM\n"
                    + "where THUONGHIEU LIKE '%" + name + "%' AND SANPHAM.hidden = 1";
            PreparedStatement pstm = cn.prepareStatement(sql);
            //pstm.setString(1, "%" + name + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham_model sp = new SanPham_model();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setThuonghieu(rs.getString(3));
                sp.setGia(rs.getFloat(4));
                sp.setTrangthai(rs.getInt(5));
                sp.setSpct(new SPChiTiet(rs.getString(6), rs.getString(7)));
                sp.setHinhanh(rs.getString(8));
                listByName.add(sp);
            }
            // Đóng kết nối
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByName;
    }
    public ArrayList<SanPham_model> serchtheoBonho(String name) {
        ArrayList<SanPham_model> listByName = new ArrayList<>();
        ResultSet rs = null;
        Connection cn = DBConnector.getConnection();
        try {
            String sql = "SELECT SANPHAMCT.MASP,TENSP,THUONGHIEU,GIA,TRANGTHAI,LOAIRAM,TENMAU,HINHSP\n"
                    + "FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                    + "JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                    + "JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM\n"
                    + "where LOAIRAM LIKE '%" + name + "%'AND SANPHAM.hidden = 1" ;
            PreparedStatement pstm = cn.prepareStatement(sql);
            //pstm.setString(1, "%" + name + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham_model sp = new SanPham_model();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setThuonghieu(rs.getString(3));
                sp.setGia(rs.getFloat(4));
                sp.setTrangthai(rs.getInt(5));
                sp.setSpct(new SPChiTiet(rs.getString(6), rs.getString(7)));
                sp.setHinhanh(rs.getString(8));
                listByName.add(sp);
            }
            // Đóng kết nối
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByName;
    }
     public ArrayList<SanPham_model> serchtheoGia(float giamin,float giamax) {
        ArrayList<SanPham_model> listByName = new ArrayList<>();
        ResultSet rs = null;
        Connection cn = DBConnector.getConnection();
        try {
            String sql = "SELECT SANPHAMCT.MASP,TENSP,THUONGHIEU,GIA,TRANGTHAI,LOAIRAM,TENMAU,HINHSP\n"
                    + "FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                    + "JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                    + "JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM\n"
                    + "where (GIA BETWEEN "+giamin+" AND "+giamax+")AND SANPHAM.hidden = 1";
            PreparedStatement pstm = cn.prepareStatement(sql);
//            pstm.setString(1, giamax);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham_model sp = new SanPham_model();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setThuonghieu(rs.getString(3));
                sp.setGia(rs.getFloat(4));
                sp.setTrangthai(rs.getInt(5));
                sp.setSpct(new SPChiTiet(rs.getString(6), rs.getString(7)));
                sp.setHinhanh(rs.getString(8));
                listByName.add(sp);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByName;
    }
}
