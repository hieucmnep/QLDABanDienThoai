package view;

import Model.SanPham;
import Sevice.BHservice;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.HoaDon;
import model.HoaDonCho;
import model.HoaDonManager;
import model.kh.KhachHangSelectedListener;
import model.kh;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.hpsf.Date;


/**
 *
 * @author LE DINH LINH
 */
public class BanHang extends javax.swing.JPanel implements KhachHangSelectedListener {

    private final BHservice service = new BHservice();
    private HoaDon hoaDon;
    private int hientai = 0;
    private double TongTien = 0;
    private DefaultTableModel productTableModel;
    private DefaultTableModel invoiceTableModel;
    private DefaultTableModel Donhang;
    private int selectedQuantity = 0;

    public BanHang() {
        initComponents();
        productTableModel = (DefaultTableModel) tblDanhSachSanPham.getModel();
        invoiceTableModel = (DefaultTableModel) tblhoadon.getModel();
        loadDataToProductTable(); // Thêm sự kiện cho bảng sản phẩm

    }

    public void onKhachHangSelected(kh khachHang) {
        // Cập nhật thông tin khách hàng trên giao diện của BanHang
        tenkhachhang.setText(khachHang.getTen());
        sdtkhachhang.setText(khachHang.getSdt());
        lbmakh.setText(khachHang.getmakh());
    }

    private void loadDataToProductTable() {
        // Xóa dữ liệu cũ trước khi load mới
        clearProductTable();

        // Lấy danh sách sản phẩm từ cơ sở dữ liệu
        ArrayList<SanPham> productList = service.getAllSanPham();

        // Kiểm tra nếu danh sách không rỗng thì hiển thị lên bảng
        if (!productList.isEmpty()) {
            for (SanPham sp : productList) {
                // Lấy đường dẫn tới ảnh trong project (điều này cần được điều chỉnh phù hợp với cấu trúc thư mục của project của bạn)
                // Sử dụng đường dẫn tuyệt đối
                String imagePath = "C:\\Users\\LE DINH LINH\\Downloads\\GiaoDien\\src\\img\\" + sp.getHinhSP();
                ImageIcon hinhAnhIcon = new ImageIcon(imagePath);

                // Định dạng giá thành chuỗi VND
                String giaFormatted = String.format("%,.0f", sp.getGia()) + " VND";

                // Tạo đối tượng mảng dữ liệu
                Object[] row = {hinhAnhIcon, sp.getTenSP(), sp.getThuongHieu(),
                    sp.getSoluong(), giaFormatted};
                productTableModel.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Danh sách sản phẩm trống.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        int desiredWidth = 50; // Đặt giá trị mong muốn của chiều rộng
        tblDanhSachSanPham.getColumnModel().getColumn(0).setPreferredWidth(desiredWidth);

        int desiredHeight = 100; // Đặt giá trị mong muốn của chiều cao
        tblDanhSachSanPham.setRowHeight(desiredHeight);

        tblDanhSachSanPham.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
    }

    private void clearProductTable() {
        int rowCount = productTableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            productTableModel.removeRow(i);
        }
    }
    // Lớp tùy chỉnh để hiển thị ảnh trong ô của bảng

    // Lớp tùy chỉnh để hiển thị ảnh trong ô của bảng
    private class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);

            // Kiểm tra nếu giá trị là ImageIcon thì hiển thị ảnh
            if (value instanceof ImageIcon) {
                ImageIcon originalIcon = (ImageIcon) value;

                // Hiển thị ảnh với kích thước đầy đủ
                label.setIcon(originalIcon);
            }

            return label;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tong = new javax.swing.JPanel();
        DonHangThanhToan = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ChonThongTinKhachHang = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        tenkhachhang = new javax.swing.JLabel();
        sdtkhachhang = new javax.swing.JLabel();
        lbmakh = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        cbbMaGiamGia = new javax.swing.JComboBox<>();
        lb = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbtienhang = new javax.swing.JLabel();
        lbGiamGia = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbTraLai = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lbTongtien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cbbHTTT = new javax.swing.JComboBox<>();
        btnHuy = new javax.swing.JButton();
        lbMaNV = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhichu = new javax.swing.JTextArea();
        lbmasanphamct = new javax.swing.JLabel();
        LISTSP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        HoaDon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        btntaohoadon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbHoaSoncho = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbldonhang = new javax.swing.JTable();

