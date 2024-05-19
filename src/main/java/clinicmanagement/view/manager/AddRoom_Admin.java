/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicmanagement.view.manager;

import clinicmanagement.constant.AddRoomName;
import clinicmanagement.constant.RoomManagementName;
import clinicmanagement.controller.addroom.AddRoomCancelListener;
import clinicmanagement.controller.addroom.AddRoomSubmitListener;
import clinicmanagement.view.BaseView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;

/**
 *
 * @author tin-ast
 */
@Singleton
public class AddRoom_Admin extends BaseView {

    /**
     * Creates new form AddRoom
     */
    public AddRoom_Admin() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("TWP clinic management - Thêm phòng");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputAmount = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm thông tin phòng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel2.setText("Tên phòng:");

        inputName.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel3.setText("Số lượng bệnh nhân tối đa:");

        inputAmount.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        submitBtn.setBackground(new java.awt.Color(252, 104, 26));
        submitBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Xác nhận");

        cancelBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(252, 104, 26));
        cancelBtn.setText("Hủy bỏ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputAmount))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(submitBtn))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField inputAmount;
    private javax.swing.JTextField inputName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
    @Inject
    public void setModels(
            @Named(AddRoomName.R_NAME) Document name,
            @Named(AddRoomName.R_CAPACITY) Document capacity
    ) {
        this.inputName.setDocument(name);
        this.inputAmount.setDocument(capacity);
        this.addRepaintComponent(
                this.inputName,
                this.inputAmount
        );
    }
    @Inject
    public void setListeners(
            AddRoomCancelListener addRoomCancelListener,
            AddRoomSubmitListener addRoomSubmitListener
    ) {
        this.cancelBtn.addActionListener(addRoomCancelListener);
        this.submitBtn.addActionListener(addRoomSubmitListener);
    }
}
