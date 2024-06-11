package clinicmanagement.controller.addmedicalrecord;

import clinicmanagement.constant.LoginName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddPrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class DefaultAddMedicalRecordAddPrescriptionListener implements AddMedicalRecordAddPrescriptionListener {
    @Inject
    private AddPrescriptionManagement_Admin prescriptionManagementAdmin;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject @Named(LoginName.USERNAME)
    private Document username;
    @Inject
    private PatientService patientService;
    @Inject
    private EmployeeService employeeService;
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;

    @Override
    public void actionPerformed(ActionEvent e) {
        prescriptionManagementAdmin.setVisible(true);
        String user = DocumentUtil.getText(username);
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        int patientId = Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(rows[0], 0)) ;
        try {
            patientService.setDoctorIdById(patientId, employeeService.getIdByUsername(user));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
    }
}