        tong.setBackground(new java.awt.Color(255, 255, 255));

        DonHangThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        DonHangThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn Hàng và Thanh toán"));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel1.setText("Tên Khách hàng:");

        jLabel3.setText("Số điện thoại:");

        ChonThongTinKhachHang.setBackground(new java.awt.Color(0, 0, 0));
        ChonThongTinKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        ChonThongTinKhachHang.setText("Chọn");
        ChonThongTinKhachHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ChonThongTinKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChonThongTinKhachHangActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã Khách hàng:");

        tenkhachhang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tenkhachhangAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(sdtkhachhang)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenkhachhang)
                            .addComponent(lbmakh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ChonThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChonThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tenkhachhang))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbmakh))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sdtkhachhang))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel9.setText("Mã Hóa Đơn:");

        txtMaHoaDon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaHoaDon.setText("HD");
        txtMaHoaDon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Tiền khách đưa:");

        jLabel16.setText("Mã giảm giá:");

        txtTienKhachDua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTienKhachDuaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTienKhachDuaFocusLost(evt);
            }
        });
        txtTienKhachDua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienKhachDuaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTienKhachDuaMouseReleased(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        cbbMaGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã giảm giá" }));
        cbbMaGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbMaGiamGiaMouseClicked(evt);
            }
        });
        cbbMaGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaGiamGiaActionPerformed(evt);
            }
        });

        lb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb.setForeground(new java.awt.Color(255, 0, 51));
        lb.setText("Tiền Hàng:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Giảm giá:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("Số Lượng:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Trả lại:");

        lbtienhang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbtienhang.setForeground(new java.awt.Color(255, 0, 51));
        lbtienhang.setText("0");

        lbGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbGiamGia.setForeground(new java.awt.Color(255, 0, 51));
        lbGiamGia.setText("0");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbSoLuong.setForeground(new java.awt.Color(255, 0, 0));
        lbSoLuong.setText("0");

        lbTraLai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTraLai.setForeground(new java.awt.Color(255, 0, 51));
        lbTraLai.setText("0");

        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tổng cộng"));

        lbTongtien.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbTongtien.setText("15.000.000");

        btnThanhToan.setBackground(new java.awt.Color(0, 0, 0));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 0, 0));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel27.setText("Hình thưc thanh toán:");

        cbbHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Phương thức thanh toán", "Tiền Mặt", "Chuyển Khoản" }));
        cbbHTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHTTTActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(0, 0, 0));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        lbMaNV.setText("NV001");

        jLabel11.setText("Mã nhân viên");

        jLabel4.setText("Ghi chú:");

        txtGhichu.setColumns(20);
        txtGhichu.setRows(5);
        jScrollPane4.setViewportView(txtGhichu);

        lbmasanphamct.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout DonHangThanhToanLayout = new javax.swing.GroupLayout(DonHangThanhToan);
        DonHangThanhToan.setLayout(DonHangThanhToanLayout);
        DonHangThanhToanLayout.setHorizontalGroup(
            DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DonHangThanhToanLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lb)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel19))
                                                .addGap(48, 48, 48)
                                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbtienhang)
                                                    .addComponent(lbSoLuong)
                                                    .addComponent(lbGiamGia)
                                                    .addComponent(lbTraLai)))
                                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel27)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel11))
                                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cbbMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                                        .addGap(41, 41, 41)
                                                        .addComponent(lbMaNV)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbmasanphamct, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(9, 9, 9))))
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel15))
                                        .addGap(56, 56, 56))
                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))))
                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTongtien))))
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnThanhToan)
                        .addGap(12, 12, 12)
                        .addComponent(btnLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DonHangThanhToanLayout.setVerticalGroup(
            DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbMaNV)
                    .addComponent(lbmasanphamct, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbbMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb)
                    .addComponent(lbtienhang))
                .addGap(18, 18, 18)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lbSoLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lbGiamGia))
                .addGap(18, 18, 18)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbTraLai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongtien, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        LISTSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách các sản phẩm"));

        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ảnh", "Tên sản phẩm", "Thương hiệu", "Số lượng", "Giá"
            }
        ));
        tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachSanPham);

        txtTimKiemSanPham.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        txtTimKiemSanPham.setText("Tên Sản Phẩm");
        txtTimKiemSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSanPhamActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tìm Kiếm:");

        cbbThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Chọn Thương hiệu --", "Samsung", "Apple", "OnePlus", "Google", "Xiaomi" }));
        cbbThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbThuongHieuMouseClicked(evt);
            }
        });
        cbbThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThuongHieuActionPerformed(evt);
            }
        });

        jLabel2.setText("Giá:");

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LISTSPLayout = new javax.swing.GroupLayout(LISTSP);
        LISTSP.setLayout(LISTSPLayout);
        LISTSPLayout.setHorizontalGroup(
            LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LISTSPLayout.createSequentialGroup()
                .addGroup(LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LISTSPLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LISTSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LISTSPLayout.setVerticalGroup(
            LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LISTSPLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
        );

        HoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã nhân Viên", "Mã khách hàng", "Trạng thái", "Ngày Mua"
            }
        ));
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhoadon);

        btntaohoadon.setBackground(new java.awt.Color(0, 0, 0));
        btntaohoadon.setForeground(new java.awt.Color(255, 255, 255));
        btntaohoadon.setText("Tạo hóa đơn");
        btntaohoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaohoadonActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("số hóa đơn chờ : ");

        lbHoaSoncho.setText("0");

        javax.swing.GroupLayout HoaDonLayout = new javax.swing.GroupLayout(HoaDon);
        HoaDon.setLayout(HoaDonLayout);
        HoaDonLayout.setHorizontalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btntaohoadon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaSoncho)
                .addGap(24, 24, 24))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        HoaDonLayout.setVerticalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntaohoadon)
                    .addComponent(jLabel6)
                    .addComponent(lbHoaSoncho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn Hàng"));

        tbldonhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ảnh", "Tên sản phẩm", "giá", "Số lượng", "Tổng tiền"
            }
        ));
        tbldonhang.setColumnSelectionAllowed(true);
        tbldonhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldonhangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbldonhang);
        tbldonhang.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tongLayout = new javax.swing.GroupLayout(tong);
        tong.setLayout(tongLayout);
        tongLayout.setHorizontalGroup(
            tongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LISTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DonHangThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tongLayout.setVerticalGroup(
            tongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tongLayout.createSequentialGroup()
                .addGroup(tongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DonHangThanhToan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tongLayout.createSequentialGroup()
                        .addComponent(LISTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DonHangThanhToan.getAccessibleContext().setAccessibleName("Đơn hàng và thanh toán");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void tblDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPhamMouseClicked
        int row = tblDanhSachSanPham.rowAtPoint(evt.getPoint());
        int col = tblDanhSachSanPham.columnAtPoint(evt.getPoint());

        if (row >= 0 && col >= 0) {
            // Hiển thị hộp thoại để nhập số lượng
            String quantityStr = JOptionPane.showInputDialog(
                    SwingUtilities.getWindowAncestor(tblDanhSachSanPham),
                    "Nhập số lượng:",
                    "Nhập số lượng",
                    JOptionPane.QUESTION_MESSAGE
            );

            // Kiểm tra nếu người dùng nhấp vào Cancel hoặc đóng hộp thoại
            if (quantityStr != null && !quantityStr.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityStr);
                    if (quantity > 0) {
                        // Lấy sản phẩm được chọn từ hàng được nhấp vào
                        selectedQuantity = quantity;
                        lbSoLuong.setText("" + selectedQuantity);
                        SanPham selectedProduct = service.getAllSanPham().get(row);

                        // Kiểm tra xem số lượng đặt hàng có vượt quá số lượng còn lại không
                        if (quantity <= selectedProduct.getSoluong()) {
                            // Set mã sản phẩm chi tiết lên label
                            lbmasanphamct.setText(selectedProduct.getMaSPCT());

                            // Tính tổng tiền
                            double totalAmount = quantity * selectedProduct.getGia();
                            TongTien += totalAmount;

                            // Hiển thị hình ảnh, tên sản phẩm, giá, số lượng và tổng tiền dưới bảng "Đơn Hàng"
                            String imagePath = "C:\\Users\\LE DINH LINH\\Downloads\\GiaoDien\\src\\img\\" + selectedProduct.getHinhSP();
                            ImageIcon hinhAnhIcon = new ImageIcon(imagePath);

                            String giaFormatted = String.format("%,.0f VND", selectedProduct.getGia()); // Định dạng giá
                            String totalAmountFormatted = String.format("%,.0f VND", totalAmount); // Định dạng tổng tiền
                            Object[] donHangRow = {hinhAnhIcon, selectedProduct.getTenSP(), giaFormatted, quantity, totalAmountFormatted};
                            DefaultTableModel donHangTableModel = (DefaultTableModel) tbldonhang.getModel();
                            donHangTableModel.insertRow(0, donHangRow); // Sử dụng insertRow để thêm vào đầu bảng
                            donHangTableModel.fireTableDataChanged();
                            lbtienhang.setText(String.format("%,.0f VND", TongTien));

                            // Cập nhật lại số lượng trong bảng sản phẩm
                            selectedProduct.setSoluong(selectedProduct.getSoluong() - quantity);
                            // Cập nhật lại bảng sản phẩm
                            productTableModel.setValueAt(selectedProduct.getSoluong(), row, 3);
                        } else {
                            JOptionPane.showMessageDialog(null, "Số lượng đặt hàng vượt quá số lượng còn lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập một số nguyên dương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int desiredWidth = 50; // Đặt giá trị mong muốn của chiều rộng
        tbldonhang.getColumnModel().getColumn(0).setPreferredWidth(desiredWidth);

        int desiredHeight = 100; // Đặt giá trị mong muốn của chiều cao
        tbldonhang.setRowHeight(desiredHeight);

        tbldonhang.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
    }//GEN-LAST:event_tblDanhSachSanPhamMouseClicked

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked

    }//GEN-LAST:event_tblhoadonMouseClicked

    private void btntaohoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaohoadonActionPerformed
        String maNV = lbMaNV.getText().trim();
        String maKH = lbmakh.getText().trim();
        String maSPCT = lbmasanphamct.getText().trim();
        if (maKH.isEmpty() || maNV.isEmpty() || maSPCT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin khách hàng");
            return;
        }

        BHservice banhangService = new BHservice();
        java.sql.Date ngayMua = new java.sql.Date(System.currentTimeMillis());
        boolean daThanhToan = true;

        HoaDon hoaDon = banhangService.themHoaDon(maNV, maKH, maSPCT, daThanhToan, ngayMua);

        if (hoaDon != null) {
            themHoaDonVaoTable(hoaDon);
            txtMaHoaDon.setText(hoaDon.getMaHD());
            lbMaNV.setText(hoaDon.getMaNV());
            lbmakh.setText(hoaDon.getMaKH());

            // Cập nhật label số hóa đơn chờ
            int soHoaDonChuaThanhToan = laySoHoaDonChuaThanhToan();
            lbHoaSoncho.setText("" + soHoaDonChuaThanhToan);
        } else {
            System.out.println("Có lỗi khi tạo hóa đơn");
        }
    }

    private void themHoaDonVaoTable(HoaDon hoaDon) {
        DefaultTableModel model = (DefaultTableModel) tblhoadon.getModel();
        String trangThaiChu = hoaDon.getTrangThai(); // Kiểm tra xem trường trạng thái có đúng với cột trong table không

        model.addRow(new Object[]{
            hoaDon.getMaHD(),
            hoaDon.getMaNV(),
            hoaDon.getMaKH(),
            trangThaiChu, // Đảm bảo rằng giá trị này phù hợp với cột TRANGTHAI trong table
            hoaDon.getNgayMua()
        });
    }//GEN-LAST:event_btntaohoadonActionPerformed
    public int laySoHoaDonChuaThanhToan() {
        DefaultTableModel model = (DefaultTableModel) tblhoadon.getModel();
        int soHoaDonChuaThanhToan = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            String trangThai = model.getValueAt(i, 3).toString(); // Cột TRANGTHAI có thể khác, hãy đảm bảo là cột chứa trạng thái hóa đơn

            if (trangThai.equalsIgnoreCase("Chưa Thanh Toán")) {
                soHoaDonChuaThanhToan++;
            }
        }

        return soHoaDonChuaThanhToan;
    }


    private void ChonThongTinKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChonThongTinKhachHangActionPerformed
        // Lấy tham chiếu đến JFrame chứa JPanel
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        // Tạo đối tượng JDialog
        JDialog dialog = new JDialog(frame, "Chọn Thông Tin Khách Hàng", true);

        // Tạo đối tượng KhachHangJFrame và lắng nghe sự kiện khi khách hàng được chọn
        BanHang banHangPanel = new BanHang();
        KhachHangJFrame khachHangFrame = new KhachHangJFrame(banHangPanel);
        khachHangFrame.addKhachHangSelectedListener(new KhachHangSelectedListener() {
            @Override
            public void onKhachHangSelected(kh khachHang) {
                // Xử lý khi khách hàng được chọn
                tenkhachhang.setText(khachHang.getTen());
                sdtkhachhang.setText(khachHang.getSdt());
                lbmakh.setText(khachHang.getmakh());
            }
        });

        // Đặt JFrame vào JDialog
        dialog.getContentPane().add(khachHangFrame.getContentPane());

        // Thiết lập kích thước và hiển thị JDialog
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

    }//GEN-LAST:event_ChonThongTinKhachHangActionPerformed

    private void tenkhachhangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tenkhachhangAncestorAdded

    }//GEN-LAST:event_tenkhachhangAncestorAdded
    private void filterDataByBrand(String selectedBrand) {
        // Kiểm tra nếu thương hiệu được chọn không phải là placeholder "-- Chọn Thương hiệu --"
        if (!selectedBrand.equals("-- Chọn Thương hiệu --")) {
            // Lọc dữ liệu của bảng dựa trên thương hiệu được chọn
            DefaultTableModel tableModel = (DefaultTableModel) tblDanhSachSanPham.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
            tblDanhSachSanPham.setRowSorter(sorter);

            // Thiết lập bộ lọc để chỉ hiển thị các hàng có thương hiệu tương ứng
            RowFilter<Object, Object> brandFilter = RowFilter.regexFilter(selectedBrand, 2); // 2 là chỉ số cột chứa thông tin thương hiệu
            sorter.setRowFilter(brandFilter);
        } else {
            // Nếu chọn "-- Chọn Thương hiệu --", hiển thị toàn bộ dữ liệu
            tblDanhSachSanPham.setRowSorter(null);
        }
    }

    private void cbbThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThuongHieuActionPerformed
        // Lấy thương hiệu được chọn từ ComboBox
        String selectedBrand = (String) cbbThuongHieu.getSelectedItem();

        // Gọi hàm để lọc dữ liệu dựa trên thương hiệu được chọn
        filterDataByBrand(selectedBrand);
    }//GEN-LAST:event_cbbThuongHieuActionPerformed

    private void cbbThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbThuongHieuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbThuongHieuMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

// Lấy thông tin cần thiết từ giao diện người dùng
        String maKH = lbmakh.getText();
        String maNV = lbMaNV.getText();
        String maHD = txtMaHoaDon.getText();

        // Kiểm tra và chuyển đổi các giá trị số
        float tienKhachDua = 0.0f;
        float tienTraLai = 0.0f;
        float giamGia = 0.0f;
        float tongCong = 0.0f;
        float donGia = 0.0f;

        try {
            tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
            tienTraLai = Float.parseFloat(lbTraLai.getText().replace(" VND", "").replace(",", ""));
            giamGia = Float.parseFloat(lbGiamGia.getText().replace(" VND", "").replace(",", ""));
            tongCong = Float.parseFloat(lbTongtien.getText().replace(" VND", "").replace(",", ""));
            donGia = Float.parseFloat(lbtienhang.getText().replace(" VND", "").replace(",", ""));
        } catch (NumberFormatException e) {
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(parentComponent, "Vui lòng nhập số tiền hợp lệ");
            return;
        }

        String maKM = cbbMaGiamGia.getSelectedItem().toString();
        String ghiChu = txtGhichu.getText();
        int soLuong = Integer.parseInt(lbSoLuong.getText());
        String hinhThucThanhToan = cbbHTTT.getSelectedItem().toString();
        String maSPCT = lbmasanphamct.getText();

        // Kiểm tra xem các thông tin có hợp lệ hay không
        if (maNV.isEmpty() || maHD.isEmpty() || maKM.isEmpty() || ghiChu.isEmpty() || soLuong <= 0) {
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(parentComponent, "Vui lòng nhập đầy đủ thông tin và số lượng lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thanh toán?", "Xác nhận thanh toán", JOptionPane.YES_NO_OPTION);

        // Xử lý kết quả xác nhận
        if (confirmResult == JOptionPane.YES_OPTION) {
            // Gọi phương thức thanhToan từ BanHangService
            BHservice banHangService = new BHservice();

            // Pass additional parameters (giamGia) to the thanhToan method
            banHangService.thanhToan(maHD, maKH, tienKhachDua, tienTraLai, hinhThucThanhToan, tongCong, ghiChu, maKM, giamGia, soLuong, donGia, maSPCT);

            // Hiển thị thông báo hoặc cập nhật giao diện người dùng nếu cần
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            int soHoaDonChuaThanhToan = laySoHoaDonChuaThanhToan();
            lbHoaSoncho.setText("" + soHoaDonChuaThanhToan);
            int printResult = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn?", "Xác nhận in hóa đơn", JOptionPane.YES_NO_OPTION);

            if (confirmResult == JOptionPane.YES_OPTION) {
                InHoaDon inHoaDonFrame = new InHoaDon();
                inHoaDonFrame.setVisible(true); // Hiển thị JFrame in hóa đơn
                inHoaDonFrame.displayInvoiceData(); // Gọi phương thức hiển thị dữ liệu hóa đơn trong JFrame in hóa đơn
                inHoaDonFrame.printInvoice();
                Component parentComponent = SwingUtilities.getWindowAncestor(this);
                JOptionPane.showMessageDialog(parentComponent, "Đã in file pdf thành công");
                return;
            }
        }
        clear();

    }//GEN-LAST:event_btnThanhToanActionPerformed


    private void tbldonhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldonhangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbldonhangMouseClicked

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed

    }//GEN-LAST:event_txtTienKhachDuaActionPerformed


    private void cbbHTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHTTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHTTTActionPerformed

    private void cbbMaGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaGiamGiaActionPerformed

    }//GEN-LAST:event_cbbMaGiamGiaActionPerformed

    private void cbbMaGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbMaGiamGiaMouseClicked
        initComboBoxTatCaMaGiamGia();
    }//GEN-LAST:event_cbbMaGiamGiaMouseClicked

    private void txtTienKhachDuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseClicked

    }//GEN-LAST:event_txtTienKhachDuaMouseClicked

    private void txtTienKhachDuaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseReleased

    }//GEN-LAST:event_txtTienKhachDuaMouseReleased


    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        tinhToanVaCapNhat();
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void txtTienKhachDuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienKhachDuaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaFocusGained

    private void txtTienKhachDuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienKhachDuaFocusLost
        // TODO add your handling code her
    }//GEN-LAST:event_txtTienKhachDuaFocusLost

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed

    }//GEN-LAST:event_txtGiaActionPerformed


    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed

