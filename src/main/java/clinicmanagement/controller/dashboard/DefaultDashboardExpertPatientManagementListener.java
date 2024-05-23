package clinicmanagement.controller.dashboard;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.PatientManagement_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Singleton
public class DefaultDashboardExpertPatientManagementListener extends MouseAdapter implements DashboardExpertPatientManagementListener {
    @Inject
    Dashboard_Expert dashboard;
    @Inject
    PatientManagement_Expert patientManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(false);
        patientManagement.setVisible(true);
    }
}
