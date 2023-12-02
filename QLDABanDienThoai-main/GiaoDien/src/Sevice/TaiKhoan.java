package Sevice;

import Model.NhanVien;
import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TaiKhoan {

    public ArrayList<NhanVien> timKiemMaTK(String ma) {
        ArrayList<NhanVien> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM TaiKhoan where MaTK = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ma); // Thiết lập giá trị cho tham số 1
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaTK(rs.getString("MaTK"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setVaiTro(rs.getBoolean("VaiTro"));
                lsnv.add(nv);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsnv;
    }

    public boolean themTaiKhoan(NhanVien nv) {
        Connection cn = DBConnector.getConnection();
        String sql = "INSERT INTO TaiKhoan (MaTK, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nv.getMaTK());
            ps.setString(2, nv.getMatKhau());
            ps.setString(3, nv.getHoTen());
            ps.setBoolean(4, nv.isVaiTro());

            int rowsAffected = ps.executeUpdate();

            // Đóng tất cả các tài nguyên
            ps.close();
            cn.close();

            // Trả về true nếu có ít nhất một dòng được thêm vào cơ sở dữ liệu
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
