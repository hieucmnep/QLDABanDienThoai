package Sevice;

import Model.NhanVienModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;

public class NhanVienService {

    private Connection conn;
    ArrayList<NhanVienModel> list = new ArrayList<>();

    public NhanVienService() {
        try {
            conn = dbconnect.DBConnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<NhanVienModel> getAll() {
        list.clear();
        try {
            String query = "SELECT * FROM NHANVIEN";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setMANV(rs.getString("MANV"));
                nv.setTENNV(rs.getString("TENNV"));
                nv.setNGAYSINH(rs.getDate("NGAYSINH"));
                nv.setDIACHI(rs.getString("DIACHI"));
                nv.setSDT(rs.getString("SDT"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setCHUCVU(rs.getString("CHUCVU"));
                nv.setGIOITINH(rs.getString("GIOITINH"));
                nv.setEMAIL(rs.getString("EMAIL"));
                nv.setTRANGTHAI(rs.getString("THAMNIEN"));
                nv.setLuong(rs.getInt("LUONGCB"));
                nv.setHINHANH(rs.getString("HINHANH"));
                list.add(nv);
                // ps.close();
                //rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(NhanVienModel nhanVien) {
        // List<NhanVien> list = new ArrayList<>();
        try {
            list.clear();
            String query = "INSERT INTO NHANVIEN (MANV, TENNV, NGAYSINH, SDT, CHUCVU, DIACHI, CCCD, EMAIL, GIOITINH, THAMNIEN,LUONGCB, HINHANH)\n"
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

    public void remove(NhanVienModel index) {
        list.clear();
        try {
            String query = "DELETE NHANVIEN WHERE MANV = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, index.getMANV());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     *
     * @param nhanVien
     * @return
     */
    public void update(NhanVienModel nhanVien) {
        list.clear();
        try {
            String query = "UPDATE NHANVIEN\n"
                    + "SET TENNV = ?, NGAYSINH = ?, SDT = ?, CHUCVU = ? , DIACHI = ? , CCCD = ?, EMAIL =? ,GIOITINH =?, THAMNIEN =?, LUONGCB =?,HINHANH =? \n"
                    + "WHERE MANV =?";
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
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isMaNVExists(String maNV) {
        try {
            String query = "SELECT COUNT(*) FROM NHANVIEN WHERE MANV = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Trả về true nếu mã nhân viên đã tồn tại, ngược lại trả về false.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu có lỗi xảy ra hoặc mã không tồn tại.

    }

    public void searchById(String id) {

    }

    public List<NhanVienModel> serchtheoTen(String name) {
        List<NhanVienModel> listByName = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE TENNV LIKE N'%" + name + "%'";
            PreparedStatement pstm = conn.prepareStatement(sql);
            // pstm.setString(1, nhanVien.getLocNhanVienTheoTen());
            rs = pstm.executeQuery();
            // Clear the existing items in the list before adding new search results
            while (rs.next()) {
                NhanVienModel nvResult = new NhanVienModel(); // Create a new NhanVienModel object for each row

                nvResult.setMANV(rs.getString("MANV"));
                nvResult.setTENNV(rs.getString("TENNV"));
                nvResult.setNGAYSINH(rs.getDate("NGAYSINH"));
                nvResult.setDIACHI(rs.getString("DIACHI"));
                nvResult.setSDT(rs.getString("SDT"));
                nvResult.setCCCD(rs.getString("CCCD"));
                nvResult.setCHUCVU(rs.getString("CHUCVU"));
                nvResult.setGIOITINH(rs.getString("GIOITINH"));
                nvResult.setEMAIL(rs.getString("EMAIL"));
                nvResult.setTRANGTHAI(rs.getString("THAMNIEN"));
                nvResult.setLuong((int) rs.getFloat("LUONGCB"));
                nvResult.setHINHANH(rs.getString("HINHANH"));
                listByName.add(nvResult);
            }

            // Đóng kết nối
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByName;
    }

    public List<NhanVienModel> serchtheoId(String id) {
        List<NhanVienModel> listById = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE MANV = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            // Clear the existing items in the list before adding new search results
            while (rs.next()) {
                NhanVienModel nvResult = new NhanVienModel(); // Create a new NhanVienModel object for each row

                nvResult.setMANV(rs.getString("MANV"));
                nvResult.setTENNV(rs.getString("TENNV"));
                nvResult.setNGAYSINH(rs.getDate("NGAYSINH"));
                nvResult.setDIACHI(rs.getString("DIACHI"));
                nvResult.setSDT(rs.getString("SDT"));
                nvResult.setCCCD(rs.getString("CCCD"));
                nvResult.setCHUCVU(rs.getString("CHUCVU"));
                nvResult.setGIOITINH(rs.getString("GIOITINH"));
                nvResult.setEMAIL(rs.getString("EMAIL"));
                nvResult.setTRANGTHAI(rs.getString("THAMNIEN"));
                nvResult.setLuong((int) rs.getFloat("LUONGCB"));
                nvResult.setHINHANH(rs.getString("HINHANH"));
                listById.add(nvResult);
            }

            // Đóng kết nối
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listById;
    }

    public List<NhanVienModel> serchTheoChucVu(String chucVu) {
        List<NhanVienModel> listByChucvu = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE CHUCVU LIKE N'%" + chucVu + "%'";
            PreparedStatement pstm = conn.prepareStatement(sql);
            // pstm.setString(1, chucVu);
            rs = pstm.executeQuery();
            // Clear the existing items in the list before adding new search results
            while (rs.next()) {
                NhanVienModel nvResult = new NhanVienModel(); // Create a new NhanVienModel object for each row

                nvResult.setMANV(rs.getString("MANV"));
                nvResult.setTENNV(rs.getString("TENNV"));
                nvResult.setNGAYSINH(rs.getDate("NGAYSINH"));
                nvResult.setDIACHI(rs.getString("DIACHI"));
                nvResult.setSDT(rs.getString("SDT"));
                nvResult.setCCCD(rs.getString("CCCD"));
                nvResult.setCHUCVU(rs.getString("CHUCVU"));
                nvResult.setGIOITINH(rs.getString("GIOITINH"));
                nvResult.setEMAIL(rs.getString("EMAIL"));
                nvResult.setTRANGTHAI(rs.getString("THAMNIEN"));
                nvResult.setLuong((int) rs.getFloat("LUONGCB"));
                nvResult.setHINHANH(rs.getString("HINHANH"));
                listByChucvu.add(nvResult);
            }

            // Đóng kết nối
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByChucvu;
    }

}
