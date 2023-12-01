package view;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import Model.HoaDon;
import Model.KhachHang;
import Model.SanPham;
import Model.kh;
import Model.kh.KhachHangSelectedListener;
import Sevice.BanhangService;
/**
 *
 * @author LE DINH LINH
 */
public class BanHang extends javax.swing.JPanel implements KhachHangSelectedListener {

    private final Sevice.BanhangService service = new Sevice.BanhangService();
    private int hientai = 0;
    private DefaultTableModel productTableModel;
    private DefaultTableModel invoiceTableModel;

    public BanHang() {
        initComponents();
        productTableModel = (DefaultTableModel) DanhSachSanPham.getModel();
        invoiceTableModel = (DefaultTableModel) hoadon.getModel();
        loadDataToProductTable();

    }

    public void onKhachHangSelected(kh khachHang) {
        // Cập nhật thông tin khách hàng trên giao diện của BanHang
        tenkhachhang.setText(khachHang.getTen());
        sdtkhachhang.setText(khachHang.getSdt());
        emailkhachhang.setText(khachHang.getEmail());
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
                String imagePath = "D:\\DuAnQLDT\\QLDABanDienThoai\\GiaoDien\\src\\img" + sp.getHinhSP();
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
        DanhSachSanPham.getColumnModel().getColumn(0).setPreferredWidth(desiredWidth);

        int desiredHeight = 100; // Đặt giá trị mong muốn của chiều cao
        DanhSachSanPham.setRowHeight(desiredHeight);

        DanhSachSanPham.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
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
        emailkhachhang = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        btntaohoadon = new javax.swing.JButton();
        LISTSP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DanhSachSanPham = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        HoaDon = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        hoadon = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        donhang = new javax.swing.JTable();

        tong.setBackground(new java.awt.Color(255, 255, 255));

        DonHangThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        DonHangThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn Hàng và Thanh toán"));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel1.setText("Tên Khách hàng:");

        jLabel3.setText("Số điện thoại:");

        ChonThongTinKhachHang.setBackground(new java.awt.Color(255, 204, 255));
        ChonThongTinKhachHang.setText("Chọn");
        ChonThongTinKhachHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ChonThongTinKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChonThongTinKhachHangActionPerformed(evt);
            }
        });

        jLabel5.setText("Email:");

        tenkhachhang.setText("jLabel2");
        tenkhachhang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tenkhachhangAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        sdtkhachhang.setText("jLabel4");

        emailkhachhang.setText("jLabel6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenkhachhang)
                            .addComponent(sdtkhachhang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ChonThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(emailkhachhang)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tenkhachhang))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sdtkhachhang)
                            .addComponent(jLabel3)))
                    .addComponent(ChonThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(emailkhachhang))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel9.setText("Mã Hóa Đơn:");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("HD");
        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Tiền khách đưa:");

        jLabel16.setText("Mã giảm giá:");

        jTextField4.setText("10.000.000");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã giảm giá" }));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("Tiền Hàng:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Giảm giá:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("Cần Trả:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Trả lại:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("100.000.000");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("0");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("99.000.000");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 51));
        jLabel26.setText("0");

        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tổng cộng"));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel25.setText("15.000.000");

        jButton2.setBackground(new java.awt.Color(255, 204, 255));
        jButton2.setText("Thanh toán");

        jButton3.setBackground(new java.awt.Color(255, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Làm Mới");

        jLabel27.setText("Hình thưc thanh toán:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Phương thức thanh toán", "Tiền Mặt", "Chuyển Khoản" }));

        jLabel10.setText("Tiền thừa:");

        jButton5.setBackground(new java.awt.Color(255, 204, 255));
        jButton5.setText("Hủy");

        btntaohoadon.setBackground(new java.awt.Color(255, 204, 255));
        btntaohoadon.setText("Tạo hóa đơn");
        btntaohoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaohoadonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DonHangThanhToanLayout = new javax.swing.GroupLayout(DonHangThanhToan);
        DonHangThanhToan.setLayout(DonHangThanhToanLayout);
        DonHangThanhToanLayout.setHorizontalGroup(
            DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9))
                                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel22)
                                                    .addComponent(jLabel24)
                                                    .addComponent(jLabel23)
                                                    .addComponent(jLabel26)
                                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btntaohoadon))))
                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25)))
                                .addGap(0, 49, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        DonHangThanhToanLayout.setVerticalGroup(
            DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntaohoadon))
                .addGap(31, 31, 31)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DonHangThanhToanLayout.createSequentialGroup()
                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LISTSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách các sản phẩm"));

        DanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        DanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DanhSachSanPham);

        jTextField1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        jTextField1.setText("Tên Sản Phẩm");
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
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

        javax.swing.GroupLayout LISTSPLayout = new javax.swing.GroupLayout(LISTSP);
        LISTSP.setLayout(LISTSPLayout);
        LISTSPLayout.setHorizontalGroup(
            LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LISTSPLayout.createSequentialGroup()
                .addGroup(LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LISTSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(LISTSPLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 232, Short.MAX_VALUE)))
                .addContainerGap())
        );
        LISTSPLayout.setVerticalGroup(
            LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LISTSPLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
        );

        HoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tìm Kiếm:");

        hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã nhân Viên", "Mã khách hàng", "Trạng thái", "Ngày Mua"
            }
        ));
        hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(hoadon);

        jRadioButton1.setText("Đã Thanh Toán");

        jRadioButton2.setText("Chưa Thanh Toán");

        jRadioButton3.setText("Húy");

        javax.swing.GroupLayout HoaDonLayout = new javax.swing.GroupLayout(HoaDon);
        HoaDon.setLayout(HoaDonLayout);
        HoaDonLayout.setHorizontalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        HoaDonLayout.setVerticalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn Hàng"));

        donhang.setModel(new javax.swing.table.DefaultTableModel(
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
        donhang.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(donhang);
        donhang.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout tongLayout = new javax.swing.GroupLayout(tong);
        tong.setLayout(tongLayout);
        tongLayout.setHorizontalGroup(
            tongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LISTSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DonHangThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void DanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DanhSachSanPhamMouseClicked
        int row = DanhSachSanPham.rowAtPoint(evt.getPoint());
        int col = DanhSachSanPham.columnAtPoint(evt.getPoint());

        if (row >= 0 && col >= 0) {
            // Hiển thị hộp thoại để nhập số lượng
            String quantityStr = JOptionPane.showInputDialog(
                    SwingUtilities.getWindowAncestor(DanhSachSanPham),
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
                        SanPham selectedProduct = service.getAllSanPham().get(row);

                        // Kiểm tra xem số lượng đặt hàng có vượt quá số lượng còn lại không
                        if (quantity <= selectedProduct.getSoluong()) {
                            // Tính tổng tiền
                            double totalAmount = quantity * selectedProduct.getGia();

                            // Hiển thị hình ảnh, tên sản phẩm, giá, số lượng và tổng tiền dưới bảng "Đơn Hàng"
                            String imagePath = "D:\\DuAnQLDT\\QLDABanDienThoai\\GiaoDien\\src\\img\\" + selectedProduct.getHinhSP();
                            ImageIcon hinhAnhIcon = new ImageIcon(imagePath);

                            String giaFormatted = String.format("%,.0f VND", selectedProduct.getGia()); // Định dạng giá
                            String totalAmountFormatted = String.format("%,.0f VND", totalAmount); // Định dạng tổng tiền
                            Object[] donHangRow = {hinhAnhIcon, selectedProduct.getTenSP(), giaFormatted, quantity, totalAmountFormatted};
                            DefaultTableModel donHangTableModel = (DefaultTableModel) donhang.getModel();
                            donHangTableModel.insertRow(0, donHangRow); // Sử dụng insertRow để thêm vào đầu bảng

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
        donhang.getColumnModel().getColumn(0).setPreferredWidth(desiredWidth);

        int desiredHeight = 100; // Đặt giá trị mong muốn của chiều cao
        donhang.setRowHeight(desiredHeight);

        donhang.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
    }//GEN-LAST:event_DanhSachSanPhamMouseClicked

    private void hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hoadonMouseClicked

    }//GEN-LAST:event_hoadonMouseClicked

    private void btntaohoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaohoadonActionPerformed
      
    }//GEN-LAST:event_btntaohoadonActionPerformed

    private void ChonThongTinKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChonThongTinKhachHangActionPerformed
        // Lấy tham chiếu đến JFrame chứa JPanel
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        // Tạo đối tượng JDialog
        JDialog dialog = new JDialog(frame, "Chọn Thông Tin Khách Hàng", true);

        // Tạo đối tượng KhachHangJFrame và lắng nghe sự kiện khi khách hàng được chọn
        BanHang banHangPanel = new BanHang();
        KhachHangJFrame khachHangFrame = new KhachHangJFrame(banHangPanel);
        khachHangFrame.addKhachHangSelectedListener(new KhachHangSelectedListener() {
            public void onKhachHangSelected(kh khachHang) {
                // Xử lý khi khách hàng được chọn
                tenkhachhang.setText(khachHang.getTen());
                sdtkhachhang.setText(String.valueOf(khachHang.getSdt()));
                emailkhachhang.setText(khachHang.getEmail());

                // Đóng JDialog sau khi chọn khách hàng
//                dialog.dispose();
            }

            public void onKhachHangSelecte(kh khang1) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            DefaultTableModel tableModel = (DefaultTableModel) DanhSachSanPham.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
            DanhSachSanPham.setRowSorter(sorter);

            // Thiết lập bộ lọc để chỉ hiển thị các hàng có thương hiệu tương ứng
            RowFilter<Object, Object> brandFilter = RowFilter.regexFilter(selectedBrand, 2); // 2 là chỉ số cột chứa thông tin thương hiệu
            sorter.setRowFilter(brandFilter);
        } else {
            // Nếu chọn "-- Chọn Thương hiệu --", hiển thị toàn bộ dữ liệu
            DanhSachSanPham.setRowSorter(null);
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ChonThongTinKhachHang;
    private javax.swing.JTable DanhSachSanPham;
    private javax.swing.JPanel DonHangThanhToan;
    private javax.swing.JPanel HoaDon;
    private javax.swing.JPanel LISTSP;
    private javax.swing.JButton btntaohoadon;
    private javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JTable donhang;
    private javax.swing.JLabel emailkhachhang;
    private javax.swing.JTable hoadon;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel sdtkhachhang;
    private javax.swing.JLabel tenkhachhang;
    private javax.swing.JPanel tong;
    // End of variables declaration//GEN-END:variables
}
