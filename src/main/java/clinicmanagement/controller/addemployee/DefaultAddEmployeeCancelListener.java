/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addemployee;

import clinicmanagement.constant.AddEmployeeName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddEmployee_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;
import java.awt.event.ActionEvent;
import javax.swing.ComboBoxModel;
import javax.swing.text.Document;

/**
 *
 * @author tin-ast
 */
public class DefaultAddEmployeeCancelListener implements AddEmployeeCancelListener{
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
    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.print(SwingUtilities.isEventDispatchThread());
        DocumentUtil.removeText(this.emp_Name);
        DocumentUtil.removeText(this.emp_Address);
        DocumentUtil.removeText(this.emp_DayOfBirth);
        DocumentUtil.removeText(this.emp_PhoneNumber);
        DocumentUtil.removeText(this.emp_Username);
        DocumentUtil.removeText(this.emp_Password);
        this.addEmployee.setVisible(false);
    }
}
