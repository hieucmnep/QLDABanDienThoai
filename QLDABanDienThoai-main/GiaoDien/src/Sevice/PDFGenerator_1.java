package service;

import dbconnect.DBConnector;
import Model.HoaDonCTBH;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PDFGenerator_1 {

    public static void main(String[] args) {
        PDFGenerator_1 pdfGenerator = new PDFGenerator_1();
        pdfGenerator.xuatDuLieuRaPDF();
    }

    public void xuatDuLieuRaPDF() {
        String folderPath = "C:\\Users\\LE DINH LINH\\Downloads\\GiaoDien\\src\\PDF";
        String pdfFileName = folderPath + "\\HoaDon4.pdf";

        try (PDDocument document = new PDDocument()) {
            Connection connection = DBConnector.getConnection();

            if (connection != null) {
                ArrayList<HoaDonCTBH> danhSachHoaDon = layDanhSachHoaDon(connection);

                for (HoaDonCTBH hoaDon : danhSachHoaDon) {
                    PDPage page = new PDPage();
                    document.addPage(page);

                    // Gọi phương thức inHoaDonPDF
                    inHoaDonPDF(document, page, hoaDon);
                }

                DBConnector.closeConnection(connection);

                // Lưu tất cả các trang vào cùng một tệp PDF
                document.save(pdfFileName);
                System.out.println("Tất cả các hóa đơn đã được lưu tại: " + pdfFileName);
                document.close(); // Đóng tệp PDF sau khi lưu
                JOptionPane.showMessageDialog(null, "In Thành Công");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi ghi file");
        }
    }

    public ArrayList<HoaDonCTBH> layDanhSachHoaDon(Connection connection) {
        ArrayList<HoaDonCTBH> danhSachHoaDon = new ArrayList<>();

        String sql = "SELECT * FROM HOADONCT WHERE TRANGTHAI = 1"; // Chọn các hóa đơn đã thanh toán
        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                HoaDonCTBH hoaDon = new HoaDonCTBH();
                // Lấy thông tin từ ResultSet và thiết lập cho đối tượng hóa đơn
                hoaDon.setMaHD(resultSet.getString("MAHD"));
                hoaDon.setMaSPCT(resultSet.getString("MASPCT"));
                hoaDon.setMaKH(resultSet.getString("MAKH"));
                hoaDon.setDonGia(resultSet.getFloat("DONGIA"));
                hoaDon.setSoLuong(resultSet.getInt("SOLUONG"));
                hoaDon.setTongTien(resultSet.getFloat("TONGTIEN"));
                hoaDon.setGiamGia(resultSet.getString("GIAMGIA"));
                hoaDon.setNgayMua(resultSet.getDate("NGAYMUA"));

                danhSachHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách hóa đơn từ cơ sở dữ liệu.");
        }
        return danhSachHoaDon;
    }

 
    public void inHoaDonPDF(PDDocument document, PDPage page, HoaDonCTBH hoaDonCT) throws IOException {
    try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
        // Đường dẫn đến file font Roboto Medium (đổi tên file phù hợp)
        String fontPath = "C:\\Users\\LE DINH LINH\\Downloads\\GiaoDien\\src\\font\\Roboto-Medium.ttf";
        PDType0Font robotoMedium = PDType0Font.load(document, new File(fontPath));

        contentStream.setFont(robotoMedium, 12);

        float margin = 50;
        float yStart = page.getMediaBox().getHeight() - 50;
        float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
        float yPosition = yStart;
        float rowHeight = 20;
        float tableMargin = 10;
// Bảng chi tiết sản phẩm
        contentStream.setLineWidth(1f);
        contentStream.moveTo(margin, yPosition);
        contentStream.lineTo(margin + tableWidth, yPosition);
        contentStream.stroke();

        String[] headers = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"};
        float nextX = margin;

        // In các tiêu đề của bảng
        for (String header : headers) {
            contentStream.beginText();
            contentStream.newLineAtOffset(nextX, yPosition - tableMargin);
            contentStream.showText(header);
            contentStream.endText();
            nextX += 100; // Điều chỉnh khoảng cách giữa các cột
        }

        yPosition -= rowHeight;

        // Vẽ nội dung bảng
       // Trong phương thức inHoaDonPDF
if (hoaDonCT.getDanhSachChiTiet() != null && !hoaDonCT.getDanhSachChiTiet().isEmpty()) {
    for (HoaDonCTBH.ChiTietHoaDon chiTiet : hoaDonCT.getDanhSachChiTiet()) {
        contentStream.moveTo(margin, yPosition - rowHeight - tableMargin);
        contentStream.lineTo(margin + tableWidth, yPosition - rowHeight - tableMargin);
        contentStream.stroke();

        String[] rowContent = {
            chiTiet.getMaSP(),
            chiTiet.getTenSP(),
            String.valueOf(chiTiet.getSoLuong()),
            String.valueOf(chiTiet.getDonGia()),
            String.valueOf(chiTiet.getThanhTien())
        };

        float[] columnWidths = {50, 150, 50, 50, 50}; // Thay đổi kích thước cột nếu cần

        nextX = margin;

        for (int i = 0; i < headers.length; i++) {
            float width = columnWidths[i];
            String content = (i < rowContent.length) ? rowContent[i] : "N/A";
            
            contentStream.beginText();
            contentStream.newLineAtOffset(nextX, yPosition - tableMargin - 2 * rowHeight);
            contentStream.showText(content);
            contentStream.endText();

            nextX += width;
        }

        yPosition -= 2 * rowHeight;
    }
        } else {
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition - tableMargin);
            contentStream.showText("Danh sách chi tiết sản phẩm rỗng");
            contentStream.endText();
        }

    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tạo hóa đơn PDF.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }
}