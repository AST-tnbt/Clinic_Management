package clinicmanagement.controller.patientmanagement.expert;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.PatientManagement_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultExpertPatientManagementBackDashboard extends MouseAdapter implements ExpertPatientManagementBackDashboard {
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
