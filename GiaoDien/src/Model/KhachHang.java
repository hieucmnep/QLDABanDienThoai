/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hieu9
 */
import java.util.Date;

public class KhachHang {
    private int id;
    private String maKH;
    private String tenKH;
    private String sdt;
    private Date ngaySinh;
    private String email;
    private String diaChi;
    private String gioiTinh;
    private boolean trangThai;

    public KhachHang(int id, String maKH, String tenKH, String sdt, Date ngaySinh, String email, String diaChi, String gioiTinh, boolean trangThai) {
        this.id = id;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
    }

    public KhachHang() {
    }

    public int getId() {
        return id;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   
}
