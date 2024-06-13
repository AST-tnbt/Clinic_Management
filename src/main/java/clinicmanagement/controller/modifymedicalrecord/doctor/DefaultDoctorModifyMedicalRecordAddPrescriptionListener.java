package clinicmanagement.controller.modifymedicalrecord.doctor;

import clinicmanagement.constant.LoginName;
import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.doctor.DoctorMedicalRecordManagementName;
import clinicmanagement.constant.doctor.DoctorPatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.doctor.ModifyPrescriptionManagement_Doctor;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class DefaultDoctorModifyMedicalRecordAddPrescriptionListener implements DoctorModifyMedicalRecordAddPrescriptionListener {
    @Inject
    private ModifyPrescriptionManagement_Doctor modifyPrescriptionManagementDoctor;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject @Named(LoginName.USERNAME)
    private Document username;
    @Inject
    private EmployeeService employeeService;
    @Inject @Named(DoctorPatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(DoctorPatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_TABLE)
    private TableModelWrapper medicalRecorTableModelWrapper;
    @Inject @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_TABLE_LIST_SELECTION)
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
        modifyPrescriptionManagementDoctor.setVisible(true);
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
