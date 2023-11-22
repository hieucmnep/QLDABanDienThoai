/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class HoaDonCT {
    private String MaHD;
    private String MaSPCT;
    private float DonGia;
    private int SoLuong;
    private float TienKhachDua;
    private float TienTraLai;
    private String NgayMua;
    private String HinhThucTT;
    private float TongTien;
    private String TrangThai;
    private String GhiChu;
    private String GiamGia;

    public HoaDonCT() {
    }

    public HoaDonCT(String MaHD, String MaSP, float DonGia, int SoLuong, float TienKhachDua, float TienTraLai, String NgayMua, String HinhThucTT, float TongTien, String TrangThai, String GhiChu, String GiamGia) {
        this.MaHD = MaHD;
        this.MaSPCT = MaSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.TienKhachDua = TienKhachDua;
        this.TienTraLai = TienTraLai;
        this.NgayMua = NgayMua;
        this.HinhThucTT = HinhThucTT;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
        this.GiamGia = GiamGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSPCT() {
        return MaSPCT;
    }

    public void setMaSPCT(String MaSP) {
        this.MaSPCT = MaSP;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(float TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public float getTienTraLai() {
        return TienTraLai;
    }

    public void setTienTraLai(float TienTraLai) {
        this.TienTraLai = TienTraLai;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getHinhThucTT() {
        return HinhThucTT;
    }

    public void setHinhThucTT(String HinhThucTT) {
        this.HinhThucTT = HinhThucTT;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(String GiamGia) {
        this.GiamGia = GiamGia;
    }

    @Override
    public String toString() {
        return "HoaDonCT{" + "MaHD=" + MaHD + ", MaSP=" + MaSPCT + ", DonGia=" + DonGia + ", SoLuong=" + SoLuong + ", TienKhachDua=" + TienKhachDua + ", TienTraLai=" + TienTraLai + ", NgayMua=" + NgayMua + ", HinhThucTT=" + HinhThucTT + ", TongTien=" + TongTien + ", TrangThai=" + TrangThai + ", GhiChu=" + GhiChu + ", GiamGia=" + GiamGia + '}';
    }

    
}
