/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Model.HoaDonCT;
import Model.KhachHang;
import model.SanPham_model;
import Sevice.KhachHangSevice;
import java.awt.Component;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hieu9
 */
public class KháchHang extends javax.swing.JPanel {

    SimpleDateFormat Date = new SimpleDateFormat("dd/MM/yyyy");
    private final KhachHangSevice khsevice = new KhachHangSevice();
    DefaultTableModel model = new DefaultTableModel();
    int idex;

    public KháchHang() {
        initComponents();
        model = (DefaultTableModel) tblbang.getModel();
        loadtable();

    }

    private void loadtable() {
        ArrayList<KhachHang> khlist = khsevice.GetAll();
        model.setRowCount(0);

        for (KhachHang kh : khlist) {
            model.addRow(new Object[]{kh.getId(), kh.getMaKH(), kh.getTenKH(), kh.getNgaySinh(), kh.getGioiTinh(), kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isTrangThai() ? "Mới" : "Lâu Năm"});
        }
    }

    private void hienthi() {

        txtMa.setText(tblbang.getValueAt(idex, 1).toString());
        txtTen.setText(tblbang.getValueAt(idex, 2).toString());
        try {
            String ngaySinhString = tblbang.getValueAt(idex, 3).toString();
            Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhString);
            txtngaysinh.setDate(ngaySinh);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        txtsdt.setText(tblbang.getValueAt(idex, 5).toString());
        txtemai.setText(tblbang.getValueAt(idex, 6).toString());
        tardiachi.setText(tblbang.getValueAt(idex, 7).toString());
        cbbtrangthai.setSelectedItem(tblbang.getValueAt(idex, 8).toString());
        String GioiTinh = tblbang.getValueAt(idex, 4).toString();
        if (GioiTinh.equals("Nam")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }

    }

    public void loadtablespct() {
        DefaultTableModel modelGiaoDich = (DefaultTableModel) this.tblbanggiaodich.getModel();
        modelGiaoDich.setRowCount(0); // Xóa tất cả dữ liệu cũ

        int row = tblbang.getSelectedRow();
        if (row != -1) { // Kiểm tra xem có dòng nào được chọn không
            KhachHang kh = khsevice.joinTables().get(row);

            // Thêm dữ liệu của dòng được chọn vào tblbanggiaodich
            modelGiaoDich.addRow(new Object[]{
                kh.getId(),
                kh.getTenKH(),
                kh.getSdt(),
                kh.getHoaDonCT().getNgayMua(),
                kh.getSanPham().getTenSP(),
                kh.getHoaDonCT().getSoLuong(),
                kh.getHoaDonCT().getDonGia(),
                kh.getHoaDonCT().getTongTien(),
                kh.getHoaDonCT().getTrangThai()
            });
        }
    }

