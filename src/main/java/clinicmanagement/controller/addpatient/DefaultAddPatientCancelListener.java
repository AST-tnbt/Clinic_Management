/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addpatient;

import clinicmanagement.constant.admin.AddPatientName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddPatient_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultAddPatientCancelListener implements AddPatientCancelListener {
    @Inject
    private AddPatient_Admin addPatient;
    @Inject @Named(AddPatientName.P_NAME)
    private Document patient_Name;
    @Inject @Named(AddPatientName.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(AddPatientName.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(AddPatientName.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(AddPatientName.P_PHONENUMBER)
    private Document patient_PhoneNumber;

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.patient_Name);
        DocumentUtil.removeText(this.patient_Address);
        DocumentUtil.removeText(this.patient_DayOfBirth);
        DocumentUtil.removeText(this.patient_PhoneNumber);
        this.addPatient.setVisible(false);
    }
}
