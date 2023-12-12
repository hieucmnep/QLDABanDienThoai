package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import model.SPChiTiet;
import model.SPchitiet_sql;
import model.Sanpham_sql;
import model.SanPham_model;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

//import java.sql.*;
//import dbconnect.DBConnector;
//import java.awt.Color;
//import java.util.ArrayList;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JLabel;
//import model.Mycombobox;
//import java.sql.Connection;
//import java.awt.event.ActionListener;
public class SanPham extends javax.swing.JPanel {

    SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
    Sanpham_sql sql = new Sanpham_sql();
    String stranh = null;
    SPchitiet_sql sqlct = new SPchitiet_sql();
    int row = 0;
    DefaultTableModel dtm = null;
    private String datashow;

    public SanPham() {
        initComponents();
        loadtable();
        loadtablespct();
        loadtablett();
//        Mausacsp();
//        Noisxcsp();
//        Ramcsp();
//        Thuonghieu();
    }

    public void loadtablespct() {
        dtm = (DefaultTableModel) tblspchitiet.getModel();
        dtm.setRowCount(0);
        for (SanPham_model i : sqlct.getlistspct()) {
            Object[] ob = {
                i.getSpct().getMaspct(),
                i.getMasp(), i.getTensp(), i.getThuonghieu(),
                i.getGia(), i.getSpct().getNgaynhap(),
                i.getSpct().getNhasx(), i.getChatlieu(), i.getCamera(), i.getChip(),
                i.getTrangthai() == 0 ? "Sản phẩm mới" : "Sản phẩm cũ",
                i.getSpct().getMausac(), i.getSpct().getLoairam(),
                i.getHdh(), i.getSpct().getSoluong(), i.getPin(),
                i.getKichthuoc(), i.getHinhanh(),};
            dtm.addRow(ob);
        }
    }

    public void loadlai() {
        loadtablespct();
    }

    public void loadtable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblsanpham.getModel();
        dtm.setRowCount(0);
        for (SanPham_model a : sql.getlist()) {
            Object[] ob = {
                a.getMasp(), a.getTensp(), a.getThuonghieu(),
                a.getGia(),
                a.getTrangthai() == 0 ? "Sản phẩm mới" : "Sản phẩm cũ",
                a.getSpct().getMausac(), a.getSpct().getLoairam(), a.getHinhanh()};
            dtm.addRow(ob);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel32 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbthuonghieu = new javax.swing.JComboBox<>();
        txtmasp = new javax.swing.JTextField();
        txttensp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();
        rdodangkd = new javax.swing.JRadioButton();
        rdongungkd = new javax.swing.JRadioButton();
        lblanh = new javax.swing.JLabel();
        cbbmau = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        cbbram = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbblocgia = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbblocram = new javax.swing.JComboBox<>();
        btnclearsp = new javax.swing.JButton();
        cbblocth = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtlocten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsanpham = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbbthuonghieuct = new javax.swing.JComboBox<>();
        txtmaspct = new javax.swing.JTextField();
        txttenspct = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbbramct = new javax.swing.JComboBox<>();
        txtgiact = new javax.swing.JTextField();
        rdocu = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtngaynhapct = new javax.swing.JTextField();
        txtcam = new javax.swing.JTextField();
        cbbchatlieuct = new javax.swing.JComboBox<>();
        txthangton = new javax.swing.JTextField();
        txtpinct = new javax.swing.JTextField();
        txtkhicthuocct = new javax.swing.JTextField();
        rdomoi = new javax.swing.JRadioButton();
        txtcpuct = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txthdh = new javax.swing.JTextField();
        lblanhct = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cbbnsx = new javax.swing.JComboBox<>();
        cbbmausacct = new javax.swing.JComboBox<>();
        txtmact = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblspchitiet = new javax.swing.JTable();
        btnclear = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnan = new javax.swing.JButton();
        btndsan = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbbttram = new javax.swing.JComboBox<>();
        cbbttnsx = new javax.swing.JComboBox<>();
        cbbttmau = new javax.swing.JComboBox<>();
        txtmatt = new javax.swing.JTextField();
        txtmattct = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtttsl = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbltt = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtttngay = new javax.swing.JTextField();

        jLabel32.setText("jLabel32");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Sản phẩm");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel5.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã sản phẩm :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên sản phẩm :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Thương hiệu :");

        cbbthuonghieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbthuonghieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xiaomi", "Realme", "Oppo", "Samsung", "Iphone", "Huawie", "Sony", "OnePlus", "Google" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Màu sắc :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Trạng thái : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Giá :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Bộ nhớ :");

        buttonGroup1.add(rdodangkd);
        rdodangkd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdodangkd.setText("Sản phẩm mới");

        buttonGroup1.add(rdongungkd);
        rdongungkd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdongungkd.setText("Sản phẩm cũ");

        lblanh.setText("              (Trống)");
        lblanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblanhMouseClicked(evt);
            }
        });

        cbbmau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbmau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đen", "Đỏ", "Xám", "Trắng", "Vàng", "Xanh", "Nâu", "Hồng", "Tím", " " }));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Bộ nhớ");

        cbbram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "64GB", "128GB", "256GB", "512GB", "1T" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbthuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttensp, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(txtgia)
                    .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdodangkd)
                    .addComponent(rdongungkd)
                    .addComponent(cbbmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbram, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbthuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdodangkd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdongungkd)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(cbbram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addComponent(jLabel8)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel9.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Thương hiệu :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Giá :");

        cbblocgia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbblocgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Dưới 2tr", "2-5triệu", "5-8 triệu", "Trên 8 triệu" }));
        cbblocgia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbblocgiaItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Bộ nhớ :");

        cbblocram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbblocram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "64GB", "128GB", "256GB", "512GB", "1T" }));
        cbblocram.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbblocramItemStateChanged(evt);
            }
        });

        btnclearsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclearsp.setText("Làm mới");
        btnclearsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearspActionPerformed(evt);
            }
        });

        cbblocth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbblocth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Xiaomi", "Realme", "Oppo", "Samsung", "Iphone", "Huawie", "Sony", "Vsmart", "Pixel", "OnePlus", "Google" }));
        cbblocth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbblocthItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbblocth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbblocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(cbblocram, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(btnclearsp)
                        .addGap(36, 36, 36))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbblocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbblocram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclearsp)
                    .addComponent(cbblocth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText(" Tên sản phẩm :");

        txtlocten.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtloctenCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(txtlocten, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtlocten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tblsanpham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Thương hiệu", "Giá", "Trạng thái", "Màu sắc", "Bộ nhớ", "Hình ảnh"
            }
        ));
        tblsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsanpham);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Danh mục sản phẩm :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(492, 492, 492)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết của sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel12.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Mã sản phẩm :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Tên sản phẩm :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Thương hiệu :");

        cbbthuonghieuct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbthuonghieuct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xiaomi", "Realme", "Oppo", "Samsung", "Iphone", "Huawie", "Sony", "Vsmart", "Pixel", "OnePlus", "Google" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Màu sắc :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Trạng thái : ");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Giá bán:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Bộ nhớ");

        cbbramct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbramct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "64GB", "128GB", "256GB", "512GB", "1T" }));

        buttonGroup1.add(rdocu);
        rdocu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdocu.setText("Sản phẩm cũ");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Ngày nhập :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Kích thước :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Camera :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Hệ điều hành");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Chất liệu :");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Hàng tồn kho :");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Chip xử lý :");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Dung lượng pin :");

        cbbchatlieuct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbchatlieuct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhựa", "Titan", "Silic", "Gốm", "Thủy tinh", "Kim loại" }));

        txthangton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthangtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdomoi);
        rdomoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdomoi.setText("Sản phẩm mới");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("inch");

        lblanhct.setText("                          Hình ảnh");
        lblanhct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblanhct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblanhctMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Nơi sx :");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Mã spct");

        cbbnsx.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbnsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việt Nam", "Trung Quốc", "Mỹ", "Ấn độ", "Hàn Quốc", "Indonesia", "Thái Lan" }));

        cbbmausacct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbmausacct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đen", "Đỏ", "Xám", "Trắng", "Vàng", "Xanh", "Nâu", "Hồng", "Tím", " " }));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Hình ảnh :");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel16)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbbthuonghieuct, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttenspct, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtgiact, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtngaynhapct, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcam, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbchatlieuct, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(txtcpuct, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmaspct, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(txtmact))))
                .addGap(47, 47, 47)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel26)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(rdomoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdocu))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbbramct, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txthdh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthangton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addComponent(txtpinct, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(txtkhicthuocct, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel33)))
                    .addComponent(cbbnsx, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbmausacct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(lblanhct, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(cbbmausacct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdomoi)
                                    .addComponent(rdocu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(txtmact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtmaspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txttenspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbthuonghieuct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel16))))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(cbbramct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txthdh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtgiact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19)))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txthangton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpinct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtngaynhapct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel28)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtkhicthuocct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbnsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbchatlieuct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25))
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(txtcpuct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(lblanhct, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblspchitiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblspchitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maspct", "Mã SP", "Tên SP", "Thương hiệu", "Giá", "Ngày nhập", "NSX", "Chất liệu", "Camera", "Chip", "Trạng thái", "Màu sắc", "Bộ nhớ", "Hệ điều hành", "Hàng tồn", "Pin", "Kích thước", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblspchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblspchitietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblspchitiet);
        if (tblspchitiet.getColumnModel().getColumnCount() > 0) {
            tblspchitiet.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblspchitiet.getColumnModel().getColumn(13).setPreferredWidth(110);
        }

        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/images.png"))); // NOI18N
        btnclear.setText("Làm mới");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5278663.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6711415.png"))); // NOI18N
        btnthem.setText("Thêm ");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tải xuống (1).png"))); // NOI18N
        btnan.setText("Ẩn sản phẩm");
        btnan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanActionPerformed(evt);
            }
        });

        btndsan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndsan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Trash.png"))); // NOI18N
        btndsan.setText("SP đã ẩn");
        btndsan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndsanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnsua)
                        .addGap(26, 26, 26)
                        .addComponent(btnthem)
                        .addGap(30, 30, 30)
                        .addComponent(btnclear)
                        .addGap(228, 228, 228)
                        .addComponent(btnan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndsan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsua)
                    .addComponent(btnthem)
                    .addComponent(btnclear)
                    .addComponent(btnan)
                    .addComponent(btndsan))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin chi tiết sản phẩm", jPanel4);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(204, 255, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Màu sắc : ");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("Bộ nhớ : ");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Nsx :  ");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Số lương :");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Mã sp :");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Ngày nhập :");

        cbbttram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "64GB", "128GB", "256GB", "512GB", "1T" }));

        cbbttnsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việt Nam", "Trung Quốc", "Mỹ", "Ấn độ", "Hàn Quốc", "Indonesia", "Thái Lan" }));

        cbbttmau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đen", "Đỏ", "Xám", "Trắng", "Vàng", "Xanh", "Nâu", "Hồng", "Tím" }));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setText("Mã spct :");

        txtttsl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tbltt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sp", "Mã spct", "Bộ nhớ", "Nsx", "Ngày nhập", "Số lượng"
            }
        ));
        tbltt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblttMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbltt);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6711415.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtttngay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel36))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel42))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbttnsx, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbttram, javax.swing.GroupLayout.Alignment.LEADING, 0, 91, Short.MAX_VALUE)
                                .addComponent(cbbttmau, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtttsl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtmattct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtmatt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtttngay, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtmatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmattct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbttmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbttram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbttnsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtttngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txtttsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thuộc tính", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(467, 467, 467)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblspchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblspchitietMouseClicked
        int index = this.tblspchitiet.getSelectedRow();
        if (index <= -1) {
            return;
        }
        SanPham_model spct = sqlct.getlistspct().get(index);
        if (spct.getTrangthai() == 0) {
            rdomoi.setSelected(true);
        } else {
            rdocu.setSelected(true);
        }
        txtmact.setText(tblspchitiet.getValueAt(index, 0).toString());
        txtmaspct.setText(tblspchitiet.getValueAt(index, 1).toString());
        txttenspct.setText(spct.getTensp());
        cbbthuonghieuct.setSelectedItem(spct.getThuonghieu());
        txtgiact.setText(String.valueOf(spct.getGia()));
        txtngaynhapct.setText(String.valueOf(spct.getSpct().getNgaynhap()));
        txtcam.setText(spct.getCamera());
        cbbchatlieuct.setSelectedItem(spct.getChatlieu());
        txtcpuct.setText(spct.getChip());
        cbbmausacct.setSelectedItem(spct.getSpct().getMausac());
        cbbramct.setSelectedItem(spct.getSpct().getLoairam());
        txthdh.setText(spct.getHdh());
        txthangton.setText(String.valueOf(spct.getSpct().getSoluong()));
        txtpinct.setText(spct.getPin());
        txtkhicthuocct.setText(spct.getKichthuoc());
        cbbnsx.setSelectedItem(spct.getSpct().getNhasx());
        String hinhanh = spct.getHinhanh();
        if (hinhanh == null || hinhanh.equals("Không có ảnh!")) {
            lblanhct.setText("Trống");
            lblanhct.setIcon(null);
        } else {
            URL imageUrl = getClass().getResource("/img/" + spct.getHinhanh());
            if (imageUrl != null) {
                try {
                    BufferedImage img = ImageIO.read(imageUrl);
                    if (img != null) {
                        lblanhct.setText("");
                        int width = lblanhct.getWidth();
                        int height = lblanhct.getHeight();
                        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImg);
                        lblanhct.setIcon(scaledIcon);
                    }
                } catch (IOException e) {
                    lblanhct.setText("");
                    e.printStackTrace();
                }
            } else {
            }
        }
    }//GEN-LAST:event_tblspchitietMouseClicked

    private void lblanhctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblanhctMouseClicked
        try {
            JFileChooser jfc = new JFileChooser("C:\\Users\\LE DINH LINH\\Downloads\\DuAn1DT-main\\DuAn1DT-main\\DuAn1DT-main\\QLDABanDienThoai-main\\GiaoDien\\src\\img");
            jfc.showOpenDialog(this);
            File f = jfc.getSelectedFile();
            if (f != null) {
                Image img = ImageIO.read(f);
                stranh = f.getName();
                lblanhct.setText("");
                int width = lblanhct.getWidth();
                int height = lblanhct.getHeight();
                lblanhct.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
                if (img != null) {
                } else {
                    System.out.println("Lỗi: Ảnh trống!");
                    return;
                }
            } else {
                System.out.println("Đóng ảnh");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblanhctMouseClicked

    private void txthangtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthangtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthangtonActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        clear();
        loadtablespct();
    }//GEN-LAST:event_btnclearActionPerformed
    private SanPham_model getinput() throws ParseException {
        String masp = txtmaspct.getText();
        String tensp = txttenspct.getText();
        String thuonghieu = cbbthuonghieuct.getSelectedItem().toString();
        float gia;
        try {
            String gianhap = txtgiact.getText();
            gia = Float.parseFloat(gianhap);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin");
            txtgiact.requestFocus();
            //e.printStackTrace();
            return null;
        }
        String ngaynhap = txtngaynhapct.getText();
        String cam = txtcam.getText();
        String chatlieu = cbbchatlieuct.getSelectedItem().toString();
        String chip = txtcpuct.getText();
        String mausac = cbbmausacct.getSelectedItem().toString();
        int trangthai = rdomoi.isSelected() ? 0 : 1;
        String loairam = cbbramct.getSelectedItem().toString();
        String hdh = txthdh.getText();
        String sl = txthangton.getText();
        int soluong = Integer.parseInt(sl);
        String kichthuoc = txtkhicthuocct.getText();
        String pin = txtpinct.getText();
        String nsx = cbbnsx.getSelectedItem().toString();
        String maspct = txtmact.getText();
        String anh = stranh;
        // check validate 
        if (masp.isEmpty() || tensp.isEmpty() || maspct.isEmpty() || cam.isEmpty() || chip.isEmpty() || hdh.isEmpty() || kichthuoc.isEmpty() || pin.isEmpty()
                || ngaynhap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin");
            return null;
        }
        if (anh == null || anh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn 1 ảnh");
            return null;
        }
        dateform.setLenient(false);
        try {
            if (ngaynhap.matches("\\d{4}-\\d{2}-\\d{2}")) {
                Date ngayNhap = dateform.parse(ngaynhap);
            } else {
                JOptionPane.showMessageDialog(this, "Ngày nhập sai định dạng");
                txtngaynhapct.requestFocus();
                return null;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày nhập sai ");
            txtngaynhapct.requestFocus();
            e.printStackTrace();
            return null;
        }
//        for (SanPham_model sp : sqlct.getlistspct()) {
//            if (sp.getMasp().equals(masp) && sp.getSpct().getMausac().equals(mausac)
//                    && sp.getSpct().getLoairam().equals(loairam)) {
//                JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại");
//                return null;
//            }
//        }
        SPChiTiet spct = new SPChiTiet(masp, loairam, mausac, maspct, nsx, ngaynhap, soluong);
        SanPham_model sp = new SanPham_model(masp, thuonghieu, tensp, chip, gia, trangthai, spct, cam, hdh, chatlieu, pin, anh, kichthuoc);
        return sp;

    }
    private void tblsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsanphamMouseClicked
        row = tblsanpham.rowAtPoint(evt.getPoint());
        int index = tblsanpham.getSelectedRow();
        if (index <= -1) {
            return;
        }
        SanPham_model sp = sql.getlist().get(index);
        if (sp.getTrangthai() == 0) {
            rdodangkd.setSelected(true);
        } else {
            rdongungkd.setSelected(true);
        }
        String hinhanh = sp.getHinhanh();
        if (hinhanh == null || hinhanh.equals("")) {
            lblanh.setText(null);
            lblanh.setIcon(null);
        } else {
            URL imageUrl = getClass().getResource("/img/" + sp.getHinhanh());
            if (imageUrl != null) {
                try {
                    BufferedImage img = ImageIO.read(imageUrl);
                    if (img != null) {
                        lblanh.setText("TRỐNG");
                        int width = lblanh.getWidth();
                        int height = lblanh.getHeight();
                        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImg);
                        lblanh.setIcon(scaledIcon);
                    }
                } catch (IOException e) {
                    lblanhct.setText("TRỐNG");
                    e.printStackTrace();
                }
            } else {
            }
        }
        cbbthuonghieu.setSelectedItem(sp.getThuonghieu());
        String loairamValue = sp.getSpct().getLoairam();
        String mausacValue = sp.getSpct().getMausac();
        System.out.println("loairamValue: " + loairamValue);
        System.out.println("mausacValue: " + mausacValue);
        cbbram.setSelectedItem(loairamValue);
        cbbmau.setSelectedItem(mausacValue);
        SanPham_model sppos = getSanphampostion(row);
        setmodel(sppos);
    }//GEN-LAST:event_tblsanphamMouseClicked

    private void btnclearspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearspActionPerformed
        clear();
        loadtable();
    }//GEN-LAST:event_btnclearspActionPerformed
    private void lblanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblanhMouseClicked
    }//GEN-LAST:event_lblanhMouseClicked
