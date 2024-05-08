/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.employeemanagement;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import clinicmanagement.view.manager.Dashboard_Admin;
import com.google.inject.Inject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultEmployeeManagementBackDashboard extends MouseAdapter implements EmployeeManagementBackDashboard{
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    EmployeeManagement_Admin employeeManagement;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        employeeManagement.setVisible(false); 
    }
}
