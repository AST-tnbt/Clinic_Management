/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addemployee;

import clinicmanagement.constant.admin.AddEmployeeName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddEmployee_Admin;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jakarta.inject.Named;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tin-ast
 */
public class DefaultAddEmployeeSubmitListener implements AddEmployeeSubmitListener{
    @Inject
    private EmployeeManagement_Admin employeeManagement;
    @Inject
    private AddEmployee_Admin addEmployee;
    @Inject @Named(AddEmployeeName.E_NAME)
    private Document emp_Name;
    @Inject @Named(AddEmployeeName.E_POSITION)
    private ComboBoxModel emp_Position;
    @Inject @Named(AddEmployeeName.E_SEX)
    private ComboBoxModel emp_Sex;
    @Inject @Named(AddEmployeeName.E_ADDRESS)
    private Document emp_Address;
    @Inject @Named(AddEmployeeName.E_DAYOFBIRTH)
    private Document emp_DayOfBirth;
    @Inject @Named(AddEmployeeName.E_PHONENUMBER)
    private Document emp_PhoneNumber;
    @Inject @Named(AddEmployeeName.E_USERNAME)
    private Document emp_Username;
    @Inject @Named(AddEmployeeName.E_PASSWORD)
    private Document emp_Password;
    @Inject
    private DatabaseContext databaseContext;
    @Inject 
    private Provider<ShowEmployeeWorker> showEmployeeWorkerProvider;
    @Inject
    private EmployeeService employeeService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            String name = DocumentUtil.getText(emp_Name);
            String position = emp_Position.getSelectedItem().toString();
            String sex = emp_Sex.getSelectedItem().toString();
            String address = DocumentUtil.getText(emp_Address);
            String dateOfBirth = DocumentUtil.getText(emp_DayOfBirth);
            String phone = DocumentUtil.getText(emp_PhoneNumber);
            String username = DocumentUtil.getText(emp_Username);
            String password = DocumentUtil.getText(emp_Password);
            if (
                name.isEmpty() || address.isEmpty() || dateOfBirth.isEmpty() ||
                        phone.isEmpty() || username.isEmpty() || password.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                employeeService.addEmployee(name, position, dateOfBirth, sex, address, phone, username, password);
                employeeManagement.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(emp_Name);
            DocumentUtil.removeText(emp_Address);
            DocumentUtil.removeText(emp_DayOfBirth);
            DocumentUtil.removeText(emp_PhoneNumber);
            DocumentUtil.removeText(emp_Username);
            DocumentUtil.removeText(emp_Password);
            addEmployee.setVisible(false);
            try {
                if (get()) {
                    showEmployeeWorkerProvider.get().refreshTable(employeeService.getListEmployee());
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Worker().execute();
    }
}
