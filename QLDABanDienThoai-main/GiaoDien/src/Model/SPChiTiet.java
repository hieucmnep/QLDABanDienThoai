package Model;




import java.util.Date;



/**
 *
 * @author ADMIN
 */
public class SPChiTiet {
  private String masp, loairam, mausac, nhasx;
    private String ngaynhap;
    private int soluong;
    private float gianhap;
    private String maspct;
    public SPChiTiet(String loairam, String mausac) {
        this.loairam = loairam;
        this.mausac = mausac;
    }
  
    public SPChiTiet(String loairam, String mausac, String nhasx, String ngaynhap, int soluong,String maspct) {
        this.loairam = loairam;
        this.mausac = mausac;
        this.nhasx = nhasx;
        this.ngaynhap = ngaynhap;
        this.soluong = soluong;
         this.maspct = maspct;
    }

    public SPChiTiet(String masp, String loairam, String mausac, String maspct, String nhasx, String ngaynhap, int soluong, float gianhap) {
        this.masp = masp;
        this.loairam = loairam;
        this.mausac = mausac;
        this.maspct = maspct;
        this.nhasx = nhasx;
        this.ngaynhap = ngaynhap;
        this.soluong = soluong;
        this.gianhap = gianhap;
    }

    public SPChiTiet(String masp, String loairam, String mausac, String maspct, String nhasx, String ngaynhap, int soluong) {
        this.masp = masp;
        this.loairam = loairam;
        this.mausac = mausac;
        this.maspct = maspct;
        this.nhasx = nhasx;
        this.ngaynhap = ngaynhap;
        this.soluong = soluong;
    }

    public SPChiTiet(String masp, String loairam, String mausac, String nhasx, String maspct) {
        this.masp = masp;
        this.loairam = loairam;
        this.mausac = mausac;
        this.nhasx = nhasx;
        this.maspct = maspct;
    }

    
    public SPChiTiet() {
    }

    public String getNhasx() {
        return nhasx;
    }

    public void setNhasx(String nhasx) {
        this.nhasx = nhasx;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getLoairam() {
        return loairam;
    }

    public void setLoairam(String loairam) {
        this.loairam = loairam;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getMaspct() {
        return maspct;
    }

    public void setMaspct(String maspct) {
        this.maspct = maspct;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    @Override
    public String toString() {
        return "SPChiTiet{" + "masp=" + masp + ", loairam=" + loairam + ", mausac=" + mausac + ", nhasx=" + nhasx + ", ngaynhap=" + ngaynhap + ", soluong=" + soluong + ", gianhap=" + gianhap + ", maspct=" + maspct + '}';
    }

    

}
