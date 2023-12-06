package Model;

import java.util.Date;
import java.util.List;

public class HoaDonCTBH {

    private String maHD;
    private String maSPCT;
    private String maKH;
    private String maKM;
    private float donGia;
    private int soLuong;
    private float tienKhachDua;
    private float tienTraLai;
    private String hinhThucThanhToan;
    private float tongTien;
    private String ghiChu;
    private String giamGia;
    private Date ngayMua;
    private String soDienThoai; // Thêm thuộc tính này
    private String email; // Thêm thuộc tính này
    private List<ChiTietHoaDon> danhSachChiTiet;
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HoaDonCTBH() {
    }

    public HoaDonCTBH(String maHD, String maSPCT, String maKH, String maKM, float donGia, int soLuong, float tienKhachDua, float tienTraLai, String hinhThucThanhToan, float tongTien, String ghiChu, String giamGia, Date ngayMua, List<ChiTietHoaDon> danhSachChiTiet) {
        this.maHD = maHD;
        this.maSPCT = maSPCT;
        this.maKH = maKH;
        this.maKM = maKM;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tienKhachDua = tienKhachDua;
        this.tienTraLai = tienTraLai;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.giamGia = giamGia;
        this.ngayMua = ngayMua;
        this.danhSachChiTiet = danhSachChiTiet;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(float tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public float getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(float tienTraLai) {
        this.tienTraLai = tienTraLai;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public List<ChiTietHoaDon> getDanhSachChiTiet() {
        return danhSachChiTiet;
    }

    public static class ChiTietHoaDon {

        private String maSP;
        private String tenSP;
        private int soLuong;
        private float donGia;
        private float thanhTien;

        public ChiTietHoaDon() {
        }

        public ChiTietHoaDon(String maSP, String tenSP, int soLuong, float donGia, float thanhTien) {
            this.maSP = maSP;
            this.tenSP = tenSP;
            this.soLuong = soLuong;
            this.donGia = donGia;
            this.thanhTien = thanhTien;
        }

        public String getMaSP() {
            return maSP;
        }

        public void setMaSP(String maSP) {
            this.maSP = maSP;
        }

        public String getTenSP() {
            return tenSP;
        }

        public void setTenSP(String tenSP) {
            this.tenSP = tenSP;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(int soLuong) {
            this.soLuong = soLuong;
        }

        public float getDonGia() {
            return donGia;
        }

        public void setDonGia(float donGia) {
            this.donGia = donGia;
        }

        public float getThanhTien() {
            return thanhTien;
        }

        public void setThanhTien(float thanhTien) {
            this.thanhTien = thanhTien;
        }
    }

    public void setDanhSachChiTiet(List<ChiTietHoaDon> danhSachChiTiet) {
        this.danhSachChiTiet = danhSachChiTiet;
    }
    
}
