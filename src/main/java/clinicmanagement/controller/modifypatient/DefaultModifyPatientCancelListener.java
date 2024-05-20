/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifypatient;

import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.constant.ModifyPatientName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import clinicmanagement.view.manager.ModifyPatient_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyPatientCancelListener implements ModifyPatientCancelListener {
    @Inject
    private ModifyPatient_Admin modifyPatientAdmin;
    @Inject @Named(ModifyPatientName.P_ID)
    private Document patient_ID;
    @Inject @Named(ModifyPatientName.P_NAME)
    private Document patient_Name;
    @Inject @Named(ModifyPatientName.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(ModifyPatientName.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(ModifyPatientName.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(ModifyPatientName.P_PHONENUMBER)
    private Document patient_PhoneNumber;
    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.patient_ID);
        DocumentUtil.removeText(this.patient_Name);
        DocumentUtil.removeText(this.patient_Address);
        DocumentUtil.removeText(this.patient_DayOfBirth);
        DocumentUtil.removeText(this.patient_PhoneNumber);
        this.modifyPatientAdmin.setVisible(false);
    }
}
