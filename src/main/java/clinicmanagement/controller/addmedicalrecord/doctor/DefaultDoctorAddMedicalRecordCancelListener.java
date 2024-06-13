/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addmedicalrecord.doctor;

import clinicmanagement.constant.admin.AddMedicalRecordName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.doctor.DoctorAddMedicalRecordName;
import clinicmanagement.constant.doctor.DoctorPatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.PrescriptionDetail;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.doctor.AddMedicalRecord_Doctor;
import clinicmanagement.view.manager.AddMedicalRecord_Admin;
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
public class DefaultDoctorAddMedicalRecordCancelListener implements DoctorAddMedicalRecordCancelListener {
    @Inject @Named(DoctorAddMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(DoctorAddMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Inject @Named(DoctorAddMedicalRecordName.P_PRESCRIPTION)
    private Document m_prescription;
    @Inject @Named(DoctorAddMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject @Named(DoctorAddMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject @Named(DoctorAddMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject @Named(DoctorAddMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(DoctorAddMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(DoctorAddMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject @Named(DoctorPatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(DoctorPatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private AddMedicalRecord_Doctor addMedicalRecordAdmin;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private PatientService patientService;
    @Inject
    private MedicineService medicineService;



    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.inputName);
        DocumentUtil.removeText(this.inputDateOfBirth);
        DocumentUtil.removeText(this.inputDiagnosis);
        DocumentUtil.removeText(this.inputRoom);
        DocumentUtil.removeText(this.inputAppointmentDate);
        DocumentUtil.removeText(this.m_prescription);
        DocumentUtil.removeText(this.prescription);
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        int patientId = Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(rows[0], 0)) ;
        try {
            for (PrescriptionDetail prescription_tmp : prescriptionDetailService.getListPrescriptionDetail()) {
                if (prescription_tmp.getPrescriptionId() == prescriptionService.getLastId()) {
                    medicineService.increaseAmountById(prescription_tmp.getMedicineId(), prescription_tmp.getAmount());
                }
            }
            prescriptionDetailService.deleteByPrescriptionId(prescriptionService.getLastId());
            prescriptionService.deleteLastItem();
            patientService.setDoctorIdById(patientId, 0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
        this.addMedicalRecordAdmin.setVisible(false);
    }
}
