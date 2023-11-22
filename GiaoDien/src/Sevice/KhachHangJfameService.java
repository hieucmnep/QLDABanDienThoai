/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.KhachHang;
import Sevice.KhachHangDao;
import java.util.ArrayList;
import Model.KhachHang1;

/**
 *
 * @author LE DINH LINH
 */
public class KhachHangJfameService {

    private KhachHangDao khachHangDao;

    public KhachHangJfameService() {
        this.khachHangDao = new KhachHangDao();
    }

    public ArrayList<KhachHang1> getAllKhachHang() {
        return khachHangDao.getAllKhachHang();
    }

    public boolean insertKhachHang(KhachHang1 khachHang) {
        return khachHangDao.insertKhachHang(khachHang);
    }

}
