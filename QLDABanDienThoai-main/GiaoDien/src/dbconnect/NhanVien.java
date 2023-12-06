/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.util.Date;

/**
 *
 * @author hieu9
 */
class NhanVien {

    private Integer IDNV;
    private String MANV;
    private String TENNV;
    private Date NGAYSINH;
    private String SDT;
    private String TENTK;
    private String CHUCVU;
    private String DIACHI;
    private String CCCD;
    private String EMAIL;
    private String GIOITINH;
    private String TRANGTHAI;
    private int luong;
    private String HINHANH;
    private String locNhanVienTheoMa;
    private String locNhanVienTheoTen;
    private String locNhanVienTheoChucVU;

    public NhanVien(Integer IDNV, String MANV, String TENNV, Date NGAYSINH, String SDT, String TENTK, String CHUCVU, String DIACHI, String CCCD, String EMAIL, String GIOITINH, String TRANGTHAI, int luong, String HINHANH, String locNhanVienTheoMa, String locNhanVienTheoTen, String locNhanVienTheoChucVU) {
        this.IDNV = IDNV;
        this.MANV = MANV;
        this.TENNV = TENNV;
        this.NGAYSINH = NGAYSINH;
        this.SDT = SDT;
        this.TENTK = TENTK;
        this.CHUCVU = CHUCVU;
        this.DIACHI = DIACHI;
        this.CCCD = CCCD;
        this.EMAIL = EMAIL;
        this.GIOITINH = GIOITINH;
        this.TRANGTHAI = TRANGTHAI;
        this.luong = luong;
        this.HINHANH = HINHANH;
        this.locNhanVienTheoMa = locNhanVienTheoMa;
        this.locNhanVienTheoTen = locNhanVienTheoTen;
        this.locNhanVienTheoChucVU = locNhanVienTheoChucVU;
    }

    public Integer getIDNV() {
        return IDNV;
    }

    public void setIDNV(Integer IDNV) {
        this.IDNV = IDNV;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getTENNV() {
        return TENNV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTENTK() {
        return TENTK;
    }

    public void setTENTK(String TENTK) {
        this.TENTK = TENTK;
    }

    public String getCHUCVU() {
        return CHUCVU;
    }

    public void setCHUCVU(String CHUCVU) {
        this.CHUCVU = CHUCVU;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }

    public String getLocNhanVienTheoMa() {
        return locNhanVienTheoMa;
    }

    public void setLocNhanVienTheoMa(String locNhanVienTheoMa) {
        this.locNhanVienTheoMa = locNhanVienTheoMa;
    }

    public String getLocNhanVienTheoTen() {
        return locNhanVienTheoTen;
    }

    public void setLocNhanVienTheoTen(String locNhanVienTheoTen) {
        this.locNhanVienTheoTen = locNhanVienTheoTen;
    }

    public String getLocNhanVienTheoChucVU() {
        return locNhanVienTheoChucVU;
    }

    public void setLocNhanVienTheoChucVU(String locNhanVienTheoChucVU) {
        this.locNhanVienTheoChucVU = locNhanVienTheoChucVU;
    }

    boolean isVaiTro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