//    public void Anbymasp(String masp) {
//        dtm = (DefaultTableModel) tblspchitiet.getModel();
//        for (int row = 0; row < dtm.getRowCount(); row++) {
//            if (dtm.getValueAt(row, 1).equals(masp)) { // Ở đây giả sử cột masp ở cột thứ 1 (số thứ tự cột - 1)
//                dtm.removeRow(row);
//                //break; // Nếu masp là duy nhất, bạn có thể dừng vòng lặp ngay sau khi tìm thấy và ẩn dòng.
//            }
//        }
//    }

    public void actionPerformed(ActionEvent e) {
        int selectedRow = tblspchitiet.getSelectedRow();
        //int selectedRow = tblsanpham.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy giá trị ID của dòng đã chọn
            String ma = tblspchitiet.getValueAt(selectedRow, 1).toString();
            // Ẩn dòng đã chọn trong cơ sở dữ liệu
            sqlct.hideRowInDatabase(ma);
            // Xóa dòng đã chọn khỏi mô hình dữ liệu
            dtm.removeRow(selectedRow);
        }
    }
    private void btnanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanActionPerformed
        int index = tblspchitiet.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Hãy chòn 1 dòng");
            return;
        }
        int cf = JOptionPane.showConfirmDialog(this, "Bạn có muốn bỏ sản phẩm không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (cf == JOptionPane.YES_OPTION) {
            actionPerformed(evt);
            loadtable();
            loadtablespct();
        }
    }//GEN-LAST:event_btnanActionPerformed
    private DSDL_An an = null;
    private void btndsanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndsanActionPerformed
        if (an == null || !an.isVisible()) {
            // Create a new instance if it's null or disposed
            an = new DSDL_An();
            an.setAlwaysOnTop(true);
            an.setVisible(true);
        } else {
            an.dispose();
            loadtablespct();
        }

    }//GEN-LAST:event_btndsanActionPerformed

    private void txtloctenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtloctenCaretUpdate
        String ten = txtlocten.getText();
        String ma = txtlocten.getText();
        if (sql.serchtheoTen(ten, ma) != null) {
            DefaultTableModel dtm = (DefaultTableModel) this.tblsanpham.getModel();
            dtm.setRowCount(0);
            for (SanPham_model a : sql.serchtheoTen(ten, ma)) {
                Object[] ob = {
                    a.getMasp(), a.getTensp(), a.getThuonghieu(),
                    a.getGia(),
                    a.getTrangthai() == 0 ? "Sản phẩm mới" : "Sản phẩm cũ",
                    a.getSpct().getMausac(), a.getSpct().getLoairam(), a.getHinhanh()};
                dtm.addRow(ob);
            }
        } else {
            System.out.println("thất bại");
        }

    }//GEN-LAST:event_txtloctenCaretUpdate


    private void cbblocthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbblocthItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Xử lý khi một mục mới được chọn
            String selectedValue = (String) cbblocth.getSelectedItem();
            System.out.println("" + selectedValue);
            if (sql.serchtheoThuonghieu(selectedValue) != null) {
                DefaultTableModel dtm = (DefaultTableModel) this.tblsanpham.getModel();
                dtm.setRowCount(0);
                for (SanPham_model a : sql.serchtheoThuonghieu(selectedValue)) {
                    Object[] ob = {
                        a.getMasp(), a.getTensp(), a.getThuonghieu(),
                        a.getGia(),
                        a.getTrangthai() == 0 ? "Sản phẩm mới" : "Sản phẩm cũ",
                        a.getSpct().getMausac(), a.getSpct().getLoairam(), a.getHinhanh()};
                    dtm.addRow(ob);
                }
            } else {
                System.out.println("thất bại");
            }
            if (selectedValue.equals("Tất cả")) {
                loadtable();
            }
        }
    }//GEN-LAST:event_cbblocthItemStateChanged

    private void cbblocramItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbblocramItemStateChanged
        String selectedValue = (String) cbblocram.getSelectedItem();
        System.out.println("" + selectedValue);
        if (sql.serchtheoThuonghieu(selectedValue) != null) {
            DefaultTableModel dtm = (DefaultTableModel) this.tblsanpham.getModel();
            dtm.setRowCount(0);
            for (SanPham_model a : sql.serchtheoBonho(selectedValue)) {
                Object[] ob = {
                    a.getMasp(), a.getTensp(), a.getThuonghieu(),
                    a.getGia(),
                    a.getTrangthai() == 0 ? "Sản phẩm mới" : "Sản phẩm cũ",
                    a.getSpct().getMausac(), a.getSpct().getLoairam(), a.getHinhanh()};
                dtm.addRow(ob);
            }
        }
        if (selectedValue.equals("Tất cả")) {
            loadtable();
        }
    }//GEN-LAST:event_cbblocramItemStateChanged

    private void cbblocgiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbblocgiaItemStateChanged
        float giamin = 0;
        float giamax = 0;
        String selectedValue = cbblocgia.getSelectedItem().toString();
        if (selectedValue.equals("Dưới 2 triệu")) {
            giamin = 0;
            giamax = 2000;
        }
        if (selectedValue.equals("2-5 triệu")) {
            giamin = 2000;
            giamax = 5000;
        }
        if (selectedValue.equals("5-8 triệu")) {
            giamin = 5000;
            giamax = 8000;
        }
        if (selectedValue.equals("Trên 8 triệu")) {
            giamin = 8000;
            giamax = 1000000;
        }
        System.out.println("" + giamin + "--" + giamax);
        if (sql.serchtheoGia(giamin, giamax) != null) {
            DefaultTableModel dtm = (DefaultTableModel) this.tblsanpham.getModel();
            dtm.setRowCount(0);
            for (SanPham_model a : sql.serchtheoGia(giamin, giamax)) {
                Object[] ob = {
                    a.getMasp(), a.getTensp(), a.getThuonghieu(),
                    a.getGia(),
                    a.getTrangthai() == 0 ? "Sản phẩm mới" : "Sản phẩm cũ",
                    a.getSpct().getMausac(), a.getSpct().getLoairam(), a.getHinhanh()};
                dtm.addRow(ob);
            }
        }
        if (selectedValue.equals("Tất cả")) {
            loadtable();
        }
    }//GEN-LAST:event_cbblocgiaItemStateChanged

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed

    }//GEN-LAST:event_btnthoatActionPerformed

    private void tblthuoctinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthuoctinhMouseClicked

    }//GEN-LAST:event_tblthuoctinhMouseClicked

    private void btnthem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthem1ActionPerformed

    }//GEN-LAST:event_btnthem1ActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        SanPham_model sp = null;
        try {
            sp = this.getinput();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (sp != null) { // dữ liệu đầy đủ

            try {
                if (sqlct.Sua(sp) > 0) {// dữ liệu hợp lệ
                    this.clear();
                    loadtablespct();
                    loadtable();
                    JOptionPane.showMessageDialog(this, "Sủa thành công ");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa không thành công ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        SanPham_model sp = null;
        try {
            sp = this.getformspct();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (sp != null) { // dữ liệu đầy đủ
            try {
                if (sqlct.Them(sp) > 0) {// dữ liệu hợp lệ
                    this.clear();
                    loadtablespct();
                    loadtable();
                    JOptionPane.showMessageDialog(this, "Thêm thành công ");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm không thành công ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SPChiTiet sp = null;
        try {
            sp = this.getformtt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sp != null) { // dữ liệu đầy đủ
            try {
                if (sqlct.ThemSPCT(sp) > 0) {// dữ liệu hợp lệ
                    this.clear();
                    loadtablett();
                    JOptionPane.showMessageDialog(this, "Thêm thành công ");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm không thành công ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblttMouseClicked
        int row = this.tbltt.getSelectedRow();
        if (row <= -1) {
            return;
        }
        SanPham_model spct = sqlct.getlistspct().get(row);
        txtmatt.setText(tbltt.getValueAt(row, 1).toString());
        txtmattct.setText(tbltt.getValueAt(row, 0).toString());
        cbbttmau.setSelectedItem(spct.getSpct().getMausac());
        cbbttram.setSelectedItem(spct.getSpct().getLoairam());
        cbbttnsx.setSelectedItem(spct.getSpct().getNhasx());
    }//GEN-LAST:event_tblttMouseClicked
    private void loadtablett() {
        DefaultTableModel dtm = (DefaultTableModel) this.tbltt.getModel();
        dtm.setRowCount(0);
        for (SanPham_model i : sqlct.getlistspct()) {
            Object ob[] = {
                i.getSpct().getMaspct(), i.getMasp(),
                i.getSpct().getMausac(), i.getSpct().getLoairam(),
                i.getSpct().getNhasx(),};
            dtm.addRow(ob);
        }
    }

    public SPChiTiet getformtt() {
        String masp = txtmatt.getText();
        String maspct = txtmattct.getText();
        String mau = cbbttmau.getSelectedItem().toString();
        String ram = cbbttram.getSelectedItem().toString();
        String nsx = cbbttnsx.getSelectedItem().toString();
        String ngay = txtttngay.getText();
        int soluong;
        try {
            String sl = txtttsl.getText();
            soluong = Integer.parseInt(sl);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin");
            txtttsl.requestFocus();
            //e.printStackTrace();
            return null;
        }
        boolean maspctExists = false;
        if (masp.isEmpty() || maspct.isEmpty() || ngay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy kiểm tra lại thông tin");
            return null;
        }
        try {
            if (ngay.matches("\\d{4}-\\d{2}-\\d{2}")) {
                Date ngayNhap = dateform.parse(ngay);
            } else {
                JOptionPane.showMessageDialog(this, "Ngày nhập sai định dạng");
                return null;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày nhập sai ");
            e.printStackTrace();
            return null;
        }
        for (SanPham_model sp : sqlct.getlistspct()) {
            if (sp.getSpct().getMaspct().equals(maspct)) {
                JOptionPane.showMessageDialog(this, "Mã spct : " + maspct + " đã tồn tại");
                return null;
            }
        }
        for (SanPham_model sp : sqlct.getlistspct()) {
            if (sp.getMasp().equals(masp)) {
                maspctExists = true;
                break; // dưng nếu mã đó đã tồn tại
            }
        }
        if (maspctExists) {
        } else {
            JOptionPane.showMessageDialog(this, "Sản phẩm " + masp + " không tồn tại");
            System.out.println("Sản phẩm " + masp + " không tồn tại");
            return null;
        }
        for (SanPham_model sp : sqlct.getlistspct()) {
            if (sp.getMasp().equals(masp) && sp.getSpct().getMausac().equals(mau)
                    && sp.getSpct().getLoairam().equals(ram)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại");
                return null;
            }
        }
        SPChiTiet spct = new SPChiTiet(masp, ram, mau, maspct, nsx, ngay, soluong);
        return spct;
    }

    public void setmodel(SanPham_model sp) {
        txtmasp.setText(sp.getMasp());
        txttensp.setText(sp.getTensp());
        txtgia.setText(String.valueOf(sp.getGia()));
        cbbram.setSelectedItem(sp.getSpct().getLoairam());
    }

    public SanPham_model getSanphampostion(int pos) {
        SanPham_model sp = new SanPham_model();
        SPChiTiet spct = new SPChiTiet();
        sp.setMasp(tblsanpham.getValueAt(pos, 0).toString());
        sp.setTensp(tblsanpham.getValueAt(pos, 1).toString());
        sp.setGia(Float.parseFloat(tblsanpham.getValueAt(pos, 3).toString()));
        spct.setLoairam(tblsanpham.getValueAt(pos, 5).toString());
        spct.setMausac(tblsanpham.getValueAt(pos, 6).toString());
        sp.setSpct(spct);
        return sp;
    }

    private SanPham_model getformspct() throws ParseException {
        String masp = txtmaspct.getText();
        String tensp = txttenspct.getText();
        String thuonghieu = cbbthuonghieuct.getSelectedItem().toString();
        String gianhap = txtgiact.getText();
        float gia = 0;
        String cam = txtcam.getText();
        String chatlieu = cbbchatlieuct.getSelectedItem().toString();
        String chip = txtcpuct.getText();
        String mausac = cbbmausacct.getSelectedItem().toString();
        int trangthai = rdomoi.isSelected() ? 0 : 1;
        String loairam = cbbramct.getSelectedItem().toString();
        String hdh = txthdh.getText();
        String sl = txthangton.getText();
        int soluong = 0;
        String kichthuoc = txtkhicthuocct.getText();
        String pin = txtpinct.getText();
        String nsx = cbbnsx.getSelectedItem().toString();
        String maspct = txtmact.getText();
        String ngaynhap = txtngaynhapct.getText();
        String stanh = lblanhct.getText();
        // check validate        
        if (masp.isEmpty() || tensp.isEmpty() || maspct.isEmpty() || cam.isEmpty() || chip.isEmpty() || hdh.isEmpty() || kichthuoc.isEmpty() || pin.isEmpty()
                || ngaynhap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy kiểm tra lại thông tin");
            return null;
        }
        dateform.setLenient(false);
        try {
            if (ngaynhap.matches("\\d{4}-\\d{2}-\\d{2}")) {
                Date ngayNhap = dateform.parse(ngaynhap);
                System.out.println("Ngày nhập: " + ngaynhap);
            } else {
                JOptionPane.showMessageDialog(this, "Ngày nhập sai định dạng");
                System.out.println("Ngày nhập: " + ngaynhap);
                return null;
            }
        } catch (ParseException e) {
            System.out.println("Ngày nhập không đúng định dạng!");
            // e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ngày nhập sai định dạng");
            return null;
        }
        if (!gianhap.isEmpty()) {
            try {
                gia = Float.parseFloat(gianhap);
                soluong = Integer.parseInt(sl);
                // Continue processing with the parsed float value
            } catch (NumberFormatException e) {
                System.out.println("giá nhập: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Bạn nhập không đúng định dạng số");
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        for (SanPham_model sp : sqlct.getlistspct()) {
            if (sp.getSpct().getMaspct().equals(maspct)) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm CT : " + maspct + " đã tồn tại");
                return null;
            }
        }
        for (SanPham_model sp : sqlct.getlistspct()) {
            if (sp.getMasp().equals(masp)) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm : " + masp + " đã tồn tại");
                return null;
            }
        }
        for (SanPham_model sp : sqlct.getlistspct()) {
            if (sp.getTensp().equals(tensp) && sp.getSpct().getMausac().equals(mausac)
                    && sp.getSpct().getLoairam().equals(loairam)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại");
                return null;
            }
        }
        SPChiTiet spct = new SPChiTiet(masp, loairam, mausac, maspct, nsx, ngaynhap, soluong);
        SanPham_model sp = new SanPham_model(masp, thuonghieu, tensp, chip, gia, trangthai, spct, cam, hdh, chatlieu, pin, stranh, kichthuoc);
        return sp;
    }

    public void clear() {
        rdomoi.setSelected(true);
        txtmaspct.setText("");
        txttenspct.setText("");
        cbbthuonghieuct.setSelectedItem("");
        txtgiact.setText(String.valueOf(""));
        txtngaynhapct.setText(String.valueOf(""));
        txtcam.setText("");
        cbbchatlieuct.setSelectedIndex(0);
        txtcpuct.setText("");
        cbbmausacct.setSelectedIndex(0);
        cbbramct.setSelectedItem("");
        txthdh.setText("");
        txthangton.setText(String.valueOf(""));
        txtpinct.setText("");
        txtkhicthuocct.setText("");
        cbbnsx.setSelectedItem("");
        lblanhct.setText("");
        lblanhct.setIcon(null);
        stranh = null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnan;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnclearsp;
    private javax.swing.JButton btndsan;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbchatlieuct;
    private javax.swing.JComboBox<String> cbblocgia;
    private javax.swing.JComboBox<String> cbblocram;
    private javax.swing.JComboBox<String> cbblocth;
    private javax.swing.JComboBox<String> cbbmau;
    private javax.swing.JComboBox<String> cbbmausacct;
    private javax.swing.JComboBox<String> cbbnsx;
    private javax.swing.JComboBox<String> cbbram;
    private javax.swing.JComboBox<String> cbbramct;
    private javax.swing.JComboBox<String> cbbthuonghieu;
    private javax.swing.JComboBox<String> cbbthuonghieuct;
    private javax.swing.JComboBox<String> cbbttmau;
    private javax.swing.JComboBox<String> cbbttnsx;
    private javax.swing.JComboBox<String> cbbttram;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JLabel lblanhct;
    private javax.swing.JRadioButton rdocu;
    private javax.swing.JRadioButton rdodangkd;
    private javax.swing.JRadioButton rdomoi;
    private javax.swing.JRadioButton rdongungkd;
    private javax.swing.JTable tblsanpham;
    private javax.swing.JTable tblspchitiet;
    private javax.swing.JTable tbltt;
    private javax.swing.JTextField txtcam;
    private javax.swing.JTextField txtcpuct;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtgiact;
    private javax.swing.JTextField txthangton;
    private javax.swing.JTextField txthdh;
    private javax.swing.JTextField txtkhicthuocct;
    private javax.swing.JTextField txtlocten;
    private javax.swing.JTextField txtmact;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtmaspct;
    private javax.swing.JTextField txtmatt;
    private javax.swing.JTextField txtmattct;
    private javax.swing.JTextField txtngaynhapct;
    private javax.swing.JTextField txtpinct;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txttenspct;
    private javax.swing.JTextField txtttngay;
    private javax.swing.JTextField txtttsl;
    // End of variables declaration//GEN-END:variables

//    public void Mausacsp() {
//        String sql = "SELECT * FROM MAUSAC";
//        Connection cn = DBConnector.getConnection();
//        try {
//            PreparedStatement stm = cn.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            DefaultComboBoxModel cbbmodel = (DefaultComboBoxModel) cbbmausacct.getModel();
//            DefaultComboBoxModel cbbmodelsp = (DefaultComboBoxModel) cbbmau.getModel();
//            cbbmodel.removeAllElements();
//            cbbmodelsp.removeAllElements();
//            // lấy ds màu sắc    
//            while (rs.next()) {
//                String mamau = rs.getString("MAMAU");
//                String tenmau = rs.getString("TENMAU");
//                Mycombobox mycbb = new Mycombobox(mamau, tenmau);
//                // thêm dữ liệu màu vào cbbmausac
//                cbbmodel.addElement(mycbb);
//                cbbmodelsp.addElement(mycbb);
//            }
//        } catch (Exception e) {
//        }
//    }
//
//    public void Ramcsp() {
//        String sql = "SELECT * FROM RAM";
//        Connection cn = DBConnector.getConnection();
//        try {
//            PreparedStatement stm = cn.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            DefaultComboBoxModel cbbmodel = (DefaultComboBoxModel) cbbramct.getModel();
//            DefaultComboBoxModel cbbmodelloc = (DefaultComboBoxModel) cbblocram.getModel();
//            DefaultComboBoxModel cbbmodelram = (DefaultComboBoxModel) cbbram.getModel();
//            cbbmodel.removeAllElements();
//
////            String all = "Tất cả"; 
////            cbbmodelloc.addElement(all);           
//            // lấy ds RAM    
//            while (rs.next()) {
//                String mamau = rs.getString("MARAM");
//                String tenmau = rs.getString("LOAIRAM");
//                Mycombobox mycbb = new Mycombobox(mamau, tenmau);
//                // thêm dữ liệu RAM vào cbbRAM
//                cbbmodel.addElement(mycbb);
//                cbbmodelloc.addElement(mycbb);
//                cbbmodelram.addElement(mycbb);
//            }
//        } catch (Exception e) {
//        }
//    }
//    public void Noisxcsp() {
//        String sql = "SELECT * FROM NOISANXUAT";
//        Connection cn = DBConnector.getConnection();
//        try {
//            PreparedStatement stm = cn.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            DefaultComboBoxModel cbbmodel = (DefaultComboBoxModel) cbbnsx.getModel();
//            cbbmodel.removeAllElements();
//            // lấy ds NƠI SẢN XUẤT   
//            while (rs.next()) {
//                String mamau = rs.getString("MANSX");
//                String tenmau = rs.getString("NOISANXUAT");
//                Mycombobox mycbb = new Mycombobox(mamau, tenmau);
//                // thêm dữ liệu NƠI SẢN XUẤT vào cbbNSX
//                cbbmodel.addElement(mycbb);
//            }
//        } catch (Exception e) {
//        }
//    }
//    public void Thuonghieu() {
//        DefaultComboBoxModel cbbmodel = (DefaultComboBoxModel) cbbthuonghieu.getModel();
//        DefaultComboBoxModel cbbmodelct = (DefaultComboBoxModel) cbbthuonghieuct.getModel();
//        DefaultComboBoxModel cbbmodelloc = (DefaultComboBoxModel) cbblocth.getModel();
////        add(cbbthuonghieu);
////        add(cbbthuonghieuct);
////        add(cbblocth);
//        cbbmodel.removeAllElements();
//        String sql = "SELECT THUONGHIEU FROM SANPHAM";
//        Connection cn = DBConnector.getConnection();
//        try {
//            PreparedStatement stm = cn.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                String thghieu = rs.getString("THUONGHIEU");
//                cbbmodel.addElement(thghieu);
//                cbbmodelct.addElement(thghieu);
//                cbbmodelloc.addElement(thghieu);
//            }
//        } catch (Exception e) {
//        }
//    }
}
