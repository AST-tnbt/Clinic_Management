/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicmanagement.view.manager;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.controller.employeemanagement.*;
import clinicmanagement.controller.room.RoomManagementBackDashboard;
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
public class RoomManagement_Admin extends javax.swing.JFrame {
    /**
     * Creates new form EmployeeManagement
     */
    public RoomManagement_Admin() {
        initComponents();
        setTitle("TWP clinic management - Phòng");
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
        addButton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JLabel();
        modifyButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hospital.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setText("QUẢN LÝ PHÒNG");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
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

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N

        employeeTable.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Số lượng bệnh nhân tối đa"
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
        employeeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        employeeTable.setRowHeight(30);
        employeeTable.setShowGrid(true);
        jScrollPane1.setViewportView(employeeTable);

        searchBar.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N

        searchButton.setBackground(new java.awt.Color(252, 104, 26));
        searchButton.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Tìm");

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin.png"))); // NOI18N

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/compose.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(modifyButton))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(40, 40, 40)
                        .addComponent(deleteButton)
                        .addGap(40, 40, 40)
                        .addComponent(modifyButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addButton;
    private javax.swing.JLabel backDashboardBtn;
    private javax.swing.JLabel deleteButton;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modifyButton;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

//    @Inject
//    public void SetModels(
//            @Named(EmployeeManagementName.EMPLOYEE_TABLE) TableModelWrapper tableModelWrapper,
//            @Named(EmployeeManagementName.EMPLOYEE_TABLE_LIST_SELECTION) TableListModelSelectionWrapper tableListModelSelectionWrapper,
//            @Named(EmployeeManagementName.EMPLOYEE_SEARCH_INPUT) Document searchInput
//            ) {
//        tableModelWrapper.setModel(this.employeeTable.getModel());
//        tableListModelSelectionWrapper.setSelectionModel(this.employeeTable.getSelectionModel());
//        this.searchBar.setDocument(searchInput);
//    }
//    
    @Inject
    public void setListener(
//        EmployeeManagementAddButtonListener employeeManagementAddButton,
        RoomManagementBackDashboard roomManagementBackDashboard
//        EmployeeManagementShowEmployee employeeManagementShowEmployee,
//        EmployeeManagementDeleteButtonListener employeeManagementDeleteButtonListener,
//        EmployeeManagementSearchButtonListener employeeManagementSearchButtonListener,
//        EmployeeManagementModifyButtonListener employeeManagementModifyButtonListener,
//        EmployeeManagementSearchBarKeyPress employeeManagementSearchBarKeyPress
    ) {
//        this.addButton.addMouseListener(employeeManagementAddButton);
        this.backDashboardBtn.addMouseListener(roomManagementBackDashboard);
//        this.addComponentListener(employeeManagementShowEmployee);
//        this.deleteButton.addMouseListener(employeeManagementDeleteButtonListener);
//        this.searchButton.addActionListener(employeeManagementSearchButtonListener);
//        this.searchBar.addActionListener(employeeManagementSearchButtonListener);
//        this.modifyButton.addMouseListener(employeeManagementModifyButtonListener);
//        this.searchBar.addKeyListener(employeeManagementSearchBarKeyPress);
    }
}
