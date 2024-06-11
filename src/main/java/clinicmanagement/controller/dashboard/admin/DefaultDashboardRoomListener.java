package clinicmanagement.controller.dashboard.admin;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.RoomManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDashboardRoomListener extends MouseAdapter implements DashboardRoomListener {
    @Inject
    private Dashboard_Admin dashboard;
    @Inject
    private RoomManagement_Admin room;

    @Override
    public void mouseClicked(MouseEvent e) {
        this.dashboard.setVisible(false);
        this.room.setVisible(true);
    }
}
