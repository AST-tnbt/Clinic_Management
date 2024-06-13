package clinicmanagement.controller.patientmanagement.doctor;

import clinicmanagement.view.doctor.Dashboard_Doctor;
import clinicmanagement.view.doctor.PatientManagement_Doctor;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDoctorPatientManagementBackDashboard extends MouseAdapter implements DoctorPatientManagementBackDashboard {
    @Inject
    Dashboard_Doctor dashboard;
    @Inject
    PatientManagement_Doctor patientManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        patientManagement.setVisible(false);
    }
}
