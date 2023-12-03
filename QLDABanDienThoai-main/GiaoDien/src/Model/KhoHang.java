/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hieu9
 */
public class KhoHang {
    private int ID;
    private String masp;
    private String TenSp;
    private int soluong;
    private float gia;

    public KhoHang(int ID, String masp, String TenSp, int soluong, float gia) {
        this.ID = ID;
        this.masp = masp;
        this.TenSp = TenSp;
        this.soluong = soluong;
        this.gia = gia;
    }

    public KhoHang() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
   private SanPhamCT sp;

    public SanPhamCT getSp() {
        return sp;
    }

    public void setSp(SanPhamCT sp) {
        this.sp = sp;
    }

   

   
  

}
