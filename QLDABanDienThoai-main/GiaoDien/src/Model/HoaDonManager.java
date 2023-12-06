/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author LE DINH LINH
 */
public class HoaDonManager {
    private static ArrayList<HoaDonCho> danhSachHoaDonTamThoi = new ArrayList<>();

    public static ArrayList<HoaDonCho> getDanhSachHoaDonTamThoi() {
        return danhSachHoaDonTamThoi;
    }

    public static void themHoaDonTamThoi(HoaDonCho hoaDon) {
        danhSachHoaDonTamThoi.add(hoaDon);
    }

    public static HoaDonCho timHoaDonTamThoiTheoMa(String maHoaDon) {
        for (HoaDonCho hoaDon : danhSachHoaDonTamThoi) {
            if (hoaDon.getMaHD().equals(maHoaDon)) {
                return hoaDon;
            }
        }
        return null;
    }
}
