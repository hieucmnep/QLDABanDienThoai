/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.SPChiTiet;
import Model.SanPhamCT;
import Model.SanPham_model;
import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 *
 * @author ADMIN
 */
public class SPchitiet_sql {

    SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/yyyy");

    public ArrayList<SanPham_model> getlistspct() {
        ArrayList<SanPham_model> listspct = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT SANPHAM.MASP,TENSP,THUONGHIEU,CHIP,CAMERA,KICHTHUOC,CHATLIEU,HEDIEUHANH,DUNGLUONGPIN,GIA,TRANGTHAI,\n"
                + "				HINHSP,LOAIRAM,TENMAU,NOISANXUAT,NGAYNHAP,SOLUONG\n"
                + "                     FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                + "				JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                + "				JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM\n"
                + "				JOIN NOISANXUAT ON SANPHAMCT.MANSX = NOISANXUAT.MANSX";
        PreparedStatement stm;
        try {
            stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham_model spct = new SanPham_model();
                spct.setMasp(rs.getString(1));
                spct.setTensp(rs.getString(2));
                spct.setThuonghieu(rs.getString(3));
                spct.setChip(rs.getString(4));
                spct.setCamera(rs.getString(5));
                spct.setKichthuoc(rs.getString(6));
                spct.setChatlieu(rs.getString(7));
                spct.setHdh(rs.getString(8));
                spct.setPin(rs.getString(9));
                spct.setGia(rs.getFloat(10));
                spct.setTrangthai(rs.getInt(11));
                spct.setHinhanh(rs.getString(12));
//                spct.setSpct(new SanPhamCT(rs.getString(13), rs.getString(14), rs.getString(15),
//                        rs.getDate(16), rs.getInt(17)));
                spct.setSpct(new SPChiTiet(rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getDate(16), rs.getInt(17)));
                listspct.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspct;
    }

    public Integer Them(SanPham_model sp) {
        Integer row = null;
        try {
            Connection cn = DBConnector.getConnection();
            String sql = "INSERT INTO SANPHAM (MASP, TENSP, THUONGHIEU, CHIP, CAMERA, KICHTHUOC, CHATLIEU, HEDIEUHANH, DUNGLUONGPIN, GIA, TRANGTHAI, HINHSP)\n"
                    + "VALUES	(?, ?,?,?,?,?,?,?,?,?, ?, ?)\n"
                    + "INSERT INTO SANPHAMCT (MASPCT,MAMAU, MASP, MARAM, MANSX, NGAYNHAP, SOLUONG, GIANHAP)\n"
                    + "VALUES	(?,?,?,?,?,?,?,?)";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, sp.getMasp());
            stm.setString(2, sp.getTensp());
            stm.setString(3, sp.getThuonghieu());
            stm.setString(4, sp.getChip());
            stm.setString(5, sp.getCamera());
            stm.setString(6, sp.getKichthuoc());
            stm.setString(7, sp.getPin());
            stm.setFloat(8, sp.getGia());
            stm.setInt(9, sp.getTrangthai());
            stm.setString(11, sp.getHinhanh());
            stm.setString(12, sp.getSpct().getMaspct());
            stm.setString(13, sp.getSpct().getMausac());
            stm.setString(14, sp.getMasp());
            stm.setString(15, sp.getSpct().getLoairam());
            stm.setString(16, sp.getHinhanh());
            stm.setString(17, sp.getHinhanh());
            stm.setString(18, sp.getHinhanh());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
     public ArrayList<SanPham_model> getspct() {
        ArrayList<SanPham_model> listspct = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM SANPHAM\n"
                + "SELECT SANPHAMCT.MASPCT,TENMAU,LOAIRAM,NOISANXUAT,NGAYNHAP,SOLUONG,GIANHAP\n"
                + "FROM SANPHAMCT JOIN NOISANXUAT ON SANPHAMCT.MANSX = NOISANXUAT.MANSX\n"
                + "	JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                + "	JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM";
        PreparedStatement stm;
        try {
            stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham_model spct = new SanPham_model();
                spct.setMasp(rs.getString("MASP"));
                spct.setTensp(rs.getString("TENSP"));
                spct.setThuonghieu(rs.getString("THUONGHIEU"));
                spct.setChip(rs.getString("CHIP"));
                spct.setCamera(rs.getString("CAMERA"));
                spct.setKichthuoc(rs.getString("KICHTHUOC"));
                spct.setChatlieu(rs.getString("CHATLIEU"));
                spct.setHdh(rs.getString("HEDIEUHANH"));
                spct.setPin(rs.getString("DUNGLUONGPIN"));
                spct.setGia(rs.getFloat("GIA"));
                spct.setTrangthai(rs.getInt("TRANGTHAI"));
                spct.setHinhanh(rs.getString("HINHSP"));

                spct.getSpct().setMaspct(rs.getString("MASPCT"));
                spct.getSpct().setMausac(rs.getString("TENMAU"));
                spct.getSpct().setLoairam(rs.getString("LOAIRAM"));
                spct.getSpct().setNhasx(rs.getString("NOISANXUAT"));
                spct.getSpct().setNgaynhap(rs.getDate("NGAYNHAP"));
                spct.getSpct().setSoluong(rs.getInt("SOLUONG"));
                spct.getSpct().setGianhap(rs.getFloat("GIANHAP"));
                listspct.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspct;
    }
}
