/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LE DINH LINH
 */
public class KhachHang1 {

    private int idKH;
    private String maKH;
    private String tenKH;
    private String ngaySinh;
    private int sdt;
    private String gt;
    private String diaChi;
    private String email;

    public KhachHang1() {
    }

    public KhachHang1(int idKH, String maKH, String tenKH, String ngaySinh, int sdt, String gt, String diaChi, String email) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.gt = gt;
        this.diaChi = diaChi;
        this.email = email;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  
}
