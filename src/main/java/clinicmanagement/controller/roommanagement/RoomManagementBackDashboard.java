package clinicmanagement.controller.roommanagement;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultRoomManagementBackDashboard.class)
public interface RoomManagementBackDashboard extends MouseListener {
}
