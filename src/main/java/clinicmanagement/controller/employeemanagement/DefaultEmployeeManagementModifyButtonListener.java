package clinicmanagement.controller.employeemanagement;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultEmployeeManagementModifyButtonListener extends MouseAdapter implements EmployeeManagementModifyButtonListener {
    @Inject
    ModifyEmployee_Admin modifyEmployeeAdmin;
    @Inject @Named(EmployeeManagementName.EMPLOYEE_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(EmployeeManagementName.EMPLOYEE_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
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
    EmployeeService employeeService;

    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để chỉnh sửa.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhân viên.");
        }
        else {
            modifyEmployeeAdmin.setVisible(true);
            try {
                emp_ID.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 0), null);
                emp_Name.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1), null);
                emp_Position.setSelectedItem(tableModelWrapper.getModel().getValueAt(rows[0], 2));
                emp_Sex.setSelectedItem(tableModelWrapper.getModel().getValueAt(rows[0], 4));
                emp_DayOfBirth.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 3), null);
                emp_PhoneNumber.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 6), null);
                emp_Address.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 5), null);
                emp_Username.insertString(0, employeeService.getUserNameById((String) tableModelWrapper.getModel().getValueAt(rows[0], 0)), null);
                emp_Password.insertString(0, employeeService.getPasswordById((String) tableModelWrapper.getModel().getValueAt(rows[0], 0)), null);
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
