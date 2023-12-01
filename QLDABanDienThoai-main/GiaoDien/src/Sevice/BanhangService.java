/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Sevice.BanHang;
import Model.SanPham;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import Model.HoaDon;

/**
 *
 * @author LE DINH LINH
 */
public class BanhangService {

    private final BanHang banHangDao;

    public BanhangService() {
        this.banHangDao = new BanHang();
    }

    public ArrayList<SanPham> getAllSanPham() {
        return banHangDao.getAllSanPham();
    }
}
