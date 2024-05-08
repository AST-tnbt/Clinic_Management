/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.employeemanagement;

import clinicmanagement.view.manager.AddEmployee_Admin;
import com.google.inject.Inject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultEmployeeManagementAddButtonListener extends MouseAdapter implements EmployeeManagementAddButtonListener{
    @Inject
    private AddEmployee_Admin addEmployee;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addEmployee.setVisible(true); 
    }
}
