/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifytool;

import clinicmanagement.constant.ModifyRoomName;
import clinicmanagement.constant.ModifyToolName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyRoom_Admin;
import clinicmanagement.view.manager.ModifyTool_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyToolCancelListener implements ModifyToolCancelListener {
    @Inject
    private ModifyTool_Admin modifyToolAdmin;
    @Inject @Named(ModifyToolName.T_NAME)
    private Document t_name;
    @Inject @Named(ModifyToolName.T_ID)
    private Document t_id;
    @Inject @Named(ModifyToolName.T_ROOM)
    private Document t_room;
    @Inject @Named(ModifyToolName.T_IMPORTDATE)
    private Document t_importDate;
    @Inject @Named(ModifyToolName.T_EXPIREDATE)
    private Document t_expireDate;

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.t_id);
        DocumentUtil.removeText(this.t_importDate);
        DocumentUtil.removeText(this.t_expireDate);
        DocumentUtil.removeText(this.t_name);
        DocumentUtil.removeText(this.t_room);
        this.modifyToolAdmin.setVisible(false);
    }
}
