/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifyroom;

import clinicmanagement.constant.admin.ModifyRoomName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyRoom_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyRoomCancelListener implements ModifyRoomCancelListener {
    @Inject
    private ModifyRoom_Admin modifyRoomAdmin;
    @Inject @Named(ModifyRoomName.R_ID)
    private Document r_ID;
    @Inject @Named(ModifyRoomName.R_NAME)
    private Document r_Name;
    @Inject @Named(ModifyRoomName.R_CAPACITY)
    private Document r_Capacity;

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.r_ID);
        DocumentUtil.removeText(this.r_Name);
        DocumentUtil.removeText(this.r_Capacity);
        this.modifyRoomAdmin.setVisible(false);
    }
}