    boolean check() {
        if (txtMa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui long nhap ten");
            txtMa.requestFocus();
            return false;
        }
        if (txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email");
            txtTen.requestFocus();
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (!pat.matcher(txtemai.getText().trim()).matches()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng email");
            txtemai.requestFocus();
            return false;
        }

        if (tardiachi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui long nhap dia chi");
            tardiachi.requestFocus();
            return false;
        }
        if (txtsdt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
            txtsdt.requestFocus();
            return false;
        }

        return true;

    }

    KhachHang reafrom() {
        KhachHang cd = new KhachHang();
        cd.setMaKH(txtMa.getText());
        cd.setTenKH(txtTen.getText());
        cd.setSdt(txtsdt.getText());
        cd.setDiaChi(tardiachi.getText());
        cd.setEmail(txtemai.getText());
        cd.setNgaySinh(txtngaysinh.getDate());
        if (rdonam.isSelected()) {
            cd.setGioiTinh("Nam");
        } else {
            cd.setGioiTinh("Nu");
        }

        return cd;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbtrangthai = new javax.swing.JComboBox<>();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tardiachi = new javax.swing.JTextArea();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        txtemai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnsua = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        txtsdt = new javax.swing.JTextField();
        txtngaysinh = new com.toedter.calendar.JDateChooser();
        tblsearch = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblbang = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbbloc = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblbanggiaodich = new javax.swing.JTable();
        txttimkiemgd = new javax.swing.JTextField();
        btnxuatthongtin = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Khach Hang"));
        jPanel5.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã Khách Hàng :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên Khách Hàng :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Trạng Thái :");

        cbbtrangthai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lâu Năm", "Mới" }));
        cbbtrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtrangthaiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ngày Sinh:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("DIACHI :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Giới Tính :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("EMAIL :");

        tardiachi.setColumns(20);
        tardiachi.setRows(5);
        jScrollPane3.setViewportView(tardiachi);

        buttonGroup1.add(rdonam);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setText("Nu");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("SDT :");

        btnsua.setBackground(new java.awt.Color(51, 255, 255));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Gear.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlammoi.setBackground(new java.awt.Color(51, 255, 255));
        btnlammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        btnlammoi.setText("Làm mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(51, 255, 255));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnthem.setBackground(new java.awt.Color(51, 255, 255));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnthem.setText("Thêm ");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        txtngaysinh.setDateFormatString("dd-MM-yyyy");
        txtngaysinh.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtngaysinhAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(46, 46, 46)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel6))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemai, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rdonam)
                        .addGap(18, 18, 18)
                        .addComponent(rdonu))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtngaysinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlammoi)))
                .addGap(92, 92, 92))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdonam)
                            .addComponent(rdonu)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel9)
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnthem)
                        .addComponent(btnsua)
                        .addComponent(btnxoa)
                        .addComponent(btnlammoi))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        tblsearch.setBackground(new java.awt.Color(255, 255, 255));
        tblsearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sach Khách Hàng"));
        tblsearch.setToolTipText("");

        tblbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ma KH", "Ten KH", "Ngay Sinh", "GioiTinh", "SDT", "Email", "Dia Chi", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblbangAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblbang);

        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel12.setText("Tìm Kiếm");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        cbbloc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mới", "Lâu Năm", " " }));
        cbbloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbblocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(cbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout tblsearchLayout = new javax.swing.GroupLayout(tblsearch);
        tblsearch.setLayout(tblsearchLayout);
        tblsearchLayout.setHorizontalGroup(
            tblsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblsearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tblsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblsearchLayout.createSequentialGroup()
                        .addGroup(tblsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tblsearchLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(744, 744, 744)))
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblsearchLayout.createSequentialGroup()
                        .addGroup(tblsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        tblsearchLayout.setVerticalGroup(
            tblsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tblsearchLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(tblsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tblsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(tblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách Hàng", jPanel3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Lịch Sử Giao Dịch"));
        jPanel11.setToolTipText("");

        tblbanggiaodich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ten KH", "SDT", "Ngày GD", "Ten SP", "Số Lượng", "Giá Bán", "Tổng Tiền", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbanggiaodich.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblbanggiaodichAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblbanggiaodich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbanggiaodichMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblbanggiaodich);
        if (tblbanggiaodich.getColumnModel().getColumnCount() > 0) {
            tblbanggiaodich.getColumnModel().getColumn(0).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(1).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(2).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(3).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(4).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(5).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(6).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(7).setResizable(false);
            tblbanggiaodich.getColumnModel().getColumn(8).setResizable(false);
        }

        txttimkiemgd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemgdActionPerformed(evt);
            }
        });

        btnxuatthongtin.setBackground(new java.awt.Color(51, 255, 255));
        btnxuatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxuatthongtin.setText("Xuất Thông Tin");
        btnxuatthongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatthongtinActionPerformed(evt);
            }
        });

        jLabel11.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxuatthongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttimkiemgd, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnxuatthongtin)
                .addGap(13, 13, 13)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiemgd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông Tin Giao Dịch", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbtrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbtrangthaiActionPerformed

    private void tblbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangMouseClicked
        idex = tblbang.getSelectedRow();
        hienthi();
        loadtablespct();
    }//GEN-LAST:event_tblbangMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if (check()) {
            KhachHang kh = reafrom();
            int cf = JOptionPane.showConfirmDialog(this, "Bạn có muốn Thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION);

            if (cf == JOptionPane.YES_OPTION) {
                int row = khsevice.add(kh);

                if (row > 0) {
                    JOptionPane.showMessageDialog(this, "Bạn đã Thêm thành công");
                    loadtable();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm Thất bại hoặc không có dữ liệu để Thêm");
                }
            }
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtemai.setText("");
        txtngaysinh.setDate(null);
        txtsdt.setText("");
        tardiachi.setText("");
        rdonam.setSelected(true);
        cbbtrangthai.setSelectedItem(0);

    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        KhachHang kh = reafrom();
        int cf = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION);

        if (cf == JOptionPane.YES_OPTION) {
            int rowsUpdated = khsevice.update(kh);

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Bạn đã sửa thành công");
                loadtable();
            } else {
                JOptionPane.showMessageDialog(this, "Bạn đã sửa thất bại");
            }
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        KhachHang kh = reafrom();
        int cf = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION);

        if (cf == JOptionPane.YES_OPTION) {
            int row = tblbang.getSelectedRow();
            khsevice.Xoa(kh);
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Bạn đã xóa thành công");
                loadtable();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại hoặc không có dữ liệu để xóa");
            }
        }

    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnxuatthongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatthongtinActionPerformed
        khsevice.xuatDuLieuRaExcel();
    }//GEN-LAST:event_btnxuatthongtinActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        String searchText = txtTimkiem.getText().toLowerCase();

        ArrayList<KhachHang> searchResult = khsevice.Search(searchText);

        updateTableModel(searchResult);

    }//GEN-LAST:event_txtTimkiemActionPerformed
    private void updateTableModel(ArrayList<KhachHang> searchResult) {

        model.setRowCount(0);

        for (KhachHang kh : searchResult) {
            model.addRow(new Object[]{kh.getId(), kh.getMaKH(), kh.getTenKH(), kh.getNgaySinh(), kh.getGioiTinh(), kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isTrangThai() ? "Mới" : "Lâu Năm"});
        }
    }
    private void tblbanggiaodichAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblbanggiaodichAncestorAdded

    }//GEN-LAST:event_tblbanggiaodichAncestorAdded

    private void tblbangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblbangAncestorAdded
        loadtablespct();

    }//GEN-LAST:event_tblbangAncestorAdded

    private void tblbanggiaodichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbanggiaodichMouseClicked
        idex = tblbanggiaodich.getSelectedRow();
        loadtablespct();
    }//GEN-LAST:event_tblbanggiaodichMouseClicked

    private void txttimkiemgdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemgdActionPerformed
        String searchText = txttimkiemgd.getText().toLowerCase();

        ArrayList<KhachHang> searchResult = khsevice.SearchGD(searchText);

        Timkiemggd(searchResult);
    }//GEN-LAST:event_txttimkiemgdActionPerformed
    private void filterDataByBrand(String selectedBrand) {
        // Kiểm tra nếu thương hiệu được chọn không phải là placeholder "-- Chọn Thương hiệu --"
        if (!selectedBrand.equals("Tất cả")) {
            // Lọc dữ liệu của bảng dựa trên thương hiệu được chọn
            DefaultTableModel tableModel = (DefaultTableModel) tblbang.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
            tblbang.setRowSorter(sorter);

            // Thiết lập bộ lọc để chỉ hiển thị các hàng có thương hiệu tương ứng
            RowFilter<Object, Object> brandFilter = RowFilter.regexFilter(selectedBrand, 8); // 2 là chỉ số cột chứa thông tin thương hiệu
            sorter.setRowFilter(brandFilter);
        } else {
            // Nếu chọn "-- Chọn Thương hiệu --", hiển thị toàn bộ dữ liệu
            tblbang.setRowSorter(null);
        }
    }
    private void cbblocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbblocActionPerformed
        // Lấy thương hiệu được chọn từ ComboBox
        String selectedBrand = (String) cbbloc.getSelectedItem();

        // Gọi hàm để lọc dữ liệu dựa trên thương hiệu được chọn
        filterDataByBrand(selectedBrand);
    }//GEN-LAST:event_cbblocActionPerformed

    private void txtngaysinhAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtngaysinhAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtngaysinhAncestorAdded
    private void Timkiemggd(ArrayList<KhachHang> Timkiemggd) {
        DefaultTableModel model = (DefaultTableModel) tblbanggiaodich.getModel();
        model.setRowCount(0);
        for (KhachHang kh : Timkiemggd) {
            Object[] rowData = {
                kh.getId(),
                kh.getTenKH(),
                kh.getSdt(),
                kh.getHoaDonCT().getNgayMua(),
                kh.getSanPham().getTenSP(),
                kh.getHoaDonCT().getSoLuong(),
                kh.getHoaDonCT().getDonGia(),
                kh.getHoaDonCT().getTongTien(),
                kh.getHoaDonCT().getTrangThai(),};
            model.addRow(rowData);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxuatthongtin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbloc;
    private javax.swing.JComboBox<String> cbbtrangthai;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTextArea tardiachi;
    private javax.swing.JTable tblbang;
    private javax.swing.JTable tblbanggiaodich;
    private javax.swing.JPanel tblsearch;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtemai;
    private com.toedter.calendar.JDateChooser txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttimkiemgd;
    // End of variables declaration//GEN-END:variables

}
