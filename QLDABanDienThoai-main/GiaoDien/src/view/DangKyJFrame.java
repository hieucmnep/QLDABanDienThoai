package view;

import Service.TaiKhoan;

import javax.swing.JOptionPane;

public class DangKyJFrame extends javax.swing.JFrame {

    /**
     * Creates new form DangKyJFrame
     */
    public DangKyJFrame() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtnhaplai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btndangky = new javax.swing.JButton();
        txtmatkhau = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        AnhNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đăng Ký");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 270, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Đăng Nhập:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        getContentPane().add(txtnhaplai, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 270, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nhập Lại Mật Khẩu:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bạn đã có tài khoản");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        btndangky.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btndangky.setText("Đăng Ký");
        btndangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangkyActionPerformed(evt);
            }
        });
        getContentPane().add(btndangky, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 270, 40));
        getContentPane().add(txtmatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 270, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mật Khẩu:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Tôi đồng ý với tất cả điều khoản");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("Đăng Nhập");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 535, -1, -1));

        AnhNen.setBackground(new java.awt.Color(102, 0, 102));
        AnhNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/AnhNen.png"))); // NOI18N
        AnhNen.setText("jLabel1");
        getContentPane().add(AnhNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 358, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndangkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangkyActionPerformed
        // Lấy thông tin từ các ô văn bản
        String username = txtname.getText();
        String password = txtmatkhau.getText();
        String confirmPassword = txtnhaplai.getText();

        // Kiểm tra xem đã nhập đầy đủ thông tin chưa
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra xem mật khẩu và xác nhận mật khẩu có trùng khớp không
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu và xác nhận mật khẩu không khớp.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra xem ô đồng ý điều khoản có được chọn không
        if (!jCheckBox1.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn cần đồng ý với điều khoản.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tạo đối tượng NhanVien để thêm vào cơ sở dữ liệu
        Model.NhanVienYk nv = new Model.NhanVienYk();
        nv.setMaNV(username);
        nv.setMatKhau(password);
        // Bạn có thể cần thêm các thông tin khác của nhân viên tại đây

        // Thêm tài khoản vào cơ sở dữ liệu
        TaiKhoan nhanVienDAO = new TaiKhoan();
        boolean success = nhanVienDAO.themTaiKhoanFromNhanVien(nv);

        // Kiểm tra kết quả và hiển thị thông báo tương ứng
        if (success) {
            JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            // Sau khi đăng ký thành công, có thể chuyển hướng đến cửa sổ đăng nhập hoặc thực hiện các hành động khác.
        } else {
            JOptionPane.showMessageDialog(this, "Đăng ký không thành công. Vui lòng thử lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndangkyActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        DangNhapJFrame dangNhap = new DangNhapJFrame();
        dangNhap.setVisible(true);
        dangNhap.pack();
        dangNhap.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhNen;
    private javax.swing.JButton btndangky;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtmatkhau;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnhaplai;
    // End of variables declaration//GEN-END:variables
}
