package clinicmanagement.controller.toolmanagement;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.RoomManagement_Admin;
import clinicmanagement.view.manager.ToolManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultToolManagementBackDashboard extends MouseAdapter implements ToolManagementBackDashboard {
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    ToolManagement_Admin toolManagementAdmin;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        toolManagementAdmin.setVisible(false);
    }
}
