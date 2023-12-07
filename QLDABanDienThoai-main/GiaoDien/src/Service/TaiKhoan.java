package Service;

import Model.NhanVienYk;
import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import view.NhanVien;

public class TaiKhoan {

    public ArrayList<NhanVienYk> timKiemMaTK(String ma) {
        ArrayList<NhanVienYk> lsnv = new ArrayList<>();

        try {

            Connection cn = DBConnector.getConnection();
            String sql = "SELECT NHANVIEN.MANV,TAIKHOAN.MatKhau\n"
                    + "FROM NHANVIEN\n"
                    + "JOIN TAIKHOAN ON NHANVIEN.MANV = TAIKHOAN.MANV;";

            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        NhanVienYk nv = new NhanVienYk();
                        nv.setMaNV(rs.getString("MANV"));
                        nv.setMatKhau(rs.getString("MatKhau"));
                        lsnv.add(nv);
                    }
                }
            }

            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lsnv;
    }

    public boolean themTaiKhoanFromNhanVien(NhanVienYk nv) {
        try (Connection cn = DBConnector.getConnection()) {
            String sql = "INSERT INTO TAIKHOAN (MANV, MatKhau, VaiTro) VALUES (?, ?, ?)";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, nv.getMaNV());
                ps.setString(2, "DefaultPassword");
                ps.setBoolean(3, nv.isVaiTro());

                int row = ps.executeUpdate();

                return row > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
