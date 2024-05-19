package clinicmanagement.controller.roommanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultRoomManagementSearchButtonListener.class)
public interface RoomManagementSearchButtonListener extends ActionListener {}
