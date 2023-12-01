/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.HoaDonCT;
import Model.KhachHang;
import Model.KhoHang;
import Model.SanPham;
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
        String sql = "SELECT DISTINCT KHOHANG.MASP, KHOHANG.TENSP, KHOHANG.SOLUONG, SANPHAM.HEDIEUHANH\n"
                + "FROM SANPHAM\n"
                + "JOIN KHOHANG ON SANPHAM.MASP = KHOHANG.MASP; ";
        try {
            PreparedStatement psm = cnt.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                KhoHang kh = new KhoHang();
                kh.setMasp(rs.getString("MASP"));
                kh.setTenSp(rs.getString("TENSP"));
                kh.setSoluong(rs.getInt("SOLUONG"));
                SanPham sp = new SanPham();
                sp.setHeDieuHanh(rs.getString("HEDIEUHANH"));
                kh.setSanpham(sp);
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

        public ArrayList<KhoHang> searchSPKH(String keyword) {
            ArrayList<KhoHang> KH = new ArrayList<>();
            Connection cnt = DBConnector.getConnection();
            String sql = "SELECT KHOHANG.MASP, KHOHANG.TENSP, SOLUONG, SANPHAM.HEDIEUHANH "
                    + "FROM SANPHAM JOIN KHOHANG ON SANPHAM.MASP = KHOHANG.MASP "
                    + "WHERE KHOHANG.MASP LIKE ? OR KHOHANG.TENSP LIKE ?";
            try {
                PreparedStatement psm = cnt.prepareStatement(sql);
                String likeKeyword = "%" + keyword + "%";
                psm.setString(1, likeKeyword);
                psm.setString(2, likeKeyword);

                ResultSet rs = psm.executeQuery();
                while (rs.next()) {
                    KhoHang kh = new KhoHang();
                    kh.setMasp(rs.getString("MASP"));
                    kh.setTenSp(rs.getString("TENSP"));
                    kh.setSoluong(rs.getInt("SOLUONG"));

                    SanPham sp = new SanPham();
                    sp.setHeDieuHanh(rs.getString("HEDIEUHANH"));
                    kh.setSanpham(sp);

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
}
