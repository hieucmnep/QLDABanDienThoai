/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class ThongKe {

    private String maHD;
    private String ngaydat;
    private float tongTien;
    private String trangThai;

    public ThongKe() {
    }

    public ThongKe(String maHD, String ngaydat, float tongTien, String trangThai) {
        this.maHD = maHD;
        this.ngaydat = ngaydat;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    /**
     *
     * @return
     */
    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "maHD=" + maHD + ", ngaydat=" + ngaydat + ", tongTien=" + tongTien + ", trangThai=" + trangThai + '}';
    }

    
}
