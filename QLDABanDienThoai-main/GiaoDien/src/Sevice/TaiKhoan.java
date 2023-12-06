package Sevice;

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
            String sql = "SELECT NHANVIEN.MANV, TAIKHOAN.VaiTro, TAIKHOAN.MatKhau "
                    + "FROM NHANVIEN "
                    + "JOIN TAIKHOAN ON NHANVIEN.MANV = TAIKHOAN.MANV "
                    + "WHERE NHANVIEN.MANV = ?";

            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, ma);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        NhanVienYk nv = new NhanVienYk();
                        nv.setMaNV(rs.getString("MANV"));
                        nv.setVaiTro(rs.getBoolean("VaiTro"));
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

    public boolean themTaiKhoan(NhanVienYk nv) {
    Connection cn = DBConnector.getConnection();
    String sql = "INSERT INTO TaiKhoan (MANV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
    try {
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nv.getMaNV());
        ps.setString(2, nv.getMatKhau());
        if (nv.getHoTen() != null) {
            ps.setString(3, nv.getHoTen());
        } else {
            ps.setString(3, "");
        }

        ps.setBoolean(4, nv.isVaiTro());

        int row = ps.executeUpdate();

        ps.close();
        cn.close();

        return row > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}


}
