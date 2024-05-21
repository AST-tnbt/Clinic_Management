package clinicmanagement.controller.prescriptionmanagement;

import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.PrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class DefaultPrescriptionCancelListener implements PrescriptionCancelListener {
    @Inject
    private PrescriptionService prescriptionService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private PrescriptionManagement_Admin prescriptionManagementAdmin;
    @Inject @Named(ModifyMedicalRecordName.P_AMOUNT)
    private Document amount;
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(amount);
        DocumentUtil.removeText(prescription);
        prescriptionManagementAdmin.setVisible(false);
        try {
            prescriptionDetailService.deleteByPrescriptionId(prescriptionService.getListPrescription().size());
            prescriptionService.deleteLastItem();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
