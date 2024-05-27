package clinicmanagement.controller.modifymedicalrecord;

import clinicmanagement.constant.LoginName;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddPrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class DefaultModifyMedicalRecordAddPrescriptionListener implements ModifyMedicalRecordAddPrescriptionListener {
    @Inject
    private AddPrescriptionManagement_Admin prescriptionManagementAdmin;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject @Named(LoginName.USERNAME)
    private Document username;
    @Inject
    private EmployeeService employeeService;

    @Override
    public void actionPerformed(ActionEvent e) {
        prescriptionManagementAdmin.setVisible(true);
        String user = DocumentUtil.getText(username);
        try {
            prescriptionService.addPrescription();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
    }
}
