/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.roommanagement;

import clinicmanagement.view.manager.AddRoom_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultRoomManagementAddButtonListener extends MouseAdapter implements RoomManagementAddButtonListener {
    @Inject
    private AddRoom_Admin addRoom;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addRoom.setVisible(true);
    }
}
