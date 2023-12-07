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
    private HoaDonCT hoaDonCT;
    private SanPham sanPham;
    private NhanVienModel nhanVien;
    private HoaDonCTBH hoaDonCTBH;

    public KhachHang(int id, String maKH, String tenKH, String sdt, Date ngaySinh, String email, String diaChi, String gioiTinh, boolean trangThai, HoaDonCT hoaDonCT, SanPham sanPham) {
        this.id = id;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.hoaDonCT = hoaDonCT;
        this.sanPham = sanPham;
    }

    public KhachHang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang(HoaDonCT hoaDonCT, SanPham sanPham) {
        this.hoaDonCT = hoaDonCT;
        this.sanPham = sanPham;
    }

    public HoaDonCT getHoaDonCT() {
        return hoaDonCT;
    }

    public void setHoaDonCT(HoaDonCT hoaDonCT) {
        this.hoaDonCT = hoaDonCT;
    }

    // Getters và Setters cho sanPham
    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setNhanVien(NhanVienModel nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setHoaDonCTBH(HoaDonCTBH hoaDonCTBH) {
        this.hoaDonCTBH = hoaDonCTBH;
    }

    public Object getNhanVien() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Iterable<HoaDonCTBH> getHoaDonCTBHList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
