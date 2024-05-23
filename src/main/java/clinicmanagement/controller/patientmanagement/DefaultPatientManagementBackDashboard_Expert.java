package clinicmanagement.controller.patientmanagement;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.PatientManagement_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultPatientManagementBackDashboard_Expert extends MouseAdapter implements PatientManagementBackDashboard_Expert {
    @Inject
    Dashboard_Expert dashboard;
    @Inject
    PatientManagement_Expert patientManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        patientManagement.setVisible(false);
    }
}
