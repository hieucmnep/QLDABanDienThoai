package model;

import dbconnect.DBConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SPchitiet_sql {

    public ArrayList<SanPham_model> getlistspct() {
        ArrayList<SanPham_model> listspct = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "SELECT SANPHAM.MASP,TENSP,THUONGHIEU,CHIP,CAMERA,KICHTHUOC,CHATLIEU,HEDIEUHANH,DUNGLUONGPIN,GIA,TRANGTHAI,\n"
                + "				HINHSP,LOAIRAM,TENMAU,NOISANXUAT,NGAYNHAP,SOLUONG,SANPHAMct.MASPCT\n"
                + "                     FROM SANPHAMCT JOIN SANPHAM ON SANPHAMCT.MASP = SANPHAM.MASP\n"
                + "				JOIN MAUSAC ON SANPHAMCT.MAMAU = MAUSAC.MAMAU\n"
                + "				JOIN RAM ON SANPHAMCT.MARAM = RAM.MARAM\n"
                + "				JOIN NOISANXUAT ON SANPHAMCT.MANSX = NOISANXUAT.MANSX\n"
                                            + "where SANPHAMCT.hidden = 1";
        PreparedStatement stm;
        try {
            stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham_model spct = new SanPham_model();
                spct.setMasp(rs.getString(1));
                spct.setTensp(rs.getString(2));
                spct.setThuonghieu(rs.getString(3));
                spct.setChip(rs.getString(4));
                spct.setCamera(rs.getString(5));
                spct.setKichthuoc(rs.getString(6));
                spct.setChatlieu(rs.getString(7));
                spct.setHdh(rs.getString(8));
                spct.setPin(rs.getString(9));
                spct.setGia(rs.getFloat(10));
                spct.setTrangthai(rs.getInt(11));
                spct.setHinhanh(rs.getString(12));
                spct.setSpct(new SPChiTiet(rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getInt(17),rs.getString(18)));
                
                listspct.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspct;
    }

    public int Them(SanPham_model sp) {
            String mausac = sp.getSpct().getMausac();
            String ram = sp.getSpct().getLoairam();
            String noisx = sp.getSpct().getNhasx();
            // chuyển tên dữ liệu thành mã dữ liệu tương ứng  trong sql
            if(mausac.equals("Đen")){mausac = "MS001";}
            else if(mausac.equals("Trắng")){mausac = "MS002";}
            else if(mausac.equals("Đỏ")){mausac = "MS003";}
            else if(mausac.equals("Vàng")){mausac = "MS004";}
            else if(mausac.equals("Xám")){mausac = "MS005";}
            else if(mausac.equals("Xanh")){mausac = "MS006";}
            else if(mausac.equals("Nâu")){mausac = "MS007";}
            else if(mausac.equals("Hồng")){mausac = "MS008";}
            else if(mausac.equals("Tím")){mausac = "MS009";}
            // chuyển đổi loại ram 
            if(ram.equals("64GB")){ram = "RM001";}
            else if(ram.equals("128GB")){ram = "RM002";}
            else if(ram.equals("256GB")){ram = "RM003";}
            else if(ram.equals("512GB")){ram = "RM004";}
            else if(ram.equals("1T")){ram = "RM005";}
            // CHUYỂ ĐỔI NƠI SẢN XUẤT           
            if(noisx.equals("Việt Nam")){noisx = "NSX001";}
            else if(noisx.equals("Trung Quốc")){noisx = "NSX002";}
            else if(noisx.equals("Ấn Độ")){noisx = "NSX003";}
            else if(noisx.equals("Mỹ")){noisx = "NSX004";}
            else if(noisx.equals("Hàn quốc")){noisx = "NSX005";}
            else if(noisx.equals("Indonesia")){noisx = "NSX006";}
            else if(noisx.equals("Thái Lan")){noisx = "NSX007";}    
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            Connection cn = DBConnector.getConnection();
            String sql = "INSERT INTO SANPHAM (MASP, TENSP, THUONGHIEU, CHIP, CAMERA, KICHTHUOC, CHATLIEU, HEDIEUHANH, DUNGLUONGPIN, GIA, TRANGTHAI, HINHSP)\n"
                    + "VALUES	(?,?,?,?,?,?,?,?,?,?,?,?)\n"
                    + "INSERT INTO SANPHAMCT (MASPCT,MAMAU, MASP, MARAM, MANSX, NGAYNHAP, SOLUONG)\n"
                    + "VALUES	(?,?,?,?,?,?,?)";
            stm = cn.prepareStatement(sql);
            stm.setString(1, sp.getMasp());
            stm.setString(2, sp.getTensp());
            stm.setString(3, sp.getThuonghieu());
            stm.setString(4, sp.getChip());
            stm.setString(5, sp.getCamera());
            stm.setString(6, sp.getKichthuoc());
            stm.setString(7, sp.getChatlieu());
            stm.setString(8, sp.getHdh());
            stm.setString(9, sp.getPin());
            stm.setFloat(10, sp.getGia());
            stm.setInt(11, sp.getTrangthai());
            
            stm.setString(12, sp.getHinhanh());
            stm.setString(13, sp.getSpct().getMaspct());
            stm.setString(14, mausac);
            stm.setString(15, sp.getMasp());
            stm.setString(16, ram);
            stm.setString(17, noisx);
            stm.setString(18, sp.getSpct().getNgaynhap());
            stm.setInt(19, sp.getSpct().getSoluong());
             if(stm.executeUpdate()> 0){
                System.out.println("Thêm thành công");
                return 1 ;
            }       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error :"+e.toString());
        }
        return -1;
    }
    public int Sua(SanPham_model sp) {
            String mausac = sp.getSpct().getMausac();
            String ram = sp.getSpct().getLoairam();
            String noisx = sp.getSpct().getNhasx();
            // chuyển tên dữ liệu thành mã dữ liệu tương ứng  trong sql
            if(mausac.equals("Đen")){mausac = "MS001";}
            else if(mausac.equals("Trắng")){mausac = "MS002";}
            else if(mausac.equals("Đỏ")){mausac = "MS003";}
            else if(mausac.equals("Vàng")){mausac = "MS004";}
            else if(mausac.equals("Xám")){mausac = "MS005";}
            else if(mausac.equals("Xanh")){mausac = "MS006";}
            else if(mausac.equals("Nâu")){mausac = "MS007";}
            else if(mausac.equals("Hồng")){mausac = "MS008";}
            else if(mausac.equals("Tím")){mausac = "MS009";}
            // chuyển đổi loại ram 
            if(ram.equals("64GB")){ram = "RM001";}
            else if(ram.equals("128GB")){ram = "RM002";}
            else if(ram.equals("256GB")){ram = "RM003";}
            else if(ram.equals("512GB")){ram = "RM004";}
            else if(ram.equals("1T")){ram = "RM005";}
            // CHUYỂ ĐỔI NƠI SẢN XUẤT           
            if(noisx.equals("Việt Nam")){noisx = "NSX001";}
            else if(noisx.equals("Trung Quốc")){noisx = "NSX002";}
            else if(noisx.equals("Ấn Độ")){noisx = "NSX003";}
            else if(noisx.equals("Mỹ")){noisx = "NSX004";}
            else if(noisx.equals("Hàn quốc")){noisx = "NSX005";}
            else if(noisx.equals("Indonesia")){noisx = "NSX006";}
            else if(noisx.equals("Thái Lan")){noisx = "NSX007";}    
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            Connection cn = DBConnector.getConnection();
            String sql = "UPDATE SANPHAM \n" +
                        "SET TENSP = ? , THUONGHIEU = ? , CHIP = ? , CAMERA = ? , KICHTHUOC = ? , CHATLIEU = ? , HEDIEUHANH =?, DUNGLUONGPIN = ? ,"
                    + " GIA=?, TRANGTHAI=?, HINHSP=?\n" +
                        "WHERE MASP = ?\n" +
                        "UPDATE SANPHAMCT\n" +
                        "SET MAMAU = ?, MARAM = ?, MANSX = ? , NGAYNHAP = ?, SOLUONG = ?\n" +
                        "WHERE MASPCT = ?";
            stm = cn.prepareStatement(sql);
            stm.setString(12, sp.getMasp());
            stm.setString(1, sp.getTensp());
            stm.setString(2, sp.getThuonghieu());
            stm.setString(3, sp.getChip());
            stm.setString(4, sp.getCamera());
            stm.setString(5, sp.getKichthuoc());
            stm.setString(6, sp.getChatlieu());
            stm.setString(7, sp.getHdh());
            stm.setString(8, sp.getPin());
            stm.setFloat(9, sp.getGia());
            stm.setInt(10, sp.getTrangthai());
            stm.setString(11, sp.getHinhanh());
            stm.setString(18, sp.getSpct().getMaspct());
            stm.setString(13, mausac);
            stm.setString(14, ram);
            stm.setString(15, noisx);
            stm.setString(16, sp.getSpct().getNgaynhap());
            stm.setInt(17, sp.getSpct().getSoluong());
             if(stm.executeUpdate()> 0){
                System.out.println("Sửa thành công");
                return 1 ;
            }       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error :"+e.toString());
        }
        return -1;
    }
    
    public void  hideRowInDatabase(String ma) {
        //int row ;
        // Thực hiện truy vấn SQL để ẩn dòng có ID tương ứng trong cơ sở dữ liệu
        Connection cn = DBConnector.getConnection();
        try {
            String sql =   "UPDATE SANPHAMCT SET hidden = 0 WHERE MASP = ? \n"
                            +"UPDATE SANPHAM SET hidden = 0 WHERE MASP = ?";                         
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, ma);
            stm.setString(2, ma);
            stm.executeUpdate();
//            if(stm.executeUpdate()> 0){
//                return 1;
//            }
        }catch(SQLException e) {
            e.printStackTrace();
            System.out.println(" 1 ");
        }
        //return -1;
    }
    public void  showInDatabase(String ma) {
        //int row ;
        // Thực hiện truy vấn SQL để ẩn dòng có ID tương ứng trong cơ sở dữ liệu
        Connection cn = DBConnector.getConnection();
        try {
            String sql =   "UPDATE SANPHAMCT SET hidden = 1 WHERE MASP = ? \n"
                            +"UPDATE SANPHAM SET hidden = 1 WHERE MASP = ?";                         
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, ma);
            stm.setString(2, ma);
            stm.executeUpdate();
//            if(stm.executeUpdate()> 0){
//                return 1;
//            }
        }catch(SQLException e) {
            e.printStackTrace();
            System.out.println(" 1 ");
        }
        //return -1;
    }
     public ArrayList<SanPham_model> showdata() {
        ArrayList<SanPham_model> listdata = new ArrayList<>();
        Connection cn = DBConnector.getConnection();
        String sql = "select MASP,TENSP,THUONGHIEU\n" +
                        "from SANPHAM\n" +
                        "where hidden = 0";
        PreparedStatement stm;
        try {
            stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham_model spct = new SanPham_model();
                spct.setMasp(rs.getString("MASP"));
                spct.setTensp(rs.getString("TENSP"));
                spct.setThuonghieu(rs.getString("THUONGHIEU"));               
                listdata.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdata;
    }
    public int ThemSPCT(SPChiTiet sp) {
            String mausac = sp.getMausac();
            String ram = sp.getLoairam();
            String noisx = sp.getNhasx();
            // chuyển tên dữ liệu thành mã dữ liệu tương ứng  trong sql
            if(mausac.equals("Đen")){mausac = "MS001";}
            else if(mausac.equals("Trắng")){mausac = "MS002";}
            else if(mausac.equals("Đỏ")){mausac = "MS003";}
            else if(mausac.equals("Vàng")){mausac = "MS004";}
            else if(mausac.equals("Xám")){mausac = "MS005";}
            else if(mausac.equals("Xanh")){mausac = "MS006";}
            else if(mausac.equals("Nâu")){mausac = "MS007";}
            else if(mausac.equals("Hồng")){mausac = "MS008";}
            else if(mausac.equals("Tím")){mausac = "MS009";}
            // chuyển đổi loại ram 
            if(ram.equals("64GB")){ram = "RM001";}
            else if(ram.equals("128GB")){ram = "RM002";}
            else if(ram.equals("256GB")){ram = "RM003";}
            else if(ram.equals("512GB")){ram = "RM004";}
            else if(ram.equals("1T")){ram = "RM005";}
            // CHUYỂ ĐỔI NƠI SẢN XUẤT           
            if(noisx.equals("Việt Nam")){noisx = "NSX001";}
            else if(noisx.equals("Trung Quốc")){noisx = "NSX002";}
            else if(noisx.equals("Ấn Độ")){noisx = "NSX003";}
            else if(noisx.equals("Mỹ")){noisx = "NSX004";}
            else if(noisx.equals("Hàn quốc")){noisx = "NSX005";}
            else if(noisx.equals("Indonesia")){noisx = "NSX006";}
            else if(noisx.equals("Thái Lan")){noisx = "NSX007";}    
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            Connection cn = DBConnector.getConnection();
            String sql = "INSERT INTO SANPHAMCT (MASPCT,MAMAU, MASP, MARAM, MANSX)\n"
                        + "VALUES(?,?,?,?,?)";
            stm = cn.prepareStatement(sql);
            stm.setString(1, sp.getMaspct());
            stm.setString(2, mausac);
            stm.setString(3, sp.getMasp());
            stm.setString(4, ram);
            stm.setString(5, noisx);
             if(stm.executeUpdate()> 0){
                System.out.println("Thêm thành công");
                return 1 ;
            }       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error :"+e.toString());
        }
        return -1;
    }
}
