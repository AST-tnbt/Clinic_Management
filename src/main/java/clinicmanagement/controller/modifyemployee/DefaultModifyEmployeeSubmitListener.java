/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifyemployee;

import clinicmanagement.constant.AddEmployeeName;
import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddEmployee_Admin;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
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
public class DefaultModifyEmployeeSubmitListener implements ModifyEmployeeSubmitListener {
    @Inject
    private EmployeeManagement_Admin employeeManagement;
    @Inject
    private ModifyEmployee_Admin modifyEmployeeAdmin;
    @Inject @Named(ModifyEmployeeName.E_ID)
    private Document emp_ID;
    @Inject @Named(ModifyEmployeeName.E_NAME)
    private Document emp_Name;
    @Inject @Named(ModifyEmployeeName.E_POSITION)
    private ComboBoxModel emp_Position;
    @Inject @Named(ModifyEmployeeName.E_SEX)
    private ComboBoxModel emp_Sex;
    @Inject @Named(ModifyEmployeeName.E_ADDRESS)
    private Document emp_Address;
    @Inject @Named(ModifyEmployeeName.E_DAYOFBIRTH)
    private Document emp_DayOfBirth;
    @Inject @Named(ModifyEmployeeName.E_PHONENUMBER)
    private Document emp_PhoneNumber;
    @Inject @Named(ModifyEmployeeName.E_USERNAME)
    private Document emp_Username;
    @Inject @Named(ModifyEmployeeName.E_PASSWORD)
    private Document emp_Password;
    @Inject 
    private Provider<ShowEmployeeWorker> showEmployeeWorkerProvider;
    @Inject
    private EmployeeService employeeService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            int id = Integer.parseInt(DocumentUtil.getText(emp_ID));
            String name = DocumentUtil.getText(emp_Name);
            String position = emp_Position.getSelectedItem().toString();
            String sex = emp_Sex.getSelectedItem().toString();
            String address = DocumentUtil.getText(emp_Address);
            String dateOfBirth = DocumentUtil.getText(emp_DayOfBirth);
            String phone = DocumentUtil.getText(emp_PhoneNumber);
            String username = DocumentUtil.getText(emp_Username);
            String password = DocumentUtil.getText(emp_Password);
            if (
                name.equals("") ||
                address.equals("") || dateOfBirth.equals("") ||
                phone.equals("") || username.equals("") || password.equals("")
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                employeeService.modifyEmployee(id, name, phone, position, dateOfBirth, sex, username, password,  address);
                modifyEmployeeAdmin.setVisible(false);
            } catch (SQLException ex) {
//                Logger.getLogger(DefaultAddEmployeeSubmitListener.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(emp_ID);
            DocumentUtil.removeText(emp_Name);
            DocumentUtil.removeText(emp_Address);
            DocumentUtil.removeText(emp_DayOfBirth);
            DocumentUtil.removeText(emp_PhoneNumber);
            DocumentUtil.removeText(emp_Username);
            DocumentUtil.removeText(emp_Password);
            modifyEmployeeAdmin.setVisible(false);
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    showEmployeeWorkerProvider.get().refreshTable(employeeService.getListEmployee());
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
