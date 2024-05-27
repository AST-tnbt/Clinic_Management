/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addmedicalrecord;

import clinicmanagement.constant.AddMedicalRecordName;
import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.PrescriptionDetail;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddMedicalRecord_Admin;
import clinicmanagement.view.manager.MedicalRecord_Admin;
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
public class DefaultAddMedicalRecordCancelListener implements AddMedicalRecordCancelListener {
    @Inject @Named(AddMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(AddMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject @Named(AddMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject @Named(AddMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject @Named(AddMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(AddMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(AddMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private AddMedicalRecord_Admin addMedicalRecordAdmin;
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
