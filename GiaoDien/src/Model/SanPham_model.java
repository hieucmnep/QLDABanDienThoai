
package Model;

  


public class SanPham_model {
    private String masp,tenmau,thuonghieu,tensp,chip;
    private float gia;
    private int trangthai;
    private SPChiTiet spct;
    private String camera,hdh,chatlieu,pin,hinhanh,kichthuoc;
    
    
    public SPChiTiet getSpct() {
        return spct;
    }
    
    
    public SanPham_model(String masp, String tenmau, String thuonghieu, String tensp, String chip, float gia, int trangthai, String camera, String hdh, String chatlieu, String pin, String hinhanh, String kichthuoc) {
        this.masp = masp;
        this.tenmau = tenmau;
        this.thuonghieu = thuonghieu;
        this.tensp = tensp;
        this.chip = chip;
        this.gia = gia;
        this.trangthai = trangthai;
        this.camera = camera;
        this.hdh = hdh;
        this.chatlieu = chatlieu;
        this.pin = pin;
        this.hinhanh = hinhanh;
        this.kichthuoc = kichthuoc;
    }

    public SanPham_model(String masp, String thuonghieu, String tensp, String chip, float gia, int trangthai, SPChiTiet spct, String camera, String hdh, String chatlieu, String pin, String hinhanh, String kichthuoc) {
        this.masp = masp;
        this.thuonghieu = thuonghieu;
        this.tensp = tensp;
        this.chip = chip;
        this.gia = gia;
        this.trangthai = trangthai;
        this.spct = spct;
        this.camera = camera;
        this.hdh = hdh;
        this.chatlieu = chatlieu;
        this.pin = pin;
        this.hinhanh = hinhanh;
        this.kichthuoc = kichthuoc;
    }
    

    public SanPham_model(String masp, String loairam, String tenmau, String thuonghieu, String tensp, float gia, int trangthai, SPChiTiet spct) {
        this.masp = masp;
        this.tenmau = tenmau;
        this.thuonghieu = thuonghieu;
        this.tensp = tensp;
        this.gia = gia;
        this.trangthai = trangthai;
        this.spct = spct;
    }

    public void setSpct(SPChiTiet spct) {
        this.spct = spct;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getHdh() {
        return hdh;
    }

    public void setHdh(String hdh) {
        this.hdh = hdh;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getKichthuoc() {
        return kichthuoc;
    }

    public void setKichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }
      
    public SanPham_model() {
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

   
    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTenmau() {
        return tenmau;
    }

    public void setTenmau(String tenmau) {
        this.tenmau = tenmau;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "SanPham_model{" + "masp=" + masp + ", tenmau=" + tenmau + ", thuonghieu=" + thuonghieu + ", tensp=" + tensp + ", chip=" + chip + ", gia=" + gia + ", trangthai=" + trangthai + ", spct=" + spct + ", camera=" + camera + ", hdh=" + hdh + ", chatlieu=" + chatlieu + ", pin=" + pin + ", hinhanh=" + hinhanh + ", kichthuoc=" + kichthuoc + '}';
    }
    
    
}
