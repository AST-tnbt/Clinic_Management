package clinicmanagement.controller.patientmanagement;

import clinicmanagement.constant.AddMedicalRecordName;
import clinicmanagement.constant.MedicalRecordManagementName;
import clinicmanagement.constant.MedicalRecordName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.MedicalRecordManagement_Admin;
import clinicmanagement.view.manager.MedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DefaultPatientManagementViewRecordListener extends MouseAdapter implements PatientManagementViewRecordListener {
    @Inject
    private MedicalRecordManagement_Admin medicalRecordManagementAdmin;
    @Inject @Named((PatientManagementName.PATIENT_TABLE))
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(AddMedicalRecordName.P_ID)
    private Document patientId;

    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 bệnh nhân.");
        }
        else {
            DocumentUtil.removeText(patientId);
            try {
                patientId.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 0), null);
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
            medicalRecordManagementAdmin.setVisible(true);
        }
    }
}
