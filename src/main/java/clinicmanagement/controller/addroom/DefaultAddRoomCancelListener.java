/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addroom;

import clinicmanagement.constant.admin.AddRoomName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddRoom_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultAddRoomCancelListener implements AddRoomCancelListener {
    @Inject
    private AddRoom_Admin addRoom;
    @Inject @Named(AddRoomName.R_NAME)
    private Document room_Name;
    @Inject @Named(AddRoomName.R_CAPACITY)
    private Document room_Capacity;
    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.room_Name);
        DocumentUtil.removeText(this.room_Capacity);
        this.addRoom.setVisible(false);
    }
}
