/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hieu9
 */
public class NhanVienYk {
   
    private String MaNV;
    private String HoTen;
    private String MatKhau;
    private boolean VaiTro;

    public NhanVienYk(String MaNV, String HoTen, String MatKhau, boolean VaiTro) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public NhanVienYk() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

  
}

