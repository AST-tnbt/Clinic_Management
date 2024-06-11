/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicmanagement.view.manager;

import clinicmanagement.constant.admin.AddEmployeeName;
import clinicmanagement.controller.addemployee.AddEmployeeCancelListener;
import clinicmanagement.controller.addemployee.AddEmployeeSubmitListener;
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
public class AddEmployee_Admin extends BaseView {

    /**
     * Creates new form addEmployee
     */
    public AddEmployee_Admin() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("TWP clinic management - Thêm nhân sự");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputEmpDayOfBirth = new javax.swing.JTextField();
        inputEmpAddress = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        inputEmpName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputEmpPhoneNum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inputEmpPassword = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        inputEmpUsername = new javax.swing.JTextField();
        inputEmpSex = new javax.swing.JComboBox<>();
        inputEmpPosition = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel1.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin nhân sự");

        jLabel3.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel3.setText("Địa chỉ");

        jLabel4.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel5.setText("Chức vụ");

        inputEmpDayOfBirth.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        inputEmpAddress.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        submitBtn.setBackground(new java.awt.Color(252, 104, 26));
        submitBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Xác nhận");

        cancelBtn.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(252, 104, 26));
        cancelBtn.setText("Hủy bỏ");

        jLabel6.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel6.setText("Họ và tên");

        inputEmpName.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel7.setText("Giới tính");

        jLabel8.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel8.setText("Số điện thoại");

        inputEmpPhoneNum.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel9.setText("Mật khẩu");

        inputEmpPassword.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel10.setText("Tài khoản");

        inputEmpUsername.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        inputEmpSex.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        inputEmpSex.setBorder(null);

        inputEmpPosition.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        inputEmpPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Bác sĩ", "Chuyên viên", "Nhân viên kế toán" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputEmpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputEmpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(inputEmpPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel7)
                                    .addGap(99, 99, 99))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(inputEmpSex, 0, 182, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(inputEmpDayOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(inputEmpPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(inputEmpAddress)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(202, 202, 202)
                                .addComponent(jLabel8)
                                .addGap(145, 145, 145))
                            .addComponent(jLabel6))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(215, 215, 215))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmpSex)
                    .addComponent(inputEmpPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmpDayOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmpPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField inputEmpAddress;
    private javax.swing.JTextField inputEmpDayOfBirth;
    private javax.swing.JTextField inputEmpName;
    private javax.swing.JTextField inputEmpPassword;
    private javax.swing.JTextField inputEmpPhoneNum;
    private javax.swing.JComboBox<String> inputEmpPosition;
    private javax.swing.JComboBox<String> inputEmpSex;
    private javax.swing.JTextField inputEmpUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
    @Inject
    public void setModels(
        @Named(AddEmployeeName.E_NAME) Document inputEmpName,
        @Named(AddEmployeeName.E_POSITION) ComboBoxModel inputEmpPosstion,
        @Named(AddEmployeeName.E_SEX) ComboBoxModel inputEmpSex,
        @Named(AddEmployeeName.E_ADDRESS) Document inputEmpAddress,
        @Named(AddEmployeeName.E_DAYOFBIRTH) Document inputEmpDayOfBirth,
        @Named(AddEmployeeName.E_PHONENUMBER) Document inputEmpPhoneNum,
        @Named(AddEmployeeName.E_USERNAME) Document inputEmpUsername,
        @Named(AddEmployeeName.E_PASSWORD) Document inputEmpPassword
    ) {
        this.inputEmpName.setDocument(inputEmpName);
        this.inputEmpPosition.setModel(inputEmpPosstion);
        this.inputEmpSex.setModel(inputEmpSex);
        this.inputEmpAddress.setDocument(inputEmpAddress);
        this.inputEmpDayOfBirth.setDocument(inputEmpDayOfBirth);
        this.inputEmpPhoneNum.setDocument(inputEmpPhoneNum);
        this.inputEmpUsername.setDocument(inputEmpUsername);
        this.inputEmpPassword.setDocument(inputEmpPassword);
        this.addRepaintComponent(
                this.inputEmpName,
                this.inputEmpPosition,
                this.inputEmpSex,
                this.inputEmpAddress,
                this.inputEmpDayOfBirth,
                this.inputEmpPhoneNum,
                this.inputEmpUsername,
                this.inputEmpPassword
        );
    }
    @Inject
    public void setListeners(
        AddEmployeeSubmitListener addEmployeeSubmitListener,
        AddEmployeeCancelListener addEmployeeCancelListener
    ) {
        this.submitBtn.addActionListener(addEmployeeSubmitListener);
        this.cancelBtn.addActionListener(addEmployeeCancelListener);
    }
}
