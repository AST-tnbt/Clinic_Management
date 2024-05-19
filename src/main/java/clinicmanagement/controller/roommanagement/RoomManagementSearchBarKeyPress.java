package clinicmanagement.controller.roommanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultRoomManagementSearchBarKeyPress.class)
public interface RoomManagementSearchBarKeyPress extends KeyListener {}
