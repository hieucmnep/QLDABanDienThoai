package Sevice;

import Model.NhanVien;
import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class NhanVienResponsitory implements NhanVienInterface<NhanVien> {

    private Connection conn;

    public NhanVienResponsitory() {
        try {
            conn = DBConnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try {
            String query = "SELECT MANV,TENNV,NGAYSINH,DIACHI,SDT,CCCD,CHUCVU,GIOITINH,EMAIL,TRANGTHAI,LUONG,HINHANH FROM NHANVIEN";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMANV(rs.getString("MANV"));
                nv.setTENNV(rs.getString("TENNV"));
                nv.setNGAYSINH(rs.getString("NGAYSINH"));
                nv.setDIACHI(rs.getString("DIACHI"));
                nv.setSDT(rs.getString("SDT"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setCHUCVU(rs.getString("CHUCVU"));
                nv.setGIOITINH(rs.getString("GIOITINH"));
                nv.setEMAIL(rs.getString("EMAIL"));
                nv.setTRANGTHAI(rs.getString("TRANGTHAI"));
                nv.setLuong(rs.getInt("LUONG"));
                nv.setHINHANH(rs.getString("HINHANH"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(NhanVien nhanVien) {
        try {
            String query = "INSERT INTO NHANVIEN (MANV, TENNV, NGAYSINH, SDT, CHUCVU, DIACHI, CCCD, EMAIL, GIOITINH, TRANGTHAI,LUONG, HINHANH)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, nhanVien.getMANV());
            ps.setObject(2, nhanVien.getTENNV());
            ps.setObject(3, nhanVien.getNGAYSINH());
            ps.setObject(4, nhanVien.getSDT());
            ps.setObject(5, nhanVien.getCHUCVU());
            ps.setObject(6, nhanVien.getDIACHI());
            ps.setObject(7, nhanVien.getCCCD());
            ps.setObject(8, nhanVien.getEMAIL());
            ps.setObject(9, nhanVien.getGIOITINH());
            ps.setObject(10, nhanVien.getTRANGTHAI());
            ps.setObject(11, nhanVien.getLuong());
            ps.setObject(12, nhanVien.getHINHANH());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(NhanVien index) {
        try {
            String query = "DELETE NHANVIEN WHERE MANV = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, index.getMANV());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void update(NhanVien nhanVien) {
        try {
            String query = "UPDATE NHANVIEN\n"
                    + "SET MANV =? , TENNV = ?, NGAYSINH = ?, SDT = ?, CHUCVU = ? , DIACHI = ? , CCCD = ?, EMAIL =? ,GIOITINH =?, TRANGTHAI =?, LUONG =?,HINHANH =? \n"
                    + "WHERE =?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, nhanVien.getTENNV());
            ps.setObject(2, nhanVien.getNGAYSINH());
            ps.setObject(3, nhanVien.getSDT());
            ps.setObject(4, nhanVien.getCHUCVU());
            ps.setObject(5, nhanVien.getDIACHI());
            ps.setObject(6, nhanVien.getCCCD());
            ps.setObject(7, nhanVien.getEMAIL());
            ps.setObject(8, nhanVien.getGIOITINH());
            ps.setObject(9, nhanVien.getTRANGTHAI());
            ps.setObject(10, nhanVien.getLuong());
            ps.setObject(11, nhanVien.getHINHANH());
            ps.setObject(12, nhanVien.getMANV());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isMaNVExists(int maNV) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
