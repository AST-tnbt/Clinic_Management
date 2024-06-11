/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medicalrecordmanagement;

import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.controller.medicalrecordmanagement.worker.ShowMedicalRecordWorker;
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
public class DefaultMedicalRecordManagementShowMedicalRecord extends ComponentAdapter implements MedicalRecordManagementShowMedicalRecord {
    @Inject
    private Provider<ShowMedicalRecordWorker> showMedicalRecordWorkerProvider;
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject @Named(MedicalRecordManagementName.MEDICAL_RECORD_NAME)
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
