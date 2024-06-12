/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifypatient.expert;

import clinicmanagement.constant.admin.ModifyPatientName;
import clinicmanagement.constant.expert.ExpertModifyPatientName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.ModifyPatient_Expert;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultExpertModifyPatientCancelListener implements ExpertModifyPatientCancelListener {
    @Inject
    private ModifyPatient_Expert modifyPatientExpert;
    @Inject @Named(ExpertModifyPatientName.P_ID)
    private Document patient_ID;
    @Inject @Named(ExpertModifyPatientName.P_NAME)
    private Document patient_Name;
    @Inject @Named(ExpertModifyPatientName.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(ExpertModifyPatientName.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(ExpertModifyPatientName.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(ExpertModifyPatientName.P_PHONENUMBER)
    private Document patient_PhoneNumber;
    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.patient_ID);
        DocumentUtil.removeText(this.patient_Name);
        DocumentUtil.removeText(this.patient_Address);
        DocumentUtil.removeText(this.patient_DayOfBirth);
        DocumentUtil.removeText(this.patient_PhoneNumber);
        this.modifyPatientExpert.setVisible(false);
    }
}
