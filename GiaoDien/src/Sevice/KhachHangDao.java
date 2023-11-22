/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.KhachHang;
import Model.KhachHang1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author LE DINH LINH
 */
public class KhachHangDao{

   public ArrayList<KhachHang1> getAllKhachHang() {
        ArrayList<KhachHang1> danhSachKhachHang = new ArrayList<>();
        try (Connection connection = dbconnect.DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM KHACHHANG");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                KhachHang1 khachHang = new KhachHang1();
                khachHang.setMaKH(resultSet.getString("MAKH"));
                khachHang.setTenKH(resultSet.getString("TENKH"));
                khachHang.setNgaySinh(resultSet.getString("NGAYSINH"));
                khachHang.setSdt(resultSet.getInt("SDT"));
                khachHang.setGt(resultSet.getString("GIOITINH"));
                khachHang.setDiaChi(resultSet.getString("DIACHI"));
                khachHang.setEmail(resultSet.getString("EMAIL"));

                // Thêm khách hàng vào danh sách
                danhSachKhachHang.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }
  public boolean insertKhachHang(KhachHang1 khachHang) {
    boolean success = false;
    try (Connection connection = dbconnect.DBConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "INSERT INTO KHACHHANG (MAKH, TENKH, NGAYSINH, SDT, GIOITINH, DIACHI, EMAIL) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)")) {

        preparedStatement.setString(1, khachHang.getMaKH());
        preparedStatement.setString(2, khachHang.getTenKH());
        preparedStatement.setString(3, khachHang.getNgaySinh());
        preparedStatement.setInt(4, khachHang.getSdt());
        preparedStatement.setString(5, khachHang.getGt());
        preparedStatement.setString(6, khachHang.getDiaChi());
        preparedStatement.setString(7, khachHang.getEmail());

        int rowsAffected = preparedStatement.executeUpdate();
        success = rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return success;
}
}