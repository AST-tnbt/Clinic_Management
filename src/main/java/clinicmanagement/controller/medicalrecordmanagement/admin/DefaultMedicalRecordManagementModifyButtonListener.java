/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medicalrecordmanagement.admin;

import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.admin.ModifyMedicalRecordName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.PrescriptionDetail;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyMedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tin-ast
 */
public class DefaultMedicalRecordManagementModifyButtonListener extends MouseAdapter implements MedicalRecordManagementModifyButtonListener {
    @Inject
    private ModifyMedicalRecord_Admin modifyMedicalRecordAdmin;
    @Inject @Named(ModifyMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(ModifyMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(ModifyMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject @Named(ModifyMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Inject @Named(ModifyMedicalRecordName.P_AMOUNT)
    private Document inputAmount;
    @Inject @Named(ModifyMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(ModifyMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject @Named(ModifyMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapperPatient;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapperPatient;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private MedicineService medicineService;

    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh án để chỉnh sửa.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 bệnh án.");
        }
        else {
            modifyMedicalRecordAdmin.setVisible(true);
            int medicalRecordId = Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(rows[0], 0));
            try {
                DocumentUtil.removeText(this.inputName);
                DocumentUtil.removeText(this.inputDateOfBirth);
                DocumentUtil.removeText(this.inputAppointmentDate);
                DocumentUtil.removeText(this.inputDiagnosis);
                DocumentUtil.removeText(this.inputRoom);
                DocumentUtil.removeText(this.prescription);

                inputName.insertString(0, (String) tableModelWrapperPatient.getModel().getValueAt(rows[0], 1), null);
                inputDateOfBirth.insertString(0, (String) tableModelWrapperPatient.getModel().getValueAt(rows[0], 2), null);
                inputSex.setSelectedItem(tableModelWrapperPatient.getModel().getValueAt(rows[0], 3));
                inputAppointmentDate.insertString(0, LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy")), null);
                inputDiagnosis.insertString(0, medicalRecordService.getDiagnosisById(medicalRecordId), null);
                inputRoom.insertString(0, medicalRecordService.getRoomById(medicalRecordId), null);
                inputStatus.setSelectedItem(medicalRecordService.getStatusById(medicalRecordId));
                for (PrescriptionDetail prescriptionDetail : prescriptionDetailService.getListPrescriptionDetailByPrescriptionId(medicalRecordService.getPrescriptionIdById(medicalRecordId))) {
                    prescription.insertString(prescription.getLength(), medicineService.getNameById(prescriptionDetail.getMedicineId()) + " : " + prescriptionDetail.getAmount() + "\n", null );
                }
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
