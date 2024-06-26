package clinicmanagement.controller.patientmanagement.admin;

import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.controller.patientmanagement.admin.worker.ShowPatientWorker;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultPatientManagementSearchBarKeyPress extends KeyAdapter implements PatientManagementSearchBarKeyPress {
    @Inject @Named(PatientManagementName.PATIENT_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowPatientWorker> showPatientWorkerProvider;
    @Inject
    private PatientService patientService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).equals("")) {
            showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
        }
    }
}
