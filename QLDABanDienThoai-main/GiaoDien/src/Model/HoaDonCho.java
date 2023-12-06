/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author LE DINH LINH
 */
public class HoaDonCho extends HoaDon {
    private boolean daThanhToan;

    public HoaDonCho(String maHD, String maNV, String maKH, String hinhThucTT, int trangThai, Date ngayMua, boolean daThanhToan) {
        super(maHD, maNV, maKH, hinhThucTT, trangThai, ngayMua);
        this.daThanhToan = daThanhToan;
    }

    public boolean isDaThanhToan() {
        return daThanhToan;
    }

    public void setDaThanhToan(boolean daThanhToan) {
        this.daThanhToan = daThanhToan;
    }

}
