package clinicmanagement.controller.patientmanagement;

import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.constant.PatientManagementName_Expert;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker_Expert;
import clinicmanagement.model.entity.Patient;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultPatientManagementSearchButtonListener_Expert implements PatientManagementSearchButtonListener_Expert {
    @Inject @Named(PatientManagementName_Expert.PATIENT_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private PatientService patientService;
    @Inject
    private Provider<ShowPatientWorker_Expert> showPatientWorkerProvider;

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