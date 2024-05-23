package clinicmanagement.controller.patientmanagement;

import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.constant.PatientManagementName_Expert;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker_Expert;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultPatientManagementSearchBarKeyPress_Expert extends KeyAdapter implements PatientManagementSearchBarKeyPress_Expert {
    @Inject @Named(PatientManagementName_Expert.PATIENT_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowPatientWorker_Expert> showPatientWorkerProvider;
    @Inject
    private PatientService patientService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).equals("")) {
            showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
        }
    }
}
