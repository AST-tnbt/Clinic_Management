/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifytool;

import clinicmanagement.constant.ModifyRoomName;
import clinicmanagement.constant.ModifyToolName;
import clinicmanagement.controller.roommanagement.worker.ShowRoomWorker;
import clinicmanagement.controller.toolmanagement.worker.ShowToolWorker;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.model.service.ToolService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyRoom_Admin;
import clinicmanagement.view.manager.ModifyTool_Admin;
import clinicmanagement.view.manager.RoomManagement_Admin;
import clinicmanagement.view.manager.ToolManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyToolSubmitListener implements ModifyToolSubmitListener {
    @Inject
    private ToolManagement_Admin toolManagementAdmin;
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
    @Inject @Named(ModifyToolName.T_STATUS)
    private ComboBoxModel t_status;
    @Inject
    private Provider<ShowToolWorker> showToolWorkerProvider;
    @Inject
    private ToolService toolService;
    @Inject
    private RoomService roomService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            int id = Integer.parseInt(DocumentUtil.getText(t_id));
            String name = DocumentUtil.getText(t_name);
            int roomId = roomService.getIdByName(DocumentUtil.getText(t_room));
            String importDate = DocumentUtil.getText(t_importDate);
            String expireDate = DocumentUtil.getText(t_expireDate);
            String status = (String) t_status.getSelectedItem();
            if (
                    name.isEmpty() || DocumentUtil.getText(t_room).isEmpty()
                            || importDate.isEmpty() || expireDate.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                toolService.modifyTool(id, roomId, name, importDate, expireDate,status);
                modifyToolAdmin.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(t_name);
            DocumentUtil.removeText(t_importDate);
            DocumentUtil.removeText(t_expireDate);
            DocumentUtil.removeText(t_room);
            DocumentUtil.removeText(t_id);
            modifyToolAdmin.setVisible(false);
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    showToolWorkerProvider.get().refreshTable(toolService.getListTool());
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Worker().execute();
    }
}
