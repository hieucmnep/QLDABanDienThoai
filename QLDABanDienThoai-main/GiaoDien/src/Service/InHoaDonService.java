package Service;

import dbconnect.DBConnector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InHoaDonService {

    public static void displayLatestInvoiceData(String maHoaDon, DefaultTableModel model, JLabel[] labels) {
        Connection connection = DBConnector.getConnection();

        if (connection != null) {
            try {
                String sqlQuery = "SELECT TOP 1\n"
                        + "    HOADONCT.MAHD, \n"
                        + "    KHACHHANG.TENKH, \n"
                        + "    KHACHHANG.SDT, \n"
                        + "    KHACHHANG.EMAIL, \n"
                        + "    SANPHAM.TENSP, \n"
                        + "    HOADONCT.SOLUONG, \n"
                        + "    HOADONCT.DONGIA, \n"
                        + "    HOADONCT.TONGTIEN\n"
                        + "FROM \n"
                        + "    HOADONCT \n"
                        + "JOIN \n"
                        + "    KHACHHANG ON HOADONCT.MAKH = KHACHHANG.MAKH \n"
                        + "JOIN \n"
                        + "    SANPHAMCT ON SANPHAMCT.MASPCT = HOADONCT.MASPCT \n"
                        + "JOIN \n"
                        + "    SANPHAM ON SANPHAM.MASP = SANPHAMCT.MASP\n"
                        + "ORDER BY HOADONCT.ID DESC";      
         
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();
                double tongCong = 0;

                while (resultSet.next()) {
                    String tenSP = resultSet.getString("TENSP");
                    int soLuong = resultSet.getInt("SOLUONG");
                    float donGia = resultSet.getFloat("DONGIA");
                    float thanhTien = resultSet.getFloat("TONGTIEN");

                    model.addRow(new Object[]{tenSP, soLuong, donGia, thanhTien});
                    tongCong += thanhTien;
                }

                PreparedStatement infoStatement = connection.prepareStatement("SELECT * FROM HOADONCT JOIN KHACHHANG ON HOADONCT.MAKH = KHACHHANG.MAKH WHERE MAHD = ?");
                infoStatement.setString(1, maHoaDon);
                ResultSet infoResult = infoStatement.executeQuery();

                while (infoResult.next()) {
                    labels[1].setText(infoResult.getString("TENKH"));
                    labels[2].setText(infoResult.getString("SDT"));
                    labels[3].setText(infoResult.getString("EMAIL"));
                }

                DBConnector.closeConnection(connection);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static double getTotalAmountByInvoiceID(String maHoaDon) {
        double totalAmount = 0;
        Connection connection = DBConnector.getConnection();

        if (connection != null) {
            try {
                String sqlQuery = "SELECT SUM(TONGTIEN) AS TOTAL_AMOUNT FROM HOADONCT WHERE MAHD = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, maHoaDon);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    totalAmount = resultSet.getDouble("TOTAL_AMOUNT");
                }

                DBConnector.closeConnection(connection);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return totalAmount;
    }

    public static String getLatestInvoiceID() {
        Connection connection = DBConnector.getConnection();
        String latestInvoiceID = "";

        if (connection != null) {
            try {
                String sqlQuery = "SELECT TOP 1 MAHD FROM HOADONCT ORDER BY NGAYMUA DESC";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    latestInvoiceID = resultSet.getString("MAHD");
                }

                DBConnector.closeConnection(connection);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return latestInvoiceID;
    }
}
