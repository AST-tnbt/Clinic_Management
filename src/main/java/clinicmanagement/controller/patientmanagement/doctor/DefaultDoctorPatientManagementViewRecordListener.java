package clinicmanagement.controller.patientmanagement.doctor;

import clinicmanagement.constant.admin.AddMedicalRecordName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.doctor.DoctorAddMedicalRecordName;
import clinicmanagement.constant.doctor.DoctorPatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.doctor.MedicalRecordManagement_Doctor;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDoctorPatientManagementViewRecordListener extends MouseAdapter implements DoctorPatientManagementViewRecordListener {
    @Inject
    private MedicalRecordManagement_Doctor medicalRecordManagementDoctor;
    @Inject @Named((DoctorPatientManagementName.PATIENT_TABLE))
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(DoctorPatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(DoctorAddMedicalRecordName.P_ID)
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
            medicalRecordManagementDoctor.setVisible(true);
        }
    }
}
