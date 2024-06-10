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

    private ArrayList<Integer> listId = new ArrayList<>();
    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                employeeService.deleteById(listId);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên");
            return;
        }
        for (int row : rows) {
            listId.add(Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(row, 0)));
        }
        new Worker().execute();
    }
    
}
