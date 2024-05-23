/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifypatient;

import clinicmanagement.constant.ModifyPatientName;
import clinicmanagement.constant.ModifyPatientName_Expert;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.ModifyPatient_Expert;
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
public class DefaultModifyPatientCancelListener_Expert implements ModifyPatientCancelListener_Expert {
    @Inject
    private ModifyPatient_Expert modifyPatientAdmin;
    @Inject @Named(ModifyPatientName_Expert.P_ID)
    private Document patient_ID;
    @Inject @Named(ModifyPatientName_Expert.P_NAME)
    private Document patient_Name;
    @Inject @Named(ModifyPatientName_Expert.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(ModifyPatientName_Expert.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(ModifyPatientName_Expert.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(ModifyPatientName_Expert.P_PHONENUMBER)
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
