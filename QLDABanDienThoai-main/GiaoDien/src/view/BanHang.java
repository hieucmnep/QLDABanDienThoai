package view;

import Model.HoaDon;
import Model.kh;
import Model.kh.KhachHangSelectedListener;
import Sevice.BanHangService;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import view.KhachHangJFrame;
import view.SanPham1;

/**
 *
 * @author LE DINH LINH
 */
public class BanHang extends javax.swing.JPanel implements KhachHangSelectedListener {

    private final BanHangService service = new BanHangService();
    private int hientai = 0;
    private double tongTien = 0;
    private DefaultTableModel productTableModel;
    private DefaultTableModel invoiceTableModel;
    private int selectedQuantity = 0;

    public BanHang() {
        initComponents();
        productTableModel = (DefaultTableModel) DanhSachSanPham.getModel();
        invoiceTableModel = (DefaultTableModel) tblhoadon.getModel();
        loadDataToProductTable();

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
        ArrayList<model.SanPham> productList = service.getAllSanPham();

        // Kiểm tra nếu danh sách không rỗng thì hiển thị lên bảng
        if (!productList.isEmpty()) {
            for (model.SanPham sp : productList) {
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
        jButton3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cbbHTTT = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        lbMaNV = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhichu = new javax.swing.JTextArea();
        LISTSP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DanhSachSanPham = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        HoaDon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        btntaohoadon = new javax.swing.JButton();
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

        lbmakh.setText("Mã kh");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Làm Mới");

        jLabel27.setText("Hình thưc thanh toán:");

        cbbHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Phương thức thanh toán", "Tiền Mặt", "Chuyển Khoản" }));
        cbbHTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHTTTActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Hủy");

        lbMaNV.setText("NV001");

        jLabel11.setText("Mã nhân viên");

        jLabel4.setText("Ghi chú:");

        txtGhichu.setColumns(20);
        txtGhichu.setRows(5);
        jScrollPane4.setViewportView(txtGhichu);

        javax.swing.GroupLayout DonHangThanhToanLayout = new javax.swing.GroupLayout(DonHangThanhToan);
        DonHangThanhToan.setLayout(DonHangThanhToanLayout);
        DonHangThanhToanLayout.setHorizontalGroup(
            DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(36, 36, 36)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMaNV)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbtienhang)
                                    .addComponent(lbSoLuong)
                                    .addComponent(lbGiamGia)
                                    .addComponent(lbTraLai)))
                            .addComponent(jSeparator1))))
                .addContainerGap())
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel27)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel4)
                    .addComponent(lb)
                    .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel21)
                        .addComponent(jLabel19))
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTongtien))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DonHangThanhToanLayout.setVerticalGroup(
            DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbbMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb)
                    .addComponent(lbtienhang))
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbSoLuong))
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lbGiamGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbTraLai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DonHangThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DonHangThanhToanLayout.createSequentialGroup()
                        .addComponent(lbTongtien)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        LISTSPLayout.setVerticalGroup(
            LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LISTSPLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(LISTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
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

        javax.swing.GroupLayout HoaDonLayout = new javax.swing.GroupLayout(HoaDon);
        HoaDon.setLayout(HoaDonLayout);
        HoaDonLayout.setHorizontalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btntaohoadon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HoaDonLayout.setVerticalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btntaohoadon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
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
        donhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donhangMouseClicked(evt);
            }
        });
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
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
                .addComponent(DonHangThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        tongLayout.setVerticalGroup(
            tongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tongLayout.createSequentialGroup()
                .addComponent(LISTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 159, Short.MAX_VALUE))
            .addGroup(tongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DonHangThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DonHangThanhToan.getAccessibleContext().setAccessibleName("Đơn hàng và thanh toán");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        selectedQuantity = quantity;
                        lbSoLuong.setText("" + selectedQuantity);
                        model.SanPham selectedProduct = service.getAllSanPham().get(row);

                        // Kiểm tra xem số lượng đặt hàng có vượt quá số lượng còn lại không
                        if (quantity <= selectedProduct.getSoluong()) {
                            // Tính tổng tiền
                            double totalAmount = quantity * selectedProduct.getGia();
                            tongTien += totalAmount;
                            // Hiển thị hình ảnh, tên sản phẩm, giá, số lượng và tổng tiền dưới bảng "Đơn Hàng"
                            String imagePath = "C:\\Users\\LE DINH LINH\\Downloads\\GiaoDien\\src\\img\\" + selectedProduct.getHinhSP();
                            ImageIcon hinhAnhIcon = new ImageIcon(imagePath);

                            String giaFormatted = String.format("%,.0f VND", selectedProduct.getGia()); // Định dạng giá
                            String totalAmountFormatted = String.format("%,.0f VND", totalAmount); // Định dạng tổng tiền
                            Object[] donHangRow = {hinhAnhIcon, selectedProduct.getTenSP(), giaFormatted, quantity, totalAmountFormatted};
                            DefaultTableModel donHangTableModel = (DefaultTableModel) donhang.getModel();
                            donHangTableModel.insertRow(0, donHangRow); // Sử dụng insertRow để thêm vào đầu bảng
                            lbtienhang.setText(String.format("%,.0f VND", tongTien));
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

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked

    }//GEN-LAST:event_tblhoadonMouseClicked

    private void btntaohoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaohoadonActionPerformed

        // Lấy mã nhân viên từ label lblMaNV
        String maNV = lbMaNV.getText();

        // Lấy mã khách hàng từ label lblMaKH
        String maKH = lbmakh.getText();

        BanHangService banhangService = new BanHangService();
        java.sql.Date ngayMua = new java.sql.Date(System.currentTimeMillis()); // Sử dụng java.sql.Date

        HoaDon hoaDon = banhangService.themHoaDon(maNV, maKH, true, ngayMua);

        if (hoaDon != null) {
            // Nếu hóa đơn được tạo thành công, thêm nó vào table
            themHoaDonVaoTable(hoaDon);
            // Hiển thị mã hóa đơn lên label
            txtMaHoaDon.setText(hoaDon.getMaHD());
            System.out.println("Đã tạo hóa đơn mới: " + hoaDon.getMaHD());
            // Hiển thị mã nhân viên lên label
            lbMaNV.setText(hoaDon.getMaNV());

            // Hiển thị mã khách hàng lên label (nếu có)
            lbmakh.setText(hoaDon.getMaKH());
        } else {
            // Xử lý khi có lỗi xảy ra
            System.out.println("Có lỗi khi tạo hóa đơn");
        }
    }
// Phương thức để thêm hóa đơn vào table

    private void themHoaDonVaoTable(HoaDon hoaDon) {
        DefaultTableModel model = (DefaultTableModel) tblhoadon.getModel();

        // Thêm hàng mới vào table
        model.addRow(new Object[]{
            hoaDon.getMaHD(),
            hoaDon.getMaNV(),
            hoaDon.getMaKH(),
            hoaDon.getTrangThai(),
            hoaDon.getNgayMua()
        });
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

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
//        // Lấy mã hóa đơn từ label txtMaHoaDon
//        String maHoaDon = txtMaHoaDon.getText();
//
//        // Lấy mã khách hàng từ label lbmakh
//        String maKhachHang = lbmakh.getText();
//
//        // Lấy thông tin thanh toán từ các component khác trên giao diện
//        String hinhThucThanhToan = (String) cbbHTTT.getSelectedItem();
//        String maKhuyenMai = (String) cbbMaGiamGia.getSelectedItem();
//        double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText().replaceAll("[^0-9.]", "")); // Loại bỏ ký tự không phải số
//        String ghiChu = txtGhichu.getText();
//        double soLuong = Double.parseDouble(lbSoLuong.getText());
//        double giamGia = Double.parseDouble(lbGiamGia.getText().replaceAll("[^0-9.]", ""));
//        double tienTraLai = Double.parseDouble(lbTraLai.getText().replaceAll("[^0-9.]", ""));
//
//        // Thực hiện thanh toán
//        thanhToan(maHoaDon, maKhachHang, tienKhachDua, tienTraLai, hinhThucThanhToan, soLuong, giamGia, tienTraLai, ghiChu, maKhuyenMai);
//    }
//
//// Phương thức thanh toán
//    private void thanhToan(String maHoaDon, String maKhachHang, double tienKhachDua, double tienTraLai,
//            String hinhThucThanhToan, double soLuong, double giamGia, double tongTien, String ghiChu, String maKhuyenMai) {
//        try {
//            // Gọi đến service hoặc class xử lý cơ sở dữ liệu để thực hiện thanh toán
//            BanhangService banhangService = new BanhangService();
//            banhangService.thanhToan(maHoaDon, maKhachHang, tienKhachDua, tienTraLai, hinhThucThanhToan, soLuong, giamGia, tongTien, ghiChu, maKhuyenMai);
//
//            // Cập nhật giao diện hoặc thực hiện các công việc khác nếu cần
//            // Ví dụ: reset các field, cập nhật bảng,...
//            // Hiển thị thông báo thanh toán thành công
//            JOptionPane.showMessageDialog(this, "Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thanh toán.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
//

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void donhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donhangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_donhangMouseClicked

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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    private void tinhToanVaCapNhat() {
        try {
            // Lấy số tiền từ Label "Tiền hàng"
            double tienHang = tongTien;

            // Lấy số tiền khách đưa từ TextField
            String tienKhachDuaStr = txtTienKhachDua.getText().replaceAll("[^0-9.]", ""); // Loại bỏ ký tự không phải số
            double tienKhachDua = Double.parseDouble(tienKhachDuaStr);

            // Tính số tiền cần trả
            double tienCanTra = tienKhachDua - tienHang;

            // Hiển thị số tiền cần trả
            lbTraLai.setText(String.format("%,.0f VND", tienCanTra));

            // Nếu có thừa tiền, hiển thị và cập nhật tổng cộng
            if (tienCanTra >= 0) {
                lbTraLai.setText(String.format("%,.0f VND", tienCanTra));  // Hiển thị số tiền trả lại
                lbTongtien.setText(String.format("%,.0f VND", tienHang));
            } else {
                // Nếu không có thừa, đặt lại label trả lại và cập nhật tổng cộng
                lbTraLai.setText("0 VND");  // Không có tiền trả lại
                lbTongtien.setText(String.format("%,.0f VND", tienKhachDua));
            }

        } catch (NumberFormatException ex) {
            // Xử lý khi người dùng nhập không phải số
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComboBoxTatCaMaGiamGia() {
        BanHangService banhangService = new BanHangService();
        ArrayList<String> tatCaMaKhuyenMai = banhangService.layTatCaMaKhuyenMai();

        if (tatCaMaKhuyenMai != null) {
            System.out.println("Dữ liệu từ SQL: " + tatCaMaKhuyenMai);

            // Sử dụng DefaultComboBoxModel để quản lý items
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            // Thêm danh sách tất cả các mã khuyến mãi vào mô hình
            for (String maKhuyenMai : tatCaMaKhuyenMai) {
                model.addElement(maKhuyenMai);
            }

            // Đặt mô hình mới cho JComboBox
            cbbMaGiamGia.setModel(model);
        } else {
            System.out.println("Không có dữ liệu từ SQL hoặc có lỗi khi truy xuất.");
        }
    }

    private void capNhatTongTien() {
        // Lấy số lượng hàng trong bảng đơn hàng
        int rowCount = donhang.getRowCount();

        // Reset tổng tiền về 0
        tongTien = 0;

        // Duyệt qua từng hàng trong bảng đơn hàng để tính tổng tiền
        for (int i = 0; i < rowCount; i++) {
            double totalAmount = Double.parseDouble(donhang.getValueAt(i, 4).toString().replace(" VND", "").replace(",", ""));
            tongTien += totalAmount;
        }

        // Hiển thị tổng tiền
        lb.setText(String.format("%,.0f VND", tongTien));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ChonThongTinKhachHang;
    private javax.swing.JTable DanhSachSanPham;
    private javax.swing.JPanel DonHangThanhToan;
    private javax.swing.JPanel HoaDon;
    private javax.swing.JPanel LISTSP;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btntaohoadon;
    private javax.swing.JComboBox<String> cbbHTTT;
    private javax.swing.JComboBox<String> cbbMaGiamGia;
    private javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JTable donhang;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbGiamGia;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTongtien;
    private javax.swing.JLabel lbTraLai;
    private javax.swing.JLabel lbmakh;
    private javax.swing.JLabel lbtienhang;
    private javax.swing.JLabel sdtkhachhang;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JLabel tenkhachhang;
    private javax.swing.JPanel tong;
    private javax.swing.JTextArea txtGhichu;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
