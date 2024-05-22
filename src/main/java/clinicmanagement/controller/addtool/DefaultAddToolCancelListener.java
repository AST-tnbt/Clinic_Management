/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addtool;

import clinicmanagement.constant.AddRoomName;
import clinicmanagement.constant.AddToolName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddRoom_Admin;
import clinicmanagement.view.manager.AddTool_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultAddToolCancelListener implements AddToolCancelListener {
    @Inject
    private AddTool_Admin addToolAdmin;
    @Inject @Named(AddToolName.T_NAME)
    private Document name;
    @Inject @Named(AddToolName.T_ROOM)
    private Document room;
    @Inject @Named(AddToolName.T_IMPORTDATE)
    private Document importDate;
    @Inject @Named(AddToolName.T_EXPIREDATE)
    private Document expireDate;

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.name);
        DocumentUtil.removeText(this.importDate);
        DocumentUtil.removeText(this.expireDate);
        DocumentUtil.removeText(this.room);
        this.addToolAdmin.setVisible(false);
    }
}
