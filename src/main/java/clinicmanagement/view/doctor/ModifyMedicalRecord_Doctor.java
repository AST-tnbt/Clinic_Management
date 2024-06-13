/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicmanagement.view.doctor;

import clinicmanagement.constant.doctor.DoctorModifyMedicalRecordName;
import clinicmanagement.controller.modifymedicalrecord.admin.ModifyMedicalRecordAddPrescriptionListener;
import clinicmanagement.controller.modifymedicalrecord.admin.ModifyMedicalRecordCancelListener;
import clinicmanagement.controller.modifymedicalrecord.admin.ModifyMedicalRecordSubmitListener;
import clinicmanagement.controller.modifymedicalrecord.doctor.DoctorModifyMedicalRecordAddPrescriptionListener;
import clinicmanagement.controller.modifymedicalrecord.doctor.DoctorModifyMedicalRecordCancelListener;
import clinicmanagement.controller.modifymedicalrecord.doctor.DoctorModifyMedicalRecordSubmitListener;
import clinicmanagement.view.BaseView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.text.Document;

/**
 *
 * @author tin-ast
 */
@Singleton
public class ModifyMedicalRecord_Doctor extends BaseView {

    /**
     * Creates new form MedicalRecord_Admin
     */
    public ModifyMedicalRecord_Doctor() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("TWP clinic management - Cập nhật bệnh án");
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
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateOfBirth = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        diagnosis = new javax.swing.JTextArea();
        sex = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        appointmentDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        room = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputPrescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        addPrescriptionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HỒ SƠ BỆNH ÁN");

        jLabel2.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel2.setText("Họ và tên:");

        name.setEditable(false);
        name.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel3.setText("Ngày sinh:");

        dateOfBirth.setEditable(false);
        dateOfBirth.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel4.setText("Giới tính:");

        jLabel5.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel5.setText("Chẩn đoán:");

        diagnosis.setColumns(20);
        diagnosis.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        diagnosis.setRows(5);
        jScrollPane1.setViewportView(diagnosis);

        sex.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        sex.setEnabled(false);
        sex.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setForeground(Color.BLACK);
                super.paint(g);
            }
        });

        jLabel7.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel7.setText("Ngày khám:");

        appointmentDate.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel8.setText("Tình trạng:");

        status.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã điều trị", "Nhập viện", "Đã xuất viện" }));
        status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        status.setFocusable(false);
        status.setRequestFocusEnabled(false);
        status.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setForeground(Color.BLACK);
                super.paint(g);
            }
        });

        jLabel9.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel9.setText("Phòng:");

        room.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        submitBtn.setBackground(new java.awt.Color(252, 104, 26));
        submitBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Lưu");

        cancelBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(252, 104, 26));
        cancelBtn.setText("Hủy bỏ");

        inputPrescription.setEditable(false);
        inputPrescription.setColumns(20);
        inputPrescription.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        inputPrescription.setRows(5);
        jScrollPane2.setViewportView(inputPrescription);

        jLabel6.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel6.setText("Toa thuốc:");

        addPrescriptionBtn.setBackground(new java.awt.Color(252, 104, 26));
        addPrescriptionBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        addPrescriptionBtn.setForeground(new java.awt.Color(255, 255, 255));
        addPrescriptionBtn.setText("Kê toa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addPrescriptionBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(appointmentDate))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(sex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(appointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(addPrescriptionBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(cancelBtn))
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ModifyMedicalRecord_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyMedicalRecord_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyMedicalRecord_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyMedicalRecord_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyMedicalRecord_Doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPrescriptionBtn;
    private javax.swing.JTextField appointmentDate;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField dateOfBirth;
    private javax.swing.JTextArea diagnosis;
    private javax.swing.JTextArea inputPrescription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField room;
    private javax.swing.JComboBox<String> sex;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables

    @Inject
    public void setModels(
        @Named(DoctorModifyMedicalRecordName.P_NAME) Document p_name,
        @Named(DoctorModifyMedicalRecordName.P_DATEOFBIRTH) Document p_dateOfBirth,
        @Named(DoctorModifyMedicalRecordName.P_SEX) ComboBoxModel p_sex,
        @Named(DoctorModifyMedicalRecordName.P_DIAGNOSIS) Document p_diagnosis,
        @Named(DoctorModifyMedicalRecordName.P_APPOINTMENTDATE) Document p_appointmentDate,
        @Named(DoctorModifyMedicalRecordName.P_STATUS) ComboBoxModel p_status,
        @Named(DoctorModifyMedicalRecordName.P_ROOM) Document p_room,
        @Named(DoctorModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW) Document p_prescription

    ) {
        this.name.setDocument(p_name);
        this.dateOfBirth.setDocument(p_dateOfBirth);
        this.sex.setModel(p_sex);
        this.diagnosis.setDocument(p_diagnosis);
        this.appointmentDate.setDocument(p_appointmentDate);
        this.room.setDocument(p_room);
        this.status.setModel(p_status);
        this.inputPrescription.setDocument(p_prescription);
        this.addRepaintComponent(
                this.name,
                this.dateOfBirth,
                this.diagnosis,
                this.appointmentDate,
                this.room,
                this.inputPrescription
        );
    }
    @Inject
    public void setListeners(
        DoctorModifyMedicalRecordCancelListener medicalRecordCancelListener,
        DoctorModifyMedicalRecordAddPrescriptionListener modifyMedicalRecordAddPrescriptionListener,
        DoctorModifyMedicalRecordSubmitListener modifyMedicalRecordSubmitListener
    ) {
        this.cancelBtn.addActionListener(medicalRecordCancelListener);
        this.addPrescriptionBtn.addActionListener(modifyMedicalRecordAddPrescriptionListener);
        this.submitBtn.addActionListener(modifyMedicalRecordSubmitListener);
    }
}