/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Model.NhanVienModel;
import Sevice.NhanVienService;
import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.Image;
import static java.awt.image.ImageObserver.HEIGHT;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.swing.SwingUtilities;
import javax.xml.transform.Result;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhanVien extends javax.swing.JPanel {

    // Component parentComponent = SwingUtilities.getWindowAncestor(this);
    NhanVienService nvs = new NhanVienService();
    String strFind = "";
    String findByName = "";
    String findByRole = "";
    String duongdananh = "C:\\Users\\ADMIN\\Downloads\\DuAn1-main (1)\\DuAn1-main\\GiaoDien\\src\\img\\1.jpg";
    ImageIcon iconmessage = new ImageIcon("C:/Users/ADMIN/Downloads/DuAn1-main (1)/DuAn1-main/GiaoDien/src/Icon/Comments.png");
    ImageIcon icon_message_error = new ImageIcon("C:/Users/ADMIN/Downloads/DuAn1-main (1)/DuAn1-main/GiaoDien/src/Icon/Warning.png");

    public NhanVien() {
        init();
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtcmnd = new javax.swing.JTextField();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        txtemail = new javax.swing.JTextField();
        cbovaitro = new javax.swing.JComboBox<>();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        anh = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtluong = new javax.swing.JTextField();
        txtngaysinh = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtloctheoma = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cboloctheochucvu = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtthamnien = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txttimkiemtheoten = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        btnxuatfile = new javax.swing.JButton();
        btnchonanh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txthinhanh = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Clien list.png"))); // NOI18N
        jLabel1.setText("Thông tin nhân viên");

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("Họ và tên");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setText("Địa chỉ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel9.setText("SĐT");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel10.setText("CMND");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel11.setText("Vai trò");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel12.setText("Giới Tính");

        txtmanv.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txthoten.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtdiachi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtsdt.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtcmnd.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        buttonGroup1.add(rdonam);
        rdonam.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rdonam.setSelected(true);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rdonu.setText("Nữ");

        txtemail.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        cbovaitro.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbovaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân Viên" }));

        btnthem.setBackground(new java.awt.Color(255, 153, 51));
        btnthem.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(102, 255, 153));
        btnsua.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(255, 0, 51));
        btnxoa.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnlammoi.setBackground(new java.awt.Color(204, 204, 255));
        btnlammoi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        btnlammoi.setText("Làm mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.jpg"))); // NOI18N
        anh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Ảnh nhân viên");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Lương");

        txtluong.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtngaysinh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/User.png"))); // NOI18N
        jLabel16.setText("Lọc nhân viên theo mã:");

        txtloctheoma.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtloctheoma.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtloctheomaCaretUpdate(evt);
            }
        });
        txtloctheoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloctheomaActionPerformed(evt);
            }
        });
        txtloctheoma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtloctheomaKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/User group.png"))); // NOI18N
        jLabel17.setText("Lọc theo chức vụ:");

        cboloctheochucvu.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        cboloctheochucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên" }));
        cboloctheochucvu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboloctheochucvuItemStateChanged(evt);
            }
        });
        cboloctheochucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboloctheochucvuActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Red star.png"))); // NOI18N
        jLabel18.setText("Thâm Niên");

        txtthamnien.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        tblNhanVien.setAutoCreateRowSorter(true);
        tblNhanVien.setBackground(new java.awt.Color(204, 204, 255));
        tblNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ Và Tên", "Ngày Sinh", "Địa Chỉ", "SĐT", "CMND", "Vai Trò", "Giới Tính", "Email", "Thâm Niên", "LươngCB", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(63, 63, 63))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Notes.png"))); // NOI18N
        jLabel19.setText("Tìm kiếm tên nhân viên:");

        txttimkiemtheoten.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txttimkiemtheoten.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimkiemtheotenCaretUpdate(evt);
            }
        });
        txttimkiemtheoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemtheotenActionPerformed(evt);
            }
        });

        btntimkiem.setBackground(new java.awt.Color(153, 204, 255));
        btntimkiem.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        btnxuatfile.setBackground(new java.awt.Color(153, 204, 255));
        btnxuatfile.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnxuatfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Print.png"))); // NOI18N
        btnxuatfile.setText("In File");
        btnxuatfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatfileActionPerformed(evt);
            }
        });

        btnchonanh.setBackground(new java.awt.Color(153, 204, 255));
        btnchonanh.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnchonanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Open file.png"))); // NOI18N
        btnchonanh.setText("Chọn ảnh");
        btnchonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtloctheoma, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttimkiemtheoten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtthamnien)
                    .addComponent(cboloctheochucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnxuatfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchonanh, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(132, 132, 132))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel19});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtloctheoma, txtthamnien, txttimkiemtheoten});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtloctheoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttimkiemtheoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel18)
                                .addComponent(txtthamnien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cboloctheochucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnchonanh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnxuatfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        jLabel15.setText("Lọc thông tin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txthoten)
                            .addComponent(txtmanv)
                            .addComponent(txtemail)
                            .addComponent(txtngaysinh)
                            .addComponent(txtdiachi)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnthem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(btnsua)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(3, 3, 3)
                                        .addComponent(rdonam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdonu, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(15, 15, 15)
                                            .addComponent(cbovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(7, 7, 7)
                                            .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(192, 192, 192)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnxoa)
                                .addGap(28, 28, 28)
                                .addComponent(btnlammoi)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtcmnd, txtdiachi, txtemail, txthoten, txtluong, txtmanv, txtngaysinh, txtsdt});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnsua, btnthem, btnxoa});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(cbovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(rdonam)
                            .addComponent(rdonu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem)
                            .addComponent(btnsua)
                            .addComponent(btnxoa)
                            .addComponent(btnlammoi))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtcmnd, txtdiachi, txtemail, txthoten, txtluong, txtmanv, txtngaysinh, txtsdt});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1806, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );

        jLabel13.setText("jLabel13");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Hình Ảnh:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(txthinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1094, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        Component parentComponent = SwingUtilities.getWindowAncestor(this);
        NhanVienModel nv = getFrom1();
        if (nv == null) {
            return;
        }
        if (nv != null) {
            nvs.add(nv);
            loadTable();
            JOptionPane.showMessageDialog(parentComponent, "Thêm dữ liệu thành công !", "Thông Báo", HEIGHT, iconmessage);
        } else {
            JOptionPane.showMessageDialog(parentComponent, "Thêm dữ liệu thất bại !", "Thông Báo", HEIGHT, icon_message_error);

        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        Component parentComponent = SwingUtilities.getWindowAncestor(this);
        int row = tblNhanVien.getSelectedRow();
        NhanVienModel nv = getFrom();
        if (nv == null) {
            return;
        }
        nvs.update(nv);
        loadTable();
        JOptionPane.showMessageDialog(parentComponent, "Sửa thành công !", "Thông Báo", HEIGHT, iconmessage);
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        Component parentComponent = SwingUtilities.getWindowAncestor(this);
        int row = tblNhanVien.getSelectedRow();
        NhanVienModel nv = getFrom();
        if (nv == null) {
            return;
        }
        nvs.remove(nv);
        loadTable();
        JOptionPane.showMessageDialog(parentComponent, "Xóa thành công !", "Thông Báo", HEIGHT, iconmessage);
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        // TODO add your handling code here:
        txtmanv.setText("");
        txthoten.setText("");
        txtngaysinh.setText("");
        txtdiachi.setText("");
        txtsdt.setText("");
        txtcmnd.setText("");
        cbovaitro.setSelectedIndex(0);
        rdonam.setSelected(true);
        txtluong.setText("");
        txthinhanh.setText("");
        txtthamnien.setText("");
        txtloctheoma.setText("");
        txttimkiemtheoten.setText("");
        txtemail.setText("");
        cboloctheochucvu.setSelectedIndex(0);
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnchonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonanhActionPerformed
        try {
            JFileChooser f = new JFileChooser("C:\\Users\\ADMIN\\Downloads\\DuAn1-main (1)\\DuAn1-main\\GiaoDien\\src\\img");
            f.setDialogTitle("Mở File");
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            f.showOpenDialog(parentComponent);
            File ftenanh = f.getSelectedFile();
            duongdananh = ftenanh.getAbsolutePath();
            if (duongdananh != null) {
                anh.setIcon(ResizeImage(String.valueOf(duongdananh)));
                System.out.println(duongdananh);
                JOptionPane.showMessageDialog(parentComponent, "Chọn ảnh thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE, iconmessage);
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Bạn chưa chọn ảnh nào !", "Thông Báo", HEIGHT, icon_message_error);
            }

        } catch (Exception e) {
            System.out.println("Chưa chọn ảnh !");
            System.out.println(duongdananh);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnchonanhActionPerformed

    private void txtloctheomaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtloctheomaCaretUpdate
        strFind = txtloctheoma.getText();
        nvs.serchtheoId(strFind);
        loadTableById(strFind);
    }//GEN-LAST:event_txtloctheomaCaretUpdate

    private void txtloctheomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloctheomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloctheomaActionPerformed

    private void txtloctheomaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtloctheomaKeyReleased

    }//GEN-LAST:event_txtloctheomaKeyReleased

    private void cboloctheochucvuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboloctheochucvuItemStateChanged

        findByRole = cboloctheochucvu.getSelectedItem().toString();
        nvs.serchTheoChucVu(findByRole);
        loadTableByRole(findByRole);
        System.out.println("" + nvs.serchTheoChucVu(findByRole));
    }//GEN-LAST:event_cboloctheochucvuItemStateChanged

    private void cboloctheochucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboloctheochucvuActionPerformed

    }//GEN-LAST:event_cboloctheochucvuActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int row = tblNhanVien.getSelectedRow();
        txtmanv.setText((String) tblNhanVien.getValueAt(row, 0));
        txthoten.setText((String) tblNhanVien.getValueAt(row, 1));
        txtngaysinh.setText((String) tblNhanVien.getValueAt(row, 2).toString());
        txtdiachi.setText((String) tblNhanVien.getValueAt(row, 3).toString());
        txtemail.setText((String) tblNhanVien.getValueAt(row, 8).toString());
        txtsdt.setText((String) tblNhanVien.getValueAt(row, 4).toString());
        txtcmnd.setText((String) tblNhanVien.getValueAt(row, 5).toString());
        cbovaitro.setSelectedItem(tblNhanVien.getValueAt(row, 6).toString());
        String gioitinh = (String) tblNhanVien.getValueAt(row, 7).toString();
        if (gioitinh.equalsIgnoreCase("NAM")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        txtthamnien.setText((String) tblNhanVien.getValueAt(row, 9).toString());
        float luong = (int) tblNhanVien.getValueAt(row, 10);
        txtluong.setText("" + luong);
        int col = tblNhanVien.getSelectedColumn();
        txthinhanh.setText((String) tblNhanVien.getValueAt(row, 11));
        ImageIcon icon1 = new ImageIcon("C://java_3_Projects//duan1//src//poly//img" + "//" + tblNhanVien.getValueAt(row, 11));
        anh.setIcon(icon1);

        // Kiểm tra xem ô được chọn có phải là ô chứa giá trị int không
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnxuatfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatfileActionPerformed
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("danhsachnhanvien");// tạo tên sheet
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2); // tạo trống 2 hàng

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH NHAN VIEN"); // tạo tiêu đề danh sách nhân viên
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING); // tạo tên cho từng đối tượng
            cell.setCellValue("MANV");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("HOVATEN");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("NGAYSINH");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("DIACHI");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("SĐT");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("CCCD");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("VAITRO");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("GIOITINH");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("EMAIL");
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("THAMNIEN");
            cell = row.createCell(10, CellType.NUMERIC);
            cell.setCellValue("LUONGCB");
            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("HINH");
            for (int i = 0; i < nvs.getAll().size(); i++) { // dùng vòng lập for để duyệt tất cả các đối tượng
                //Modelbook book =arr.get(i);
                row = sheet.createRow(4 + i); // sẽ duyệt dữ liệu từ dòng t 4 trở đi

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getMANV());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getTENNV());

                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(nvs.getAll().get(i).getNGAYSINH());
                // Tạo đối tượng CellStyle để định dạng ngày tháng
                CreationHelper createHelper = wordkbook.getCreationHelper();
                CellStyle dateCellStyle = wordkbook.createCellStyle();
                dateCellStyle.setDataFormat(
                        createHelper.createDataFormat().getFormat("yyyy/mm/dd")); // Định dạng ngày tháng là dd/MM/yyyy

                // Áp dụng định dạng ngày tháng cho ô NGAYSINH
                cell.setCellStyle(dateCellStyle);

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getDIACHI());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getSDT());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getCCCD());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getCHUCVU());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getGIOITINH());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getEMAIL());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getTRANGTHAI());

                cell = row.createCell(10, CellType.NUMERIC);
                cell.setCellValue(nvs.getAll().get(i).getLuong());

                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(nvs.getAll().get(i).getHINHANH());

            }
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            File f = new File("H://danhsachnhanvien.xlsx"); // tạo đường dẫn lưa file
            try {
                FileOutputStream fis = new FileOutputStream(f); // dùng fos để đọc file
                wordkbook.write(fis);
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(parentComponent, "In file thành công !", "Thông Báo", HEIGHT, iconmessage);;

        } catch (Exception e) {
            Component parentComponent = SwingUtilities.getWindowAncestor(this);
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Đã xảy ra lỗi khi xuất file !", "Thông Báo", HEIGHT, icon_message_error);
        }
    }//GEN-LAST:event_btnxuatfileActionPerformed

    private void txttimkiemtheotenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimkiemtheotenCaretUpdate

        findByName = txttimkiemtheoten.getText();
        nvs.serchtheoTen(findByName);
        loadTableByName(findByName);
    }//GEN-LAST:event_txttimkiemtheotenCaretUpdate

    private void txttimkiemtheotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemtheotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemtheotenActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        findByName = txttimkiemtheoten.getText();
        nvs.serchtheoTen(findByName);
        loadTableByName(findByName);
    }//GEN-LAST:event_btntimkiemActionPerformed

    public void loadTable() {
        DefaultTableModel tbModel = (DefaultTableModel) tblNhanVien.getModel();
        tbModel.setRowCount(0);
        for (NhanVienModel nhanVien : nvs.getAll()) {
            Object[] rowData = {
                nhanVien.getMANV(),
                nhanVien.getTENNV(),
                nhanVien.getNGAYSINH(),
                nhanVien.getDIACHI(),
                nhanVien.getSDT(),
                nhanVien.getCCCD(),
                nhanVien.getCHUCVU(),
                nhanVien.getGIOITINH(),
                nhanVien.getEMAIL(),
                nhanVien.getTRANGTHAI(),
                nhanVien.getLuong(),
                nhanVien.getHINHANH()

            };
            tbModel.addRow(rowData);
        }
    }

    public void loadTableByName(String name) {
        DefaultTableModel tbModel = (DefaultTableModel) tblNhanVien.getModel();
        tbModel.setRowCount(0);
        for (NhanVienModel nhanVien : nvs.serchtheoTen(name)) {
            Object[] rowData = {
                nhanVien.getMANV(),
                nhanVien.getTENNV(),
                nhanVien.getNGAYSINH(),
                nhanVien.getDIACHI(),
                nhanVien.getSDT(),
                nhanVien.getCCCD(),
                nhanVien.getCHUCVU(),
                nhanVien.getGIOITINH(),
                nhanVien.getEMAIL(),
                nhanVien.getTRANGTHAI(),
                nhanVien.getLuong(),
                nhanVien.getHINHANH()

            };
            tbModel.addRow(rowData);
        }

    }

    private Icon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(anh.getWidth(), anh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public NhanVienModel getFrom() {
        Component parentComponent = SwingUtilities.getWindowAncestor(this);
        NhanVienModel nv = new NhanVienModel();

        // Kiểm tra rỗng cho các trường quan trọng
        if (isEmpty(txtmanv.getText()) || isEmpty(txthoten.getText()) || isEmpty(txtngaysinh.getText())
                || isEmpty(txtdiachi.getText()) || isEmpty(txtemail.getText()) || isEmpty(txtsdt.getText())
                || isEmpty(txtcmnd.getText()) || cbovaitro.getSelectedItem() == null || isEmpty(txtluong.getText())) {
            JOptionPane.showMessageDialog(parentComponent, "Không được để trống dữ liệu !", "Thông Báo", HEIGHT, icon_message_error);
            return null;
        }

        // Kiểm tra định dạng email
        if (!isValidEmail(txtemail.getText())) {
            JOptionPane.showMessageDialog(parentComponent, "Định dạng email phải có 1 ký tự viết hoa, thường,@ !", "Thông Báo", HEIGHT, icon_message_error);
            return null;
        }

        nv.setMANV(txtmanv.getText());
        nv.setTENNV(txthoten.getText());

        try {
            String ngaySinhString = txtngaysinh.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaySinhDate = sdf.parse(ngaySinhString);
            java.sql.Date sqlNgaySinhDate = new java.sql.Date(ngaySinhDate.getTime());
            nv.setNGAYSINH(sqlNgaySinhDate);
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý khi có lỗi chuyển đổi ngày tháng
            return null;
        }

        nv.setDIACHI(txtdiachi.getText());
        nv.setEMAIL(txtemail.getText().toLowerCase()); // Chuyển đổi tất cả về chữ thường
        nv.setSDT(txtsdt.getText());
        nv.setCCCD(txtcmnd.getText());
        nv.setCHUCVU((String) cbovaitro.getSelectedItem());
        nv.setLuong((int) Float.parseFloat(txtluong.getText()));

        String gioitinh = rdonam.isSelected() ? "Nam" : "Nữ";
        nv.setGIOITINH(gioitinh);
        nv.setTRANGTHAI(txtthamnien.getText());
        nv.setHINHANH(txthinhanh.getText());
        //nv.setLocNhanVienTheoMa(lblloctheoma.getText());
        return nv;
    }

    public NhanVienModel getFrom1() {
        Component parentComponent = SwingUtilities.getWindowAncestor(this);
        NhanVienModel nv = new NhanVienModel();
        String ma = "";
        try {
            ma = String.valueOf(txtmanv.getText());
            if (nvs.isMaNVExists(ma)) {
                JOptionPane.showMessageDialog(parentComponent, "Mã nhân viên đã tồn tại, vui lòng nhập mã khác !", "Thông Báo", HEIGHT, icon_message_error);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Kiểm tra rỗng cho các trường quan trọng
        if (ma.isEmpty() || isEmpty(txthoten.getText()) || isEmpty(txtngaysinh.getText())
                || isEmpty(txtdiachi.getText()) || isEmpty(txtemail.getText()) || isEmpty(txtsdt.getText())
                || isEmpty(txtcmnd.getText()) || cbovaitro.getSelectedItem() == null || isEmpty(txtluong.getText())) {
            JOptionPane.showMessageDialog(parentComponent, "Không được để trống dữ liệu !", "Thông Báo", HEIGHT, icon_message_error);
            return null;
        }

        // Kiểm tra định dạng email
        if (!isValidEmail(txtemail.getText())) {
            JOptionPane.showMessageDialog(parentComponent, "Định dạng email phải có 1 ký tự viết hoa, thường,@ !", "Thông Báo", HEIGHT, icon_message_error);
            return null;
        }

        nv.setMANV(txtmanv.getText());
        nv.setTENNV(txthoten.getText());

        try {
            String ngaySinhString = txtngaysinh.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaySinhDate = sdf.parse(ngaySinhString);
            java.sql.Date sqlNgaySinhDate = new java.sql.Date(ngaySinhDate.getTime());
            nv.setNGAYSINH(sqlNgaySinhDate);
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý khi có lỗi chuyển đổi ngày tháng
            return null;
        }

        nv.setDIACHI(txtdiachi.getText());
        nv.setEMAIL(txtemail.getText().toLowerCase()); // Chuyển đổi tất cả về chữ thường
        nv.setSDT(txtsdt.getText());
        nv.setCCCD(txtcmnd.getText());
        nv.setCHUCVU((String) cbovaitro.getSelectedItem());
        nv.setLuong((int) Float.parseFloat(txtluong.getText()));
        try {
            int luong = Integer.parseInt(txtluong.getText());
            if (luong < 0) {
                JOptionPane.showMessageDialog(parentComponent, "Vui lòng nhập lươn lớn hơn 0 !", "Thông Báo", HEIGHT, icon_message_error);
                return null;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Vui lòng nhập số thay vì ký tự !", "Thông Báo", HEIGHT, icon_message_error);
            return null;
        }
        String gioitinh = rdonam.isSelected() ? "Nam" : "Nữ";
        nv.setGIOITINH(gioitinh);
        nv.setTRANGTHAI(txtthamnien.getText());
        nv.setHINHANH(txthinhanh.getText());
        //nv.setLocNhanVienTheoMa(lblloctheoma.getText());
        return nv;
    }

    public NhanVienModel getThongTin() {
        NhanVienModel nv = new NhanVienModel();
        nv.setLocNhanVienTheoMa(txtloctheoma.getText());
        nv.setLocNhanVienTheoTen(txtloctheoma.getText().toString());
        return nv;
    }

    ;
    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

// Hàm kiểm tra định dạng email
    private boolean isValidEmail(String email) {
        // Sử dụng regex để kiểm tra định dạng email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    private void display(int index) {
        NhanVienModel nv = nvs.getAll().get(index);
        txtmanv.setText(String.valueOf(nv.getMANV().toString()));
        txthoten.setText(nv.getTENNV().toString());
        txtngaysinh.setText(nv.getNGAYSINH().toString());
        txtdiachi.setText(nv.getDIACHI().toString());
        txtemail.setText(nv.getEMAIL().toString());
        txtsdt.setText(nv.getSDT().toString());
        txtcmnd.setText(nv.getCCCD().toString());
        cbovaitro.setSelectedItem(nv.getCHUCVU().toString());
        String gioiTinh = nv.getGIOITINH().toString();
        if (gioiTinh.equalsIgnoreCase("Nam")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        txtluong.setText(String.valueOf(nv.getLuong()));
        txthinhanh.setText(nv.getHINHANH().toString());
        txtthamnien.setText(nv.getTRANGTHAI().toString());

    }

    public void loadTableById(String id) {
        DefaultTableModel tbModel = (DefaultTableModel) tblNhanVien.getModel();
        tbModel.setRowCount(0);
        for (NhanVienModel nhanVien : nvs.serchtheoId(id)) {
            Object[] rowData = {
                nhanVien.getMANV(),
                nhanVien.getTENNV(),
                nhanVien.getNGAYSINH(),
                nhanVien.getDIACHI(),
                nhanVien.getSDT(),
                nhanVien.getCCCD(),
                nhanVien.getCHUCVU(),
                nhanVien.getGIOITINH(),
                nhanVien.getEMAIL(),
                nhanVien.getTRANGTHAI(),
                nhanVien.getLuong(),
                nhanVien.getHINHANH()

            };
            tbModel.addRow(rowData);
        }
    }

    public void loadTableByRole(String role) {
        DefaultTableModel tbModel = (DefaultTableModel) tblNhanVien.getModel();
        tbModel.setRowCount(0);
        for (NhanVienModel nhanVien : nvs.serchTheoChucVu(role)) {
            Object[] rowData = {
                nhanVien.getMANV(),
                nhanVien.getTENNV(),
                nhanVien.getNGAYSINH(),
                nhanVien.getDIACHI(),
                nhanVien.getSDT(),
                nhanVien.getCCCD(),
                nhanVien.getCHUCVU(),
                nhanVien.getGIOITINH(),
                nhanVien.getEMAIL(),
                nhanVien.getTRANGTHAI(),
                nhanVien.getLuong(),
                nhanVien.getHINHANH()

            };
            tbModel.addRow(rowData);
        }
    }

    public void importDataFromExcel(File file) {
        Component parentComponent = SwingUtilities.getWindowAncestor(this);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(4);

            DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong table trước khi thêm dữ liệu mới

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Bỏ qua dòng tiêu đề
                if (row.getRowNum() == 0) {
                    continue;
                }

                Object[] rowData = new Object[sheet.getRow(0).getLastCellNum()];
                int cellIndex = 0;

                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case STRING:
                            rowData[cellIndex++] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                rowData[cellIndex++] = cell.getDateCellValue();
                            } else {
                                rowData[cellIndex++] = cell.getNumericCellValue();
                            }
                            break;
                        // Các trường hợp khác có thể thêm tùy vào kiểu dữ liệu cụ thể
                        default:
                            rowData[cellIndex++] = "";
                    }
                }

                model.addRow(rowData);
            }

            fileInputStream.close();
            JOptionPane.showMessageDialog(parentComponent, "Import data from Excel successful!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Error importing data from Excel!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anh;
    private javax.swing.JButton btnchonanh;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxuatfile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboloctheochucvu;
    private javax.swing.JComboBox<String> cbovaitro;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtcmnd;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthinhanh;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtloctheoma;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtthamnien;
    private javax.swing.JTextField txttimkiemtheoten;
    // End of variables declaration//GEN-END:variables

    private void init() {
        initComponents();
        loadTable();
        display(0);
    }
}
