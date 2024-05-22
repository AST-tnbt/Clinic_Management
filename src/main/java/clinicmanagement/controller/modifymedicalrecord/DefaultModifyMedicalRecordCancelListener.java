/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicalrecord;

import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.MedicalRecord_Admin;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import clinicmanagement.view.manager.ModifyMedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyMedicalRecordCancelListener implements ModifyMedicalRecordCancelListener {
    @Inject @Named(ModifyMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(ModifyMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject @Named(ModifyMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject @Named(ModifyMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject @Named(ModifyMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(ModifyMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(ModifyMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION)
    private Document prescription;
    @Inject @Named(ModifyMedicalRecordName.P_AMOUNT)
    private Document inputAmount;
    @Inject
    private ModifyMedicalRecord_Admin modifyMedicalRecordAdmin;
    @Inject
    private MedicalRecord_Admin medicalRecordAdmin;
    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.inputName);
        DocumentUtil.removeText(this.inputDateOfBirth);
        DocumentUtil.removeText(this.inputDiagnosis);
        DocumentUtil.removeText(this.inputRoom);
        DocumentUtil.removeText(this.inputAmount);
        DocumentUtil.removeText(this.prescription);
        DocumentUtil.removeText(this.inputAppointmentDate);
        this.modifyMedicalRecordAdmin.setVisible(false);
        this.medicalRecordAdmin.setVisible(true);
    }
}
