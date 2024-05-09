/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.employeemanagement;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jakarta.inject.Named;
import java.awt.Component;
import java.awt.Container;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tin-ast
 */
public class DefaultEmployeeManagementDeleteButtonListener extends MouseAdapter implements EmployeeManagementDeleteButtonListener {
    @Inject @Named(EmployeeManagementName.EMPLOYEE_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(EmployeeManagementName.EMPLOYEE_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private Provider<ShowEmployeeWorker> showEmployeeWorkerProvider;
    @Inject
    private EmployeeService employeeService;

    private ArrayList<String> listId = new ArrayList<>();

    private String idDel;
    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                employeeService.deleteById(idDel, listId);
            } catch (SQLException e) {
                return false;
            }
            return true;
        }
        @Override
        protected void done() {
            try {
                if (get()) {
                    showEmployeeWorkerProvider.get().refreshTable(employeeService.getListEmployee());
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        StringBuilder idDelBuilder = new StringBuilder();

        for (int i = 0; i < rows.length; i++) {
            listId.add((String) tableModelWrapper.getModel().getValueAt(rows[i], 0));
            idDelBuilder.append("MaNV='").append((String) tableModelWrapper.getModel().getValueAt(rows[i], 0)).append("'");
            if (i < rows.length - 1) {
                idDelBuilder.append(" OR ");
            }
        }
        this.idDel = idDelBuilder.toString();
        new Worker().execute();
    }
    
}
