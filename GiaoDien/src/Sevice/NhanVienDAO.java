package Sevice;

import Model.NhanVien;
import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NhanVienDAO{
 
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
    
}

