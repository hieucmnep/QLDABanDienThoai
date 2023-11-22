/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author LE DINH LINH
 */
public class SanPham {

    private int idSP;
    private String maSP;
    private String tenSP;
    private String thuongHieu;
    private String chip;
    private String camera;
    private float kichThuoc;
    private String chatLieu;
    private String heDieuHanh;
    private String dungLuongPin;
    private float gia;
    private int soluong;
    private int trangThai;
    private ImageIcon hinhSP;

    public SanPham() {
    }

    public SanPham(int idSP, String maSP, String tenSP, String thuongHieu, String chip, String camera, float kichThuoc, String chatLieu, String heDieuHanh, String dungLuongPin, float gia, int soluong, int trangThai, ImageIcon hinhSP) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.thuongHieu = thuongHieu;
        this.chip = chip;
        this.camera = camera;
        this.kichThuoc = kichThuoc;
        this.chatLieu = chatLieu;
        this.heDieuHanh = heDieuHanh;
        this.dungLuongPin = dungLuongPin;
        this.gia = gia;
        this.soluong = soluong;
        this.trangThai = trangThai;
        this.hinhSP = hinhSP;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
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

    public float getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(float kichThuoc) {
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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public ImageIcon getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(ImageIcon hinhSP) {
        this.hinhSP = hinhSP;
    }

}