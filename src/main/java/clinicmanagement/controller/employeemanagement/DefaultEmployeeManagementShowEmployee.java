/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.employeemanagement;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.service.EmployeeService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;


/**
 *
 * @author tin-ast
 */
public class DefaultEmployeeManagementShowEmployee extends ComponentAdapter implements EmployeeManagementShowEmployee{
    @Inject private Provider<ShowEmployeeWorker> showEmployeeWorkerProvider;

    @Inject @Named(EmployeeManagementName.EMPLOYEE_TABLE)
    private TableModelWrapper tableModelWrapper;

    @Inject EmployeeService employeeService;

    @Override
    public void componentShown(ComponentEvent e) {
        showEmployeeWorkerProvider.get().refreshTable(employeeService.getListEmployee());
    }
}
