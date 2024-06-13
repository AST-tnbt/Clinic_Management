/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicalrecord.doctor;

import clinicmanagement.constant.admin.AddMedicalRecordName;
import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.admin.ModifyMedicalRecordName;
import clinicmanagement.constant.doctor.DoctorAddMedicalRecordName;
import clinicmanagement.constant.doctor.DoctorMedicalRecordManagementName;
import clinicmanagement.constant.doctor.DoctorModifyMedicalRecordName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.doctor.ModifyMedicalRecord_Doctor;
import clinicmanagement.view.manager.ModifyMedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 *
 * @author tin-ast
 */
public class DefaultDoctorModifyMedicalRecordCancelListener implements DoctorModifyMedicalRecordCancelListener {
    @Inject @Named(DoctorModifyMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(DoctorModifyMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject @Named(DoctorModifyMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject @Named(DoctorModifyMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject @Named(DoctorModifyMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(DoctorModifyMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(DoctorAddMedicalRecordName.P_ID)
    private Document patientId;
    @Inject @Named(DoctorModifyMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject @Named(DoctorModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Inject @Named(DoctorModifyMedicalRecordName.P_AMOUNT)
    private Document inputAmount;
    @Inject
    private ModifyMedicalRecord_Doctor modifyMedicalRecordAdmin;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject
    private PatientService patientService;
    @Inject
    @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_TABLE)
    private TableModelWrapper medicalRecorTableModelWrapper;
    @Inject
    @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper medicalRecorTableListModelSelectionWrapper;

    @Override
    public void actionPerformed(ActionEvent e) {
        int []medicalRecordRows = medicalRecorTableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        int medicalRecordId = Integer.parseInt((String) medicalRecorTableModelWrapper.getModel().getValueAt(medicalRecordRows[0], 0));
        int p_Id = Integer.parseInt(DocumentUtil.getText(patientId));
        try {
            medicalRecordService.deleteById(medicalRecordId);
            patientService.setRoomById(p_Id, 0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
        DocumentUtil.removeText(this.inputName);
        DocumentUtil.removeText(this.inputDateOfBirth);
        DocumentUtil.removeText(this.inputDiagnosis);
        DocumentUtil.removeText(this.inputRoom);
        DocumentUtil.removeText(this.inputAmount);
        DocumentUtil.removeText(this.prescription);
        DocumentUtil.removeText(this.inputAppointmentDate);
        this.modifyMedicalRecordAdmin.setVisible(false);
    }
}
