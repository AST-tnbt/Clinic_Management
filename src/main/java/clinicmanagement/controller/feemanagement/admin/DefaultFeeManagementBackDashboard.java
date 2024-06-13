package clinicmanagement.controller.feemanagement.admin;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.FeeManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultFeeManagementBackDashboard extends MouseAdapter implements FeeManagementBackDashboard {
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    FeeManagement_Admin feeManagementAdmin;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        feeManagementAdmin.setVisible(false);
    }
}
