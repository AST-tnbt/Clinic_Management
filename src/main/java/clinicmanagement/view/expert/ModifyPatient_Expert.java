/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicmanagement.view.expert;

import clinicmanagement.constant.admin.ModifyPatientName;
import clinicmanagement.controller.modifypatient.ModifyPatientCancelListener;
import clinicmanagement.controller.modifypatient.ModifyPatientSubmitListener;
import clinicmanagement.view.BaseView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.text.Document;

/**
 *
 * @author tin-ast
 */
@Singleton
public class ModifyPatient_Expert extends BaseView {

    /**
     * Creates new form addEmployee
     */
    public ModifyPatient_Expert() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("TWP clinic management - Sửa thông tin bệnh nhân");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputPatientID = new javax.swing.JTextField();
        inputPatientDayOfBirth = new javax.swing.JTextField();
        inputPatientAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputPatientName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputPatientPhoneNum = new javax.swing.JTextField();
        inputPatientSex = new javax.swing.JComboBox<>();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel1.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin bệnh nhân");

        jLabel2.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel2.setText("Mã bệnh nhân");

        jLabel3.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel3.setText("Địa chỉ");

        jLabel4.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel4.setText("Ngày sinh");

        inputPatientID.setEditable(false);
        inputPatientID.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        inputPatientDayOfBirth.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        inputPatientAddress.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel6.setText("Họ và tên");

        inputPatientName.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel7.setText("Giới tính");

        jLabel8.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel8.setText("Số điện thoại");

        inputPatientPhoneNum.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        inputPatientSex.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        inputPatientSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        inputPatientSex.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(inputPatientAddress)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 240, Short.MAX_VALUE))
                            .addComponent(inputPatientDayOfBirth))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPatientSex, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(inputPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(inputPatientPhoneNum, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPatientSex)
                    .addComponent(inputPatientDayOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPatientPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPatientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        submitBtn.setBackground(new java.awt.Color(252, 104, 26));
        submitBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Cập nhật");

        cancelBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(252, 104, 26));
        cancelBtn.setText("Hủy bỏ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField inputPatientAddress;
    private javax.swing.JTextField inputPatientDayOfBirth;
    private javax.swing.JTextField inputPatientID;
    private javax.swing.JTextField inputPatientName;
    private javax.swing.JTextField inputPatientPhoneNum;
    private javax.swing.JComboBox<String> inputPatientSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
    @Inject
    public void setModels(
        @Named(ModifyPatientName.P_ID) Document inputPatientID,
        @Named(ModifyPatientName.P_NAME) Document inputPatientName,
        @Named(ModifyPatientName.P_SEX) ComboBoxModel inputPatientSex,
        @Named(ModifyPatientName.P_ADDRESS) Document inputPatientAddress,
        @Named(ModifyPatientName.P_DAYOFBIRTH) Document inputPatientDayOfBirth,
        @Named(ModifyPatientName.P_PHONENUMBER) Document inputPatientPhoneNum
    ) {
        this.inputPatientID.setDocument(inputPatientID);
        this.inputPatientName.setDocument(inputPatientName);
        this.inputPatientSex.setModel(inputPatientSex);
        this.inputPatientAddress.setDocument(inputPatientAddress);
        this.inputPatientDayOfBirth.setDocument(inputPatientDayOfBirth);
        this.inputPatientPhoneNum.setDocument(inputPatientPhoneNum);
        this.addRepaintComponent(this.inputPatientID,
                this.inputPatientName,
                this.inputPatientSex,
                this.inputPatientAddress,
                this.inputPatientDayOfBirth,
                this.inputPatientPhoneNum
        );
    }
    @Inject
    public void setListeners(
        ModifyPatientCancelListener modifyPatientCancelListener,
        ModifyPatientSubmitListener modifyPatientSubmitListener
    ) {
        this.cancelBtn.addActionListener(modifyPatientCancelListener);
        this.submitBtn.addActionListener(modifyPatientSubmitListener);
    }
}
