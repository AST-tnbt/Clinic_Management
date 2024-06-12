package clinicmanagement.controller.patientmanagement.expert;

import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.expert.ExpertPatientManagementName;
import clinicmanagement.controller.patientmanagement.admin.worker.ShowPatientWorker;
import clinicmanagement.controller.patientmanagement.expert.worker.ExpertShowPatientWorker;
import clinicmanagement.model.entity.Patient;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultExpertPatientManagementSearchButtonListener implements ExpertPatientManagementSearchButtonListener {
    @Inject @Named(ExpertPatientManagementName.PATIENT_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private PatientService patientService;
    @Inject
    private Provider<ExpertShowPatientWorker> showPatientWorkerProvider;

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
