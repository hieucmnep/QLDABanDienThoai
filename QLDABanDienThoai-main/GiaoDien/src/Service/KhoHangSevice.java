/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.HoaDonCT;
import Model.KhachHang;
import Model.KhoHang;
import Model.SanPhamCT;
import dbconnect.DBConnector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author hieu9
 */
public class KhoHangSevice {

    public ArrayList<KhoHang> joinSPKH() {
        ArrayList<KhoHang> KH = new ArrayList<>();
        Connection cnt = DBConnector.getConnection();
        String sql = "SELECT SANPHAM.MASP,TENSP,GIA,NGAYNHAP,SUM(SANPHAMCT.SOLUONG) as TONG\n"
                + "FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                + "where (SANPHAMCT.SOLUONG)  > 0 \n"
                + "Group by NGAYNHAP,SANPHAM.MASP,TENSP,GIA";
        try {
            PreparedStatement psm = cnt.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                KhoHang kh = new KhoHang();
                kh.setMasp(rs.getString(1));
                kh.setTenSp(rs.getString(2));
                kh.setGia(rs.getFloat(3));
                kh.setSoluong(rs.getInt(5));
                SanPhamCT sp = new SanPhamCT();
                sp.setNgayNhap(rs.getDate(4));
                kh.setSp(sp);

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

    public ArrayList<KhoHang> searchJoinSPKH(String searchString) {
        ArrayList<KhoHang> khm = new ArrayList<>();
        Connection cnt = DBConnector.getConnection();
        String sql = "SELECT SANPHAM.MASP, TENSP, GIA, NGAYNHAP, SUM(SANPHAMCT.SOLUONG) as TONG \n"
                + "FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                + "WHERE TENSP LIKE ? OR SANPHAM.MASP LIKE ?\n"
                + "GROUP BY SANPHAM.MASP, TENSP, GIA, NGAYNHAP";

        try {
            PreparedStatement psm = cnt.prepareStatement(sql);

            psm.setString(1, "%" + searchString + "%");
            psm.setString(2, "%" + searchString + "%");

            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                KhoHang kh = new KhoHang();
                kh.setMasp(rs.getString(1));
                kh.setTenSp(rs.getString(2));
                kh.setGia(rs.getFloat(3));
                kh.setSoluong(rs.getInt(5));
                SanPhamCT sp = new SanPhamCT();
                sp.setNgayNhap(rs.getDate(4));
                kh.setSp(sp);

                khm.add(kh);
            }
            psm.close();
            rs.close();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khm;
    }
}
