package clinicmanagement.controller.patientManagement;

import clinicmanagement.constant.MedicalRecordName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.view.manager.MedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DefaultPatientManagementViewRecordListener extends MouseAdapter implements PatientManagementViewRecordListener {
    @Inject
    private MedicalRecord_Admin medicalRecord;
    @Inject @Named((PatientManagementName.PATIENT_TABLE))
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(MedicalRecordName.P_NAME)
    private Document name;
    @Inject @Named(MedicalRecordName.P_DATEOFBIRTH)
    private Document dateOfBirth;
    @Inject @Named(MedicalRecordName.P_SEX)
    private ComboBoxModel sex;
    @Inject @Named(MedicalRecordName.P_DIAGNOSIS)
    private Document diagnosis;
    @Inject @Named(MedicalRecordName.P_PRESCRIPTION)
    private Document prescription;
    @Inject @Named(MedicalRecordName.P_APPOINTMENTDATE)
    private Document appointmentDate;
    @Inject @Named(MedicalRecordName.P_STATUS)
    private ComboBoxModel status;
    @Inject @Named(MedicalRecordName.P_ROOM)
    private Document room;
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
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 bệnh nhân.");
        }
        else {
            medicalRecord.setVisible(true);
            int patientId = Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(rows[0], 0));
            int prescriptionId = medicalRecordService.getPrescriptionIdByPatientId(patientId);
            ArrayList<Integer> listMedicineId = prescriptionDetailService.getListMedicineIdByPrescriptionId(prescriptionId);
            ArrayList<Integer> listAmountOfMedicine = prescriptionDetailService.getListAmountByPrescriptionId(prescriptionId);
            try {
                name.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1),null);
                dateOfBirth.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 2),null);
                sex.setSelectedItem(tableModelWrapper.getModel().getValueAt(rows[0], 3));
                diagnosis.insertString(0, medicalRecordService.getDiagnosisByPatientId(patientId), null);
                for (int i = 0; i < listMedicineId.size(); i++) {
                    prescription.insertString(prescription.getLength(), medicineService.getNameById(listMedicineId.get(i)) + " : " + listAmountOfMedicine.get(i) + "\n" , null);
                }
                appointmentDate.insertString(0, medicalRecordService.getAppointmentDateByPatientId(patientId), null);
                status.setSelectedItem(medicalRecordService.getStatusByPatientId(patientId));
                room.insertString(0, medicalRecordService.getRoomByPatientId(patientId), null);
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
