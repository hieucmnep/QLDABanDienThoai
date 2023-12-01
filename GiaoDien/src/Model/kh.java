/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LE DINH LINH
 */
public class kh {

    private String ten;
    private String sdt;
    private String email;

    public String getmakh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public interface KhachHangSelectedListener {
        void onKhachHangSelected(kh khachHang);
    }

    public kh() {
    }

    public kh(String ten, String sdt, String email) {
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }
}
