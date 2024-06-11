package clinicmanagement.controller.dashboard.admin;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.ToolManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDashboardToolListener extends MouseAdapter implements DashboardToolListener {
    @Inject
    ToolManagement_Admin toolManagementAdmin;
    @Inject
    Dashboard_Admin dashboardAdmin;
    @Override
    public void mouseClicked(MouseEvent e) {
        dashboardAdmin.setVisible(false);
        toolManagementAdmin.setVisible(true);
    }
}
