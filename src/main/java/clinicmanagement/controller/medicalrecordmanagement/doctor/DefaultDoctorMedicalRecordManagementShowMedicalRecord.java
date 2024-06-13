/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medicalrecordmanagement.doctor;

import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.doctor.DoctorMedicalRecordManagementName;
import clinicmanagement.constant.doctor.DoctorPatientManagementName;
import clinicmanagement.controller.medicalrecordmanagement.doctor.worker.DoctorShowMedicalRecordWorker;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 *
 * @author tin-ast
 */
public class DefaultDoctorMedicalRecordManagementShowMedicalRecord extends ComponentAdapter implements DoctorMedicalRecordManagementShowMedicalRecord {
    @Inject
    private Provider<DoctorShowMedicalRecordWorker> showMedicalRecordWorkerProvider;
    @Inject @Named(DoctorPatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(DoctorPatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_NAME)
    private Document name;

    @Override
    public void componentShown(ComponentEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        DocumentUtil.removeText(name);
        showMedicalRecordWorkerProvider.get().refreshTable(medicalRecordService.getListMedicalRecordByPatientId(Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(rows[0], 0))));
        try {
            name.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1), null);
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
