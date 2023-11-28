package Model;

public class NhanVien {
    private String MaTK;
    private String hoTen;
    private String matKhau;
    private boolean vaiTro;

    public NhanVien() {
    }

    public NhanVien(String MaTK, String hoTen, String matKhau, boolean vaiTro) {
        this.MaTK = MaTK;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "MaTK=" + MaTK + ", hoTen=" + hoTen + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + '}';
    }

    
    
}
