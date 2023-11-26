/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LE DINH LINH
 */
import java.util.Date;

public class SanPhamCT {
    private int id;
    private String maSP;
    private String chip;
    private String camera;
    private int kichThuoc;
    private String chatLieu;
    private String heDieuHanh;
    private String dungLuongPin;
    private Date ngayNhap;
    private int soLuong;
    private float giaTien;

    public SanPhamCT() {
    }

    public SanPhamCT(int id, String maSP, String chip, String camera, int kichThuoc, String chatLieu, String heDieuHanh, String dungLuongPin, Date ngayNhap, int soLuong, float giaTien) {
        this.id = id;
        this.maSP = maSP;
        this.chip = chip;
        this.camera = camera;
        this.kichThuoc = kichThuoc;
        this.chatLieu = chatLieu;
        this.heDieuHanh = heDieuHanh;
        this.dungLuongPin = dungLuongPin;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public int getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(int kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(String dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    private SanPham sanpham;

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }
    
}

