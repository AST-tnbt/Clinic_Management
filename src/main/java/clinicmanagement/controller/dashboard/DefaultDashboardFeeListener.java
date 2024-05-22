package clinicmanagement.controller.dashboard;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.FeeManagement_Admin;
import clinicmanagement.view.manager.ToolManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDashboardFeeListener extends MouseAdapter implements DashboardFeeListener {
    @Inject
    FeeManagement_Admin feeManagementAdmin;
    @Inject
    Dashboard_Admin dashboardAdmin;
    @Override
    public void mouseClicked(MouseEvent e) {
        dashboardAdmin.setVisible(false);
        feeManagementAdmin.setVisible(true);
    }
}
