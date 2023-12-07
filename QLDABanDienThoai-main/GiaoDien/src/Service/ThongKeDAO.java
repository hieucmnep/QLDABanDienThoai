package Sevice;

import Model.ThongKe;
import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ThongKeDAO {
    public ArrayList<ThongKe> getAllThongKe() {
        ArrayList<ThongKe> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT MAHD, TONGTIEN, NGAYMUA, TRANGTHAI FROM HOADONCT";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaHD(rs.getString("MAHD"));
                tk.setNgaydat(rs.getString("NGAYMUA"));
                tk.setTongTien(rs.getFloat("TONGTIEN"));
                tk.setTrangThai(rs.getString("TRANGTHAI"));
                lsnv.add(tk);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsnv;
    }
    
    public ArrayList<ThongKe> timKiemTheoTT(String trangThai) {
        ArrayList<ThongKe> lstk = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT MAHD, TONGTIEN, NGAYMUA, TRANGTHAI FROM HOADONCT WHERE TRANGTHAI = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, trangThai); // Thiết lập giá trị cho tham số 1
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaHD(rs.getString("MAHD"));
                tk.setNgaydat(rs.getString("NGAYMUA"));
                tk.setTongTien(rs.getFloat("TONGTIEN"));
                tk.setTrangThai(rs.getString("TRANGTHAI"));
                lstk.add(tk);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstk;
    }
    
    public ArrayList<ThongKe> timKiemNgayTao(String NgayTao) {
        ArrayList<ThongKe> lstk = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT * FROM HOADONCT where NGAYMUA = ?";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, NgayTao); // Thiết lập giá trị cho tham số 1
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaHD(rs.getString("MAHD"));
                tk.setNgaydat(rs.getString("NGAYMUA"));
                tk.setTongTien(rs.getFloat("TONGTIEN"));
                tk.setTrangThai(rs.getString("TRANGTHAI"));
                lstk.add(tk);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstk;
    }
    
    public ArrayList<ThongKe> TongHD() {
        ArrayList<ThongKe> lsnv = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT COUNT(DISTINCT MAHD) AS TONGSOHOADON FROM HOADONCT";
        Statement st;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaHD(rs.getString("TONGSOHOADON"));
                lsnv.add(tk);
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
