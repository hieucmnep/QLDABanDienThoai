package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LE DINH LINH
 */
public class HoaDon {

    private String maHD;
    private String maNV;
    private String maKH;
    private String hinhThucTT;
    private int trangThai;
    private Date ngayMua;


    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, String maKH, String hinhThucTT, int trangThai, Date ngayMua) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.hinhThucTT = hinhThucTT;
        this.trangThai = trangThai;
        this.ngayMua = ngayMua;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

   
}
