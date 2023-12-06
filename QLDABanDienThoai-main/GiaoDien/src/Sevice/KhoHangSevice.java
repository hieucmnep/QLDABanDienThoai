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
        String sql = "SELECT KHOHANG.MASP, KHOHANG.TENSP, KHOHANG.GIA, KHOHANG.SOLUONG, SANPHAMCT.NGAYNHAP\n"
                + "FROM KHOHANG\n"
                + "JOIN SANPHAMCT ON KHOHANG.MASP = SANPHAMCT.MASP;";
        try {
            PreparedStatement psm = cnt.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                KhoHang kh = new KhoHang();
                kh.setMasp(rs.getString("MASP"));
                kh.setTenSp(rs.getString("TENSP"));
                kh.setGia(rs.getFloat("GIA"));
                kh.setSoluong(rs.getInt("SOLUONG"));

                SanPhamCT sp = new SanPhamCT();
                sp.setNgayNhap(rs.getDate("NGAYNHAP"));
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

  public ArrayList<KhoHang> searchSPKH(String searchString) {
    ArrayList<KhoHang> KH = new ArrayList<>();
    Connection cnt = DBConnector.getConnection();
    String sql = "SELECT KHOHANG.MASP, KHOHANG.TENSP, KHOHANG.GIA, KHOHANG.SOLUONG, SANPHAMCT.NGAYNHAP\n"
            + "FROM KHOHANG\n"
            + "JOIN SANPHAMCT ON KHOHANG.MASP = SANPHAMCT.MASP\n"
            + "WHERE KHOHANG.TENSP LIKE ? OR KHOHANG.MASP LIKE ?;";  // Add more conditions as needed

    try {
        PreparedStatement psm = cnt.prepareStatement(sql);
        // Set the search parameters
        psm.setString(1, "%" + searchString + "%");
        psm.setString(2, "%" + searchString + "%");

        ResultSet rs = psm.executeQuery();
        while (rs.next()) {
            KhoHang kh = new KhoHang();
            kh.setMasp(rs.getString("MASP"));
            kh.setTenSp(rs.getString("TENSP"));
            kh.setGia(rs.getFloat("GIA"));
            kh.setSoluong(rs.getInt("SOLUONG"));

            SanPhamCT sp = new SanPhamCT();
            sp.setNgayNhap(rs.getDate("NGAYNHAP"));
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


}
