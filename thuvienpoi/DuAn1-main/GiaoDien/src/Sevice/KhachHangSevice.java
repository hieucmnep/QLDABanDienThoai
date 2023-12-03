/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.KhachHang;
import dbconnect.DBConnector;
import java.sql.*;
import java.util.ArrayList;

public class KhachHangSevice {

    public ArrayList<KhachHang> GetAll() {
        ArrayList<KhachHang> KH = new ArrayList<>();
        Connection cnt = DBConnector.getConnection();
        String Sql = "SELECT*From KhachHang";
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
                kh.getTrangThai();
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

    public void Insert(KhachHang kh) {
        try {
            Connection cnt = DBConnector.getConnection();
            PreparedStatement psm = cnt.prepareStatement("INSERT INTO KHACHHANG (MAKH, TENKH, NGAYSINH, GIOITINH, SDT, TRANGTHAI, DIACHI, EMAIL) values (?,?,?,?,?,?,?,?)");
            psm.setString(0, kh.getMaKH());
            psm.setString(1, kh.getTenKH());
            psm.setString(2, kh.getGioiTinh());
            psm.setString(3, kh.getSdt());
            psm.setString(4, kh.getEmail());
//            psm.setDate(5, Date.valueOf(kh.getNgaySinh();
            psm.setString(6, kh.getDiaChi());
            psm.setInt(7, kh.getTrangThai());

            psm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete(KhachHang kh) {
        try {
            Connection cnt = DBConnector.getConnection();
            PreparedStatement psm = cnt.prepareStatement("delete khachhang where MaKH Like ?");
            psm.setString(1, kh.getMaKH() );
            psm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ID(String ID) {
        boolean a2 = false;
        try {
            Connection cnt = DBConnector.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("select MaKH from NhanVien where MaKH like '" + ID + "'");
            while (rs.next()) {
                if (rs.getString(1).equals(ID)) {
                    a2 = true;
                    break;
                } else {
                    a2 = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a2;
    }

    }
