/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.KhuyenMaii;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dbconnect.DBConnector;
import java.util.Random;

/**
 *
 * @author LE DINH LINH
 */
public class KhuyenMaiService {

    public List<KhuyenMaii> layTatCaKhuyenMai() {
        List<KhuyenMaii> danhSachKhuyenMai = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnector.getConnection();
            String sql = "SELECT * FROM KHUYENMAI";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String maKM = rs.getString("MAKM");
                String phanTramGiamGia = rs.getString("PhanTramGiamGia");
                int soLuong = rs.getInt("SoLuong");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");

                KhuyenMaii khuyenMai = new KhuyenMaii(maKM, phanTramGiamGia, soLuong, ngayBatDau, ngayKetThuc);
                danhSachKhuyenMai.add(khuyenMai);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các tài nguyên kết nối
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return danhSachKhuyenMai;
    }

    public KhuyenMaii timKhuyenMaiTheoMa(String maKM) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        KhuyenMaii khuyenMai = null;

        try {
            conn = DBConnector.getConnection();
            String sql = "SELECT * FROM KHUYENMAI WHERE MAKM = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maKM);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String phanTramGiamGia = rs.getString("PhanTramGiamGia");
                int soLuong = rs.getInt("SoLuong");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");

                khuyenMai = new KhuyenMaii(maKM, phanTramGiamGia, soLuong, ngayBatDau, ngayKetThuc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các tài nguyên kết nối
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return khuyenMai;
    }

    public void themKhuyenMai(String phanTramGiamGia, int soLuong, Date ngayBatDau, Date ngayKetThuc) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnector.getConnection();

            // Tạo mã khuyến mãi ngẫu nhiên với 3 chữ cái và 2 số
            String maKM = generateRandomCode();

            String sql = "INSERT INTO KHUYENMAI (MAKM, PhanTramGiamGia, SoLuong, NgayBatDau, NgayKetThuc) "
                    + "VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maKM);
            pstmt.setString(2, phanTramGiamGia);
            pstmt.setInt(3, soLuong);
            pstmt.setDate(4, new java.sql.Date(ngayBatDau.getTime()));
            pstmt.setDate(5, new java.sql.Date(ngayKetThuc.getTime()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các tài nguyên kết nối
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateRandomCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        StringBuilder randomCode = new StringBuilder();

        // Thêm 3 chữ cái ngẫu nhiên
        for (int i = 0; i < 3; i++) {
            randomCode.append(characters.charAt(new Random().nextInt(characters.length())));
        }

        // Thêm 2 số ngẫu nhiên
        for (int i = 0; i < 2; i++) {
            randomCode.append(numbers.charAt(new Random().nextInt(numbers.length())));
        }

        return randomCode.toString();
    }
    public void suaKhuyenMai(String maKM, String phanTramGiamGia, int soLuong, Date ngayBatDau, Date ngayKetThuc) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnector.getConnection();

            String sql = "UPDATE KHUYENMAI SET PhanTramGiamGia=?, SoLuong=?, NgayBatDau=?, NgayKetThuc=? WHERE MAKM=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phanTramGiamGia);
            pstmt.setInt(2, soLuong);
            pstmt.setDate(3, new java.sql.Date(ngayBatDau.getTime()));
            pstmt.setDate(4, new java.sql.Date(ngayKetThuc.getTime()));
            pstmt.setString(5, maKM);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các tài nguyên kết nối
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void xoaKhuyenMai(String maKM) {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DBConnector.getConnection();

        String sql = "DELETE FROM KHUYENMAI WHERE MAKM=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, maKM);

        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Đóng tất cả các tài nguyên kết nối
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}
