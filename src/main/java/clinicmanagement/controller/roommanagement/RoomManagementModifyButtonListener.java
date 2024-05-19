package clinicmanagement.controller.roommanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultRoomManagementModifyButtonListener.class)
public interface RoomManagementModifyButtonListener extends MouseListener {}
