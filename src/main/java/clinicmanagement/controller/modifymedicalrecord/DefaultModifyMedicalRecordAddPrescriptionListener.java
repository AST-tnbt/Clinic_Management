package clinicmanagement.controller.modifymedicalrecord;

import clinicmanagement.constant.LoginName;
import clinicmanagement.constant.MedicalRecordManagementName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyPrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class DefaultModifyMedicalRecordAddPrescriptionListener implements ModifyMedicalRecordAddPrescriptionListener {
    @Inject
    private ModifyPrescriptionManagement_Admin modifyPrescriptionManagementAdmin;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject @Named(LoginName.USERNAME)
    private Document username;
    @Inject
    private EmployeeService employeeService;
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE)
    private TableModelWrapper medicalRecorTableModelWrapper;
    @Inject @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper medicalRecorTableListModelSelectionWrapper;
    @Inject
    private PatientService patientService;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private InvoiceService invoiceService;

    @Override
    public void actionPerformed(ActionEvent e) {
        int []medicalRecordRows = medicalRecorTableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        int medicalRecordId = Integer.parseInt((String) medicalRecorTableModelWrapper.getModel().getValueAt(medicalRecordRows[0], 0));
        int prescriptionId = medicalRecordService.getPrescriptionIdById(medicalRecordId);
        modifyPrescriptionManagementAdmin.setVisible(true);
        String user = DocumentUtil.getText(username);
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        int patientId = Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(rows[0], 0)) ;
        try {
            invoiceService.deleteByPrescriptionId(medicalRecordId);
            prescriptionDetailService.deleteByPrescriptionId(prescriptionId);
            patientService.setDoctorIdById(patientId, employeeService.getIdByUsername(user));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
    }
}
