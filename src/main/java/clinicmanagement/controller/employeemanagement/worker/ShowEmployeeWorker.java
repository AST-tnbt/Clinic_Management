/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.employeemanagement.worker;

import clinicmanagement.constant.admin.EmployeeManagementName;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Employee;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tin-ast
 */
public class ShowEmployeeWorker {
    @Inject @Named(EmployeeManagementName.EMPLOYEE_TABLE)
    private TableModelWrapper tableModelWrapper;
    
    public void refreshTable(ArrayList<Employee> employeeArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (Employee emp : employeeArrayList) {
                tableModel.addRow(new String[]{String.valueOf(emp.getId()), emp.getName(), emp.getPosition(), String.valueOf(emp.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))), emp.getSex(), emp.getAddress(), emp.getPhoneNum()});
            }
    }
}