// Lấy thông tin cần thiết từ giao diện người dùng
        String maKH = lbmakh.getText();
        String maNV = lbMaNV.getText();
        String maHD = txtMaHoaDon.getText();

        // Kiểm tra và chuyển đổi các giá trị số
        float tienKhachDua = 0.0f;
        float tienTraLai = 0.0f;
        float giamGia = 0.0f;
        float tongCong = 0.0f;
        float donGia = 0.0f;

        try {
            tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
            tienTraLai = Float.parseFloat(lbTraLai.getText().replace(" VND", "").replace(",", ""));
            giamGia = Float.parseFloat(lbGiamGia.getText().replace(" VND", "").replace(",", ""));
            tongCong = Float.parseFloat(lbTongtien.getText().replace(" VND", "").replace(",", ""));
            donGia = Float.parseFloat(lbtienhang.getText().replace(" VND", "").replace(",", ""));
        } catch (NumberFormatException e) {
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(parentComponent, "Vui lòng nhập số tiền hợp lệ");
            return;
        }

        String maKM = cbbMaGiamGia.getSelectedItem().toString();
        String ghiChu = txtGhichu.getText();
        int soLuong = Integer.parseInt(lbSoLuong.getText());
        String hinhThucThanhToan = cbbHTTT.getSelectedItem().toString();
        String maSPCT = lbmasanphamct.getText();

        // Kiểm tra xem các thông tin có hợp lệ hay không
        if (maNV.isEmpty() || maHD.isEmpty() || maKM.isEmpty() || ghiChu.isEmpty() || soLuong <= 0) {
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(parentComponent, "Vui lòng nhập đầy đủ thông tin và số lượng lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn Muốn hủy thanh toán?", "Xác nhận Hủy thanh toán", JOptionPane.YES_NO_OPTION);

        // Xử lý kết quả xác nhận
        if (confirmResult == JOptionPane.YES_OPTION) {
            // Gọi phương thức thanhToan từ BanHangService
            BHservice banHangService = new BHservice();

            // Pass additional parameters (giamGia) to the thanhToan method
            banHangService.huythanhToan(maHD, maKH, tienKhachDua, tienTraLai, hinhThucThanhToan, donGia, ghiChu, maKM, giamGia, soLuong, donGia, maSPCT);

            // Hiển thị thông báo hoặc cập nhật giao diện người dùng nếu cần
            JOptionPane.showMessageDialog(this, "Hủy Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
           
        
        }
    }//GEN-LAST:event_btnHuyActionPerformed
    public void clear() {
        Donhang = (DefaultTableModel) tbldonhang.getModel();
        Donhang.removeRow(0);
        Donhang = (DefaultTableModel) tblhoadon.getModel();
        Donhang.removeRow(0);
        txtMaHoaDon.setText("");
        lbmakh.setText("");
        txtTienKhachDua.setText("");
        lbTraLai.setText("");
        lbGiamGia.setText("");
        lbTongtien.setText("");
        cbbMaGiamGia.setSelectedIndex(0);
        txtGhichu.setText("");
        lbSoLuong.setText("");
        tenkhachhang.setText("");
        sdtkhachhang.setText("");
    }
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        tenkhachhang.setText("");
        sdtkhachhang.setText("");
        txtMaHoaDon.setText("");
        lbmakh.setText("");
        txtTienKhachDua.setText("");
        lbTraLai.setText("");
        lbGiamGia.setText("");
        lbTongtien.setText("");
        cbbMaGiamGia.setSelectedIndex(0);
        txtGhichu.setText("");
        lbSoLuong.setText("");

        JOptionPane.showMessageDialog(this, "Dữ liệu đã được làm mới.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamActionPerformed
        // Lấy tên sản phẩm từ ô tìm kiếm
        String tenSanPham = txtTimKiemSanPham.getText().trim();

        // Gọi phương thức tìm kiếm sản phẩm theo tên
        BHservice banHangService = new BHservice();
        ArrayList<SanPham> ketQuaTimKiem = banHangService.timKiemSanPhamTheoTen(tenSanPham);

        // Cập nhật dữ liệu hiển thị trên bảng sản phẩm
        capNhatTableSanPham(ketQuaTimKiem);
    }

    private void capNhatTableSanPham(ArrayList<SanPham> danhSachSanPham) {
        // Xóa tất cả các dòng trong bảng sản phẩm
        DefaultTableModel model = (DefaultTableModel) tblDanhSachSanPham.getModel();
        model.setRowCount(0);

        // Thêm dữ liệu mới vào bảng sản phẩm
        for (SanPham sanPham : danhSachSanPham) {
            // Lấy dữ liệu ảnh, thương hiệu, số lượng và giá từ đối tượng SanPham
            ImageIcon hinhAnh = sanPham.getHinhSP(); // Giả sử có một phương thức getHinhAnh trả về ImageIcon

            Object[] rowData = {
                hinhAnh, // Ảnh
                sanPham.getTenSP(), // Tên sản phẩm
                sanPham.getThuongHieu(), // Thương hiệu
                sanPham.getSoluong(), // Số lượng
                sanPham.getGia() // Giá
            };
            model.addRow(rowData);
        }

    }//GEN-LAST:event_txtTimKiemSanPhamActionPerformed
    private void initComboBoxTatCaMaGiamGia() {
        BHservice banhangService = new BHservice();
        ArrayList<String> tatCaMaKhuyenMai = banhangService.tatCaMaKhuyenMai();

        if (tatCaMaKhuyenMai != null && !tatCaMaKhuyenMai.isEmpty()) {
            System.out.println("Dữ liệu từ SQL: " + tatCaMaKhuyenMai);

            // Sử dụng DefaultComboBoxModel để quản lý items
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(tatCaMaKhuyenMai.toArray(new String[0]));

            // Đặt mô hình mới cho JComboBox
            cbbMaGiamGia.setModel(model);

            // Thêm sự kiện lắng nghe cho sự kiện chọn mã giảm giá
            cbbMaGiamGia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Gọi phương thức tính toán và cập nhật khi mã giảm giá được chọn
                    tinhToanVaCapNhat();
                }
            });
        } else {
            System.out.println("Không có dữ liệu từ SQL hoặc có lỗi khi truy xuất.");
        }
    }

    private void tinhToanVaCapNhat() {
        try {
            // Lấy số tiền từ Label "Tiền hàng"
            double tienHang = TongTien;

            // Lấy số tiền khách đưa từ TextField
            String tienKhachDuaStr = txtTienKhachDua.getText().replaceAll("[^0-9.]", ""); // Loại bỏ ký tự không phải số
            double tienKhachDua = Double.parseDouble(tienKhachDuaStr);

            // Lấy mã khuyến mãi từ ComboBox
            String maKhuyenMai = (String) cbbMaGiamGia.getSelectedItem();

            // Lấy phần trăm giảm giá từ cơ sở dữ liệu
            BHservice banhangService = new BHservice();
            float phanTramGiamGia = banhangService.layPhanTramGiamGia(maKhuyenMai);
            System.out.println("Phan tram giam gia: " + phanTramGiamGia);

            double tienGiamGia = tienHang * phanTramGiamGia / 100;

            // Tính số tiền cần trả
            double tongTienCanTra = tienHang - tienGiamGia;
            double tienThua = tienKhachDua - tongTienCanTra;

            // Hiển thị số tiền thừa hoặc 0 nếu không có
            lbTraLai.setText(String.format("%,.0f VND", Math.max(0, tienThua)));

            // Hiển thị giảm giá
            lbGiamGia.setText(String.format("%,.0f VND", tienGiamGia));

            // Hiển thị tổng tiền cần trả
            lbTongtien.setText(String.format("%,.0f VND", tongTienCanTra));

        } catch (NumberFormatException ex) {
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(parentComponent, "Vui lòng nhập số tiền hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void capNhatTongTien() {
        // Lấy số lượng hàng trong bảng đơn hàng
        int rowCount = tbldonhang.getRowCount();

        // Reset tổng tiền về 0
        TongTien = 0;

        // Duyệt qua từng hàng trong bảng đơn hàng để tính tổng tiền
        for (int i = 0; i < rowCount; i++) {
            double totalAmount = Double.parseDouble(tbldonhang.getValueAt(i, 4).toString().replace(" VND", "").replace(",", ""));
            TongTien += totalAmount;
        }

        // Hiển thị tổng tiền
        lb.setText(String.format("%,.0f VND", TongTien));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ChonThongTinKhachHang;
    private javax.swing.JPanel DonHangThanhToan;
    private javax.swing.JPanel HoaDon;
    private javax.swing.JPanel LISTSP;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btntaohoadon;
    private javax.swing.JComboBox<String> cbbHTTT;
    private javax.swing.JComboBox<String> cbbMaGiamGia;
    private javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbGiamGia;
    private javax.swing.JLabel lbHoaSoncho;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTongtien;
    private javax.swing.JLabel lbTraLai;
    private javax.swing.JLabel lbmakh;
    private javax.swing.JLabel lbmasanphamct;
    private javax.swing.JLabel lbtienhang;
    private javax.swing.JLabel sdtkhachhang;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTable tbldonhang;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JLabel tenkhachhang;
    private javax.swing.JPanel tong;
    private javax.swing.JTextArea txtGhichu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiemSanPham;
    // End of variables declaration//GEN-END:variables
}
