/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Model.HoaDonCT;
import Model.KhoHang;
import Sevice.KhoHangSevice;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ADMIN
 */
public class KhoHangJPanel extends javax.swing.JPanel {

    private final KhoHangSevice khsv = new KhoHangSevice();
    DefaultTableModel model = new DefaultTableModel();

    public KhoHangJPanel() {
        initComponents();
        model = (DefaultTableModel) tblkhohang.getModel();
        hienthi();
    }

    private void hienthi() {
        DefaultTableModel model = (DefaultTableModel) this.tblkhohang.getModel();
        ArrayList<KhoHang> khlst = khsv.joinSPKH();
        model.setRowCount(0);
        for (KhoHang kh : khlst) {
            model.addRow(new Object[]{kh.getMasp(),
                kh.getTenSp(),
                kh.getGia(),
                kh.getSoluong(),
                kh.getSp().getNgayNhap()});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbloc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkhohang = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tra Cứu Hàng Tồn Kho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Loc");

        cbbloc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "2022-12-01", "2023-01-15", "2023-02-20", "2023-03-10", "2023-04-05" }));
        cbbloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbblocActionPerformed(evt);
            }
        });

        jLabel2.setText("Tìm kiếm hàng hóa:");

        btntimkiem.setText("Tìm kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        tblkhohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Gia", "Số Lượng Hàng Hóa", "NgayNhap"
            }
        ));
        tblkhohang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblkhohangAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tblkhohang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // Get the search criteria from a text field
        String searchString = txttimkiem.getText().trim();

        // Bước 2: Thực hiện tìm kiếm
        ArrayList<KhoHang> searchResult = khsv.searchSPKH(searchString);

        // Bước 3: Hiển thị kết quả tìm kiếm
        // Xóa dữ liệu trong bảng
        DefaultTableModel model = (DefaultTableModel) tblkhohang.getModel();
        model.setRowCount(0);

        if (searchResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp");
            return;
        } else {
            // Thêm dữ liệu mới từ kết quả tìm kiếm vào bảng
            for (KhoHang kh : searchResult) {
                model.addRow(new Object[]{kh.getMasp(), kh.getTenSp(), kh.getGia(), kh.getSoluong(), kh.getSp().getNgayNhap()});
            }
        }


    }//GEN-LAST:event_btntimkiemActionPerformed

    private void filterDataByBrand(String selectedBrand) {
        // Kiểm tra nếu thương hiệu được chọn không phải là placeholder "-- Chọn Thương hiệu --"
        if (!selectedBrand.equals("Tất cả")) {
            // Lọc dữ liệu của bảng dựa trên thương hiệu được chọn
            DefaultTableModel tableModel = (DefaultTableModel) tblkhohang.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
            tblkhohang.setRowSorter(sorter);

            // Thiết lập bộ lọc để chỉ hiển thị các hàng có thương hiệu tương ứng
            RowFilter<Object, Object> brandFilter = RowFilter.regexFilter(selectedBrand, 4); // 2 là chỉ số cột chứa thông tin thương hiệu
            sorter.setRowFilter(brandFilter);
        } else {
            // Nếu chọn "-- Chọn Thương hiệu --", hiển thị toàn bộ dữ liệu
            tblkhohang.setRowSorter(null);
        }
    }


    private void cbblocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbblocActionPerformed
        // Lấy thương hiệu được chọn từ ComboBox
        String selectedBrand = (String) cbbloc.getSelectedItem();

        // Gọi hàm để lọc dữ liệu dựa trên thương hiệu được chọn
        filterDataByBrand(selectedBrand);
    }//GEN-LAST:event_cbblocActionPerformed

    private void tblkhohangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblkhohangAncestorAdded

    }//GEN-LAST:event_tblkhohangAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntimkiem;
    private javax.swing.JComboBox<String> cbbloc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblkhohang;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
