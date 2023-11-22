/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.ImageIcon;
import java.sql.SQLException;


/**
 *
 * @author LE DINH LINH
 */
public class BanHang {

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        try (Connection connection = dbconnect.DBConnector.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT SANPHAM.*, SANPHAMCT.SOLUONG "
                + "FROM SANPHAM "
                + "INNER JOIN SANPHAMCT ON SANPHAM.MASP = SANPHAMCT.MASP"
        ); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSP(resultSet.getInt("IDSP"));
                sanPham.setMaSP(resultSet.getString("MASP"));
                sanPham.setTenSP(resultSet.getString("TENSP"));
                sanPham.setThuongHieu(resultSet.getString("THUONGHIEU"));
                sanPham.setChip(resultSet.getString("CHIP"));
                sanPham.setCamera(resultSet.getString("CAMERA"));
                sanPham.setKichThuoc(resultSet.getFloat("KICHTHUOC"));
                sanPham.setChatLieu(resultSet.getString("CHATLIEU"));
                sanPham.setHeDieuHanh(resultSet.getString("HEDIEUHANH"));
                sanPham.setDungLuongPin(resultSet.getString("DUNGLUONGPIN"));
                sanPham.setGia(resultSet.getFloat("GIA"));
                sanPham.setTrangThai(resultSet.getInt("TRANGTHAI"));

                // Lấy giá trị từ cơ sở dữ liệu dưới dạng String
                String hinhAnhString = resultSet.getString("HINHSP");

                // Chuyển đổi String thành ImageIcon
                ImageIcon hinhAnhIcon = new ImageIcon(hinhAnhString);

                // Gán ImageIcon cho đối tượng SanPham
                sanPham.setHinhSP(hinhAnhIcon);

                // Lấy số lượng từ cơ sở dữ liệu
                int soLuong = resultSet.getInt("SOLUONG");
                // Gán số lượng cho đối tượng SanPham
                sanPham.setSoluong(soLuong);

                danhSachSanPham.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachSanPham;
    }
}
