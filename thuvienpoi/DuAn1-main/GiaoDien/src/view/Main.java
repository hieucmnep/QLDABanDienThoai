/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import Model.NhanVienModel;

/**
 *
 * @author LE DINH LINH
 */
public class Main extends javax.swing.JFrame {

    private BanHang panelSell;
    private boolean isMouseClicked = false;
    private SanPham panelSanPham;
    private KháchHang panelKhachhang;
    private HoaDonJPanel panelhoadon;
    private TrangChu panelTrangChu;
    private NhanVien panlenhanVien;

    public Main() {
        initComponents();
        setLocationRelativeTo(this);
        panelSell = new BanHang();
        panelSanPham = new SanPham();
        panelKhachhang = new KháchHang();
        panelhoadon = new HoaDonJPanel();
        panelTrangChu = new TrangChu();
        //panelnhan_vien = new NhanVien();
        panlenhanVien = new NhanVien();

    }

    private void showPanel(JPanel panel) {
        MainChinh.removeAll();
        MainChinh.add(panel);
        MainChinh.repaint();
        MainChinh.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        TrangChu = new javax.swing.JLabel();
        KhachHang = new javax.swing.JLabel();
        KhuyenMai = new javax.swing.JLabel();
        NhanVien = new javax.swing.JLabel();
        BanHang = new javax.swing.JLabel();
        SanPham = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Thongke = new javax.swing.JLabel();
        KhoHang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        vuuu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        MainChinh = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SMART SAP");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());

        menu.setBackground(new java.awt.Color(255, 204, 255));
        menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrangChu.setText("Trang Chủ");
        TrangChu.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        TrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrangChuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TrangChuMouseExited(evt);
            }
        });

        KhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KhachHang.setText("Khách Hàng");
        KhachHang.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        KhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KhachHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KhachHangMousePressed(evt);
            }
        });

        KhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KhuyenMai.setText("Hóa đơn");
        KhuyenMai.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        KhuyenMai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KhuyenMaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KhuyenMaiMouseEntered(evt);
            }
        });

        NhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NhanVien.setText("Nhân viên");
        NhanVien.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        NhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NhanVienMouseEntered(evt);
            }
        });

        BanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BanHang.setText("Bán Hàng");
        BanHang.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        BanHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BanHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BanHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BanHangMouseReleased(evt);
            }
        });

        SanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SanPham.setText("Sản Phẩm");
        SanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        SanPham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SanPhamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SanPhamMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SanPhamMousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 255));
        jLabel12.setText("SMART SAP");

        Thongke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Thongke.setText("Thống Kê");
        Thongke.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        Thongke.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongkeMouseClicked(evt);
            }
        });

        KhoHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KhoHang.setText("Kho Hàng");
        KhoHang.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        KhoHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        KhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KhoHangMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Phiên Bản Smart Sap  OU1.1");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(KhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(KhoHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(20, 20, 20)
                .addComponent(TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KhoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );

        vuuu.setBackground(new java.awt.Color(255, 204, 255));
        vuuu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hotro.jpg"))); // NOI18N

        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Hỗ Trợ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/changepass.jpg"))); // NOI18N

        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("Đổi mật khẩu");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Đangxuat.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("Đăng xuất");

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("Nhân viên:");

        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Vị Trí");

        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Giám Đốc");

        jLabel14.setForeground(new java.awt.Color(255, 0, 51));

        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("Thời gian");

        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("chưa có code");
        jLabel18.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel18AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel16)))
                .addGap(54, 54, 54)
                .addComponent(jLabel17)
                .addGap(30, 30, 30)
                .addComponent(jLabel18)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout vuuuLayout = new javax.swing.GroupLayout(vuuu);
        vuuu.setLayout(vuuuLayout);
        vuuuLayout.setHorizontalGroup(
            vuuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vuuuLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(vuuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(vuuuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)))
                .addGroup(vuuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vuuuLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton2))
                    .addGroup(vuuuLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel10)))
                .addGap(67, 67, 67)
                .addGroup(vuuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        vuuuLayout.setVerticalGroup(
            vuuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(vuuuLayout.createSequentialGroup()
                .addGroup(vuuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vuuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        MainChinh.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vuuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MainChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(vuuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MainChinh, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel18AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel18AncestorAdded
        // TODO add your handling code here:
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thời gian hiện tại
                Date currentDate = new Date();

                // Định dạng thời gian theo định dạng bạn muốn
                SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Định dạng ngày và giờ

                // Hiển thị thời gian trong JLabel có tên là jLabel18
                jLabel18.setText(timeFormat.format(currentDate));
            }
        });

        // Bắt đầu Timer để cập nhật thời gian mỗi giây
        timer.start();
    }//GEN-LAST:event_jLabel18AncestorAdded

    private void TrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrangChuMouseEntered

    }//GEN-LAST:event_TrangChuMouseEntered

    private void TrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrangChuMouseExited
        showPanel(panelTrangChu);
    }//GEN-LAST:event_TrangChuMouseExited

    private void TrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrangChuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TrangChuMouseClicked

    private void BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMouseClicked
        showPanel(panelSell);
    }//GEN-LAST:event_BanHangMouseClicked

    private void BanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMouseEntered
        BanHang.setOpaque(true);
        BanHang.setBackground(Color.RED);
    }//GEN-LAST:event_BanHangMouseEntered

    private void BanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMouseExited
        BanHang.setOpaque(false);
        // Set the default background color when mouse exits, you can use the original background color
        BanHang.setBackground(new Color(255, 204, 255));
    }//GEN-LAST:event_BanHangMouseExited

    private void SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPhamMouseClicked
        showPanel(panelSanPham);
    }//GEN-LAST:event_SanPhamMouseClicked

    private void SanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPhamMouseEntered
        SanPham.setOpaque(true);
        SanPham.setBackground(Color.RED);
    }//GEN-LAST:event_SanPhamMouseEntered

    private void SanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPhamMouseExited
        SanPham.setOpaque(false);
        SanPham.setBackground(new Color(255, 204, 255));
    }//GEN-LAST:event_SanPhamMouseExited

    private void BanHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMousePressed
        isMouseClicked = true;
        BanHang.setOpaque(true);
        BanHang.setBackground(Color.RED);
    }//GEN-LAST:event_BanHangMousePressed

    private void BanHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMouseReleased

    }//GEN-LAST:event_BanHangMouseReleased

    private void KhoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhoHangMouseClicked
        JOptionPane.showMessageDialog(this, "Chưa Phát Triên ");
    }//GEN-LAST:event_KhoHangMouseClicked

    private void ThongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongkeMouseClicked
        JOptionPane.showMessageDialog(this, "Chưa Phát Triên ");
    }//GEN-LAST:event_ThongkeMouseClicked

    private void NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhanVienMouseClicked
        showPanel(panlenhanVien);
    }//GEN-LAST:event_NhanVienMouseClicked

    private void KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseClicked
        showPanel(panelKhachhang);
    }//GEN-LAST:event_KhachHangMouseClicked

    private void KhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhuyenMaiMouseClicked
        showPanel(panelhoadon);
    }//GEN-LAST:event_KhuyenMaiMouseClicked

    private void KhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseEntered
        KhachHang.setOpaque(true);
        KhachHang.setBackground(Color.RED);
    }//GEN-LAST:event_KhachHangMouseEntered

    private void NhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhanVienMouseEntered

    }//GEN-LAST:event_NhanVienMouseEntered

    private void KhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhuyenMaiMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_KhuyenMaiMouseEntered

    private void SanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPhamMousePressed
        isMouseClicked = true;
        SanPham.setOpaque(true);
        SanPham.setBackground(Color.RED);
    }//GEN-LAST:event_SanPhamMousePressed

    private void KhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMousePressed
        isMouseClicked = true;
        KhachHang.setOpaque(true);
        KhachHang.setBackground(Color.RED);
    }//GEN-LAST:event_KhachHangMousePressed

    private void KhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseExited
        KhachHang.setOpaque(false);
        KhachHang.setBackground(new Color(255, 204, 255));
    }//GEN-LAST:event_KhachHangMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BanHang;
    private javax.swing.JLabel KhachHang;
    private javax.swing.JLabel KhoHang;
    private javax.swing.JLabel KhuyenMai;
    private javax.swing.JPanel MainChinh;
    private javax.swing.JLabel NhanVien;
    private javax.swing.JLabel SanPham;
    private javax.swing.JLabel Thongke;
    private javax.swing.JLabel TrangChu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel vuuu;
    // End of variables declaration//GEN-END:variables
}