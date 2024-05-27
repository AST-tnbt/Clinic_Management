/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicmanagement.view.manager;

import clinicmanagement.constant.MedicalRecordManagementName;
import clinicmanagement.controller.medicalrecordmanagement.MedicalRecordManagementAddButtonListener;
import clinicmanagement.controller.medicalrecordmanagement.MedicalRecordManagementShowMedicalRecord;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import javax.swing.JFrame;

import javax.swing.text.Document;

/**
 *
 * @author tin-ast
 */
public class MedicalRecordManagement_Admin extends javax.swing.JFrame {

    /**
     * Creates new form MedicalRecordManagement_Admin
     */
    public MedicalRecordManagement_Admin() {
        initComponents();
        setTitle("TWP clinic management - Danh sách bệnh án");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        medicalRecordTable = new javax.swing.JTable();
        deleteBtn = new javax.swing.JLabel();
        addBtn = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách bệnh án");

        medicalRecordTable.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        medicalRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã bệnh án", "Ngày khám", "Tình trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        medicalRecordTable.setRowHeight(30);
        jScrollPane1.setViewportView(medicalRecordTable);

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin.png"))); // NOI18N

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/compose.png"))); // NOI18N

        name.setEditable(false);
        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel2.setText("Bệnh nhân:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addBtn)
                            .addComponent(modifyBtn)
                            .addComponent(deleteBtn))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifyBtn)
                        .addGap(59, 59, 59)
                        .addComponent(deleteBtn)
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))))
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
            java.util.logging.Logger.getLogger(MedicalRecordManagement_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicalRecordManagement_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicalRecordManagement_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicalRecordManagement_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicalRecordManagement_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBtn;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicalRecordTable;
    private javax.swing.JLabel modifyBtn;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables

    @Inject
    public void setModels (
            @Named(MedicalRecordManagementName.MEDICAL_RECORD_NAME) Document name ,
            @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE)TableModelWrapper tableModelWrapper,
            @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE_LIST_SELECTION)TableListModelSelectionWrapper tableListModelSelectionWrapper
            ) {
        this.name.setDocument(name);
        tableModelWrapper.setModel(this.medicalRecordTable.getModel());
        tableListModelSelectionWrapper.setSelectionModel(this.medicalRecordTable.getSelectionModel());
    }
    @Inject
    public void setListeners (
        MedicalRecordManagementShowMedicalRecord medicalRecordManagementShowMedicalRecord,
        MedicalRecordManagementAddButtonListener medicalRecordManagementAddButtonListener
    ) {
        this.addComponentListener(medicalRecordManagementShowMedicalRecord);
        this.addBtn.addMouseListener(medicalRecordManagementAddButtonListener);
    }
}
