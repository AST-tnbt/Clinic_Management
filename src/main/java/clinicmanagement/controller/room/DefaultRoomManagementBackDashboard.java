package clinicmanagement.controller.room;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import clinicmanagement.view.manager.RoomManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultRoomManagementBackDashboard extends MouseAdapter implements RoomManagementBackDashboard {
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    RoomManagement_Admin roomManagementAdmin;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        roomManagementAdmin.setVisible(false);
    }
}
