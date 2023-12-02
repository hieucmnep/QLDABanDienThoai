package view;

import Model.NhanVien;
import Sevice.TaiKhoan;
import dbconnect.MsgBox;
import dbconnect.Auth;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.DangKyJFrame;
import javax.swing.JFrame;

public class DangNhapJFrame extends javax.swing.JFrame {

    TaiKhoan dao = new TaiKhoan();

    public DangNhapJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        Luumatkhau = new javax.swing.JCheckBox();
        btnDangKy = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        AnhNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đăng Nhập");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 270, 40));
        txtTen.getAccessibleContext().setAccessibleName("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Đăng Nhập:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mật Khẩu:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bạn có tài khoản chưa? ");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 270, 40));

        Luumatkhau.setBackground(new java.awt.Color(0, 0, 0));
        Luumatkhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Luumatkhau.setForeground(new java.awt.Color(255, 255, 255));
        Luumatkhau.setText("Ghi nhớ đăng nhập");
        Luumatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuumatkhauActionPerformed(evt);
            }
        });
        getContentPane().add(Luumatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        btnDangKy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(102, 102, 255));
        btnDangKy.setText("Đăng Ký");
        btnDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangKyMouseClicked(evt);
            }
        });
        getContentPane().add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 505, -1, -1));
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 270, 40));

        AnhNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/AnhNen.png"))); // NOI18N
        AnhNen.setText("jLabel1");
        getContentPane().add(AnhNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 358, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void dangNhap() {
        String strMaTK = txtTen.getText().trim();
        String strPassword = new String(txtMatKhau.getPassword());
        ArrayList<NhanVien> ketQuaTimKiem = new ArrayList<>();
        if (!strMaTK.isEmpty()) {
            ketQuaTimKiem = dao.timKiemMaTK(strMaTK);
            if (ketQuaTimKiem.isEmpty()) {
                MsgBox.alert(this, "Tên đăng nhập không tồn tại");
            } else {
                if (!ketQuaTimKiem.get(0).getMatKhau().equals(strPassword)) {
                    MsgBox.alert(this, "Sai mật khẩu");
                } else {
                    Auth.user = ketQuaTimKiem.get(0);
                    this.dispose();
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui Long Nhập Thông Tin.", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
        if (Auth.user != null) {

            Main mainFrame = new Main();
            mainFrame.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnDangKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangKyMouseClicked
        // TODO add your handling code here:
        DangKyJFrame dangky = new DangKyJFrame();
        dangky.setVisible(true);
        dangky.pack();
        dangky.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnDangKyMouseClicked

    private void LuumatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuumatkhauActionPerformed
        if (Luumatkhau.isSelected()) {
            String username = txtTen.getText();
            char[] password = txtMatKhau.getPassword();

            try (PrintWriter writer = new PrintWriter(new FileWriter("loginInfo.txt"))) {
                // Save username and password to a file
                writer.println(username);
                writer.println(new String(password));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_LuumatkhauActionPerformed
    private void loadSavedLoginInfo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("loginInfo.txt"))) {
            String username = reader.readLine();
            String password = reader.readLine();

            // Set the loaded username and password to the corresponding fields
            txtTen.setText(username);
            txtMatKhau.setText(password);
        } catch (IOException e) {
            // Handle the case when the file doesn't exist or an error occurs
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhNen;
    private javax.swing.JCheckBox Luumatkhau;
    private javax.swing.JLabel btnDangKy;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
