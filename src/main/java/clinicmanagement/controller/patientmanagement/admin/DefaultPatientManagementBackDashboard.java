package clinicmanagement.controller.patientmanagement.admin;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultPatientManagementBackDashboard extends MouseAdapter implements PatientManagementBackDashboard {
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    PatientManagement_Admin patientManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        patientManagement.setVisible(false);
    }
}
