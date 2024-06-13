package clinicmanagement.controller.dashboard.doctor;

import clinicmanagement.view.doctor.Dashboard_Doctor;
import clinicmanagement.view.doctor.PatientManagement_Doctor;
import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.PatientManagement_Expert;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Singleton
public class DefaultDoctorDashboardPatientManagementListener extends MouseAdapter implements DoctorDashboardPatientManagementListener {
    @Inject
    Dashboard_Doctor dashboard;
    @Inject
    PatientManagement_Doctor patientManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(false);
        patientManagement.setVisible(true);
    }
}
