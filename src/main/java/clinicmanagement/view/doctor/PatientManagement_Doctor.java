/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicmanagement.view.doctor;

import clinicmanagement.constant.doctor.DoctorPatientManagementName;
import clinicmanagement.controller.patientmanagement.doctor.*;
import clinicmanagement.view.manager.*;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.controller.patientmanagement.admin.*;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import javax.swing.text.Document;

/**
 *
 * @author tin-ast
 */
@Singleton
public class PatientManagement_Doctor extends javax.swing.JFrame {
    /**
     * Creates new form EmployeeManagement
     */
    public PatientManagement_Doctor() {
        initComponents();
        setTitle("TWP clinic management - Bệnh nhân");
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
        backDashboardBtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        viewMedicalRecord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patientdetals.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setText("QUẢN LÝ BỆNH NHÂN");

        backDashboardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(backDashboardBtn)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backDashboardBtn)
                            .addComponent(jLabel2))
                        .addGap(58, 58, 58))))
        );

        patientTable.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã BN", "Họ và tên", "Ngày sinh", "Giới tính", "SĐT", "Địa chỉ", "Tổng chi phí"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        patientTable.setRowHeight(30);
        patientTable.setShowGrid(true);
        jScrollPane1.setViewportView(patientTable);

        searchBar.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        searchButton.setBackground(new java.awt.Color(252, 104, 26));
        searchButton.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Tìm");

        viewMedicalRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medicalRecordIcon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewMedicalRecord)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewMedicalRecord))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backDashboardBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientTable;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel viewMedicalRecord;
    // End of variables declaration//GEN-END:variables

    @Inject
    public void SetModels(
            @Named(DoctorPatientManagementName.PATIENT_TABLE) TableModelWrapper tableModelWrapper,
            @Named(DoctorPatientManagementName.PATIENT_TABLE_LIST_SELECTION) TableListModelSelectionWrapper tableListModelSelectionWrapper,
            @Named(DoctorPatientManagementName.PATIENT_SEARCH_INPUT) Document searchInput
            ) {
        tableModelWrapper.setModel(this.patientTable.getModel());
        tableListModelSelectionWrapper.setSelectionModel(this.patientTable.getSelectionModel());
        this.searchBar.setDocument(searchInput);
    }
    
    @Inject
    public void setListener(
        DoctorPatientManagementBackDashboard patientManagementBackDashboard,
        DoctorPatientManagementShowPatient patientManagementShowPatient,
        DoctorPatientManagementSearchButtonListener patientManagementSearchButtonListener,
        DoctorPatientManagementSearchBarKeyPress patientManagementSearchBarKeyPress,
        DoctorPatientManagementViewRecordListener patientManagementViewRecordListener
    ) {
        this.backDashboardBtn.addMouseListener(patientManagementBackDashboard);
        this.addComponentListener(patientManagementShowPatient);
        this.searchButton.addActionListener(patientManagementSearchButtonListener);
        this.searchBar.addActionListener(patientManagementSearchButtonListener);
        this.searchBar.addKeyListener(patientManagementSearchBarKeyPress);
        this.viewMedicalRecord.addMouseListener(patientManagementViewRecordListener);
    }
}
