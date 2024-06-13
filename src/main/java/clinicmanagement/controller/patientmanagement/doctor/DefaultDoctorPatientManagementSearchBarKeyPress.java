package clinicmanagement.controller.patientmanagement.doctor;

import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.doctor.DoctorPatientManagementName;
import clinicmanagement.controller.patientmanagement.admin.worker.ShowPatientWorker;
import clinicmanagement.controller.patientmanagement.doctor.worker.DoctorShowPatientWorker;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultDoctorPatientManagementSearchBarKeyPress extends KeyAdapter implements DoctorPatientManagementSearchBarKeyPress {
    @Inject @Named(DoctorPatientManagementName.PATIENT_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<DoctorShowPatientWorker> showPatientWorkerProvider;
    @Inject
    private PatientService patientService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).isEmpty()) {
            showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
        }
    }
}
