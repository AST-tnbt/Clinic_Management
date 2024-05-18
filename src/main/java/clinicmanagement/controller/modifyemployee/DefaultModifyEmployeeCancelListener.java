/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifyemployee;

import clinicmanagement.constant.AddEmployeeName;
import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddEmployee_Admin;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyEmployeeCancelListener implements ModifyEmployeeCancelListener {
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
    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.emp_ID);
        DocumentUtil.removeText(this.emp_Name);
        DocumentUtil.removeText(this.emp_Address);
        DocumentUtil.removeText(this.emp_DayOfBirth);
        DocumentUtil.removeText(this.emp_PhoneNumber);
        DocumentUtil.removeText(this.emp_Username);
        DocumentUtil.removeText(this.emp_Password);
        this.modifyEmployeeAdmin.setVisible(false);
    }
}
