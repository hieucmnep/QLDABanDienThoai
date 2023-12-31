/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnector {

    protected Connection connection;
    private static final String HOSTNAME = "localhost";
    private static final String PORT = "1433";
    private static final String DBNAME = "DUAN11";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "2003";

    public static Connection getConnection() {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";encrypt=true;trustServerCertificate=true";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đã đóng kết nối đến cơ sở dữ liệu.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(getConnection());
    }

}
