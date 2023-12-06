/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LE DINH LINH
 */
public class kh {

    private String ten;
    private String sdt;
    private String makh;

    public interface KhachHangSelectedListener {
        void onKhachHangSelected(kh khachHang);
    }

    public kh() {
    }

    public kh(String ten, String sdt, String makh) {
        this.ten = ten;
        this.sdt = sdt;
        this.makh = makh;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getmakh() {
        return makh;
    }
}
