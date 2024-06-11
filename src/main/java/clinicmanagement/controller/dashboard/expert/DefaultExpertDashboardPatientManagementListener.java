package clinicmanagement.controller.dashboard.expert;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.PatientManagement_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Singleton
public class DefaultExpertDashboardPatientManagementListener extends MouseAdapter implements ExpertDashboardPatientManagementListener {
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
