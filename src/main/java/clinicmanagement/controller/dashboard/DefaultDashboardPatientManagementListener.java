package clinicmanagement.controller.dashboard;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Singleton
public class DefaultDashboardPatientManagementListener extends MouseAdapter implements DashboardPatientManagementListener {
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    PatientManagement_Admin patientManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(false);
        patientManagement.setVisible(true);
    }
}
