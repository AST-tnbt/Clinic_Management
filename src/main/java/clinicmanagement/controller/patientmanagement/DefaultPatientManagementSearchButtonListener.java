package clinicmanagement.controller.patientmanagement;

import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker;
import clinicmanagement.model.entity.Patient;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultPatientManagementSearchButtonListener implements PatientManagementSearchButtonListener {
    @Inject @Named(PatientManagementName.PATIENT_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private PatientService patientService;
    @Inject
    private Provider<ShowPatientWorker> showPatientWorkerProvider;

    @Override
    public void actionPerformed(ActionEvent e) {
        String patient_name = DocumentUtil.getText(searchInput);
        ArrayList<Patient> listPatient = patientService.getListPatient();
        ArrayList<Patient> listPatientFilter = new ArrayList<>();
        for (Patient patient : listPatient) {
            if (patient.getName().toLowerCase().contains(patient_name.toLowerCase().trim())) {
                listPatientFilter.add(patient);
            }
        }
        showPatientWorkerProvider.get().refreshTable(listPatientFilter);
    }
}
