/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.KhachHang;
import dbconnect.DBConnector;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
            psm.setInt(1, kh.getId());
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
            psm.setDate(4, Date.valueOf(kh.getNgaySinh()));
            psm.setString(4, kh.getGioiTinh());
            psm.setString(5, kh.getSdt());
            psm.setBoolean(6, kh.isTrangThai());
            psm.setString(7, kh.getDiaChi());
            psm.setString(8, kh.getEmail());
            psm.setInt(9, kh.getId());

            row = psm.executeUpdate();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public List<KhachHang> search(String keyword) {
        List<KhachHang> results = new ArrayList<>();
        Connection cnt = DBConnector.getConnection();
        String sql = "SELECT * FROM KhachHang WHERE MAKH LIKE ? OR TENKH LIKE ?";
        try {
            PreparedStatement psm = cnt.prepareStatement(sql);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");

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
                kh.setTrangThai(rs.getBoolean("TrangThai"));
                results.add(kh);
            }

            psm.close();
            rs.close();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

//    public Integer Jonbang(KhachHang kh) {
//        String query = "SELECT HOADON.ID, TenKH, SDT, NgayGD, TenSP, SoLuong, GiaBan, TongTien, TrangThai "
//                + "FROM HOADON "
//                + "JOIN HOADONCT ON HOADON.ID = HOADONCT.MAHD";
//        try {
//            Connection cnt = DBConnector.getConnection();
//            PreparedStatement psm = cnt.prepareStatement(query);
//
//            // Execute the query and get the result set
//            ResultSet = psm.executeQuery();
//
//            // Process the result set
//            while (resultSet.next()) {
//                String id = resultSet.getString("ID");
//                String tenKH = resultSet.getString("TenKH");
//                String sdt = resultSet.getString("SDT");
//                String ngayGD = resultSet.getString("NgayGD");
//                String tenSP = resultSet.getString("TenSP");
//                int soLuong = resultSet.getInt("SoLuong");
//                float giaBan = resultSet.getFloat("GiaBan");
//                float tongTien = resultSet.getFloat("TongTien");
//                boolean trangThai = resultSet.getBoolean("TrangThai");
//
//                // Process the retrieved data as needed
//                System.out.println(id + ", " + tenKH + ", " + sdt + ", " + ngayGD + ", "
//                        + tenSP + ", " + soLuong + ", " + giaBan + ", "
//                        + tongTien + ", " + trangThai);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Close resources in reverse order of their creation
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//} catch (Exception e) {
//        }
}
