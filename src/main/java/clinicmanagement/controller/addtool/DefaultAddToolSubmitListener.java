/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addtool;

import clinicmanagement.constant.AddRoomName;
import clinicmanagement.constant.AddToolName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.controller.roommanagement.worker.ShowRoomWorker;
import clinicmanagement.controller.toolmanagement.worker.ShowToolWorker;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.model.service.ToolService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddRoom_Admin;
import clinicmanagement.view.manager.AddTool_Admin;
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
public class DefaultAddToolSubmitListener implements AddToolSubmitListener {
    @Inject
    private ToolManagement_Admin toolManagementAdmin;
    @Inject @Named(AddToolName.T_NAME)
    private Document t_name;
    @Inject @Named(AddToolName.T_ROOM)
    private Document t_room;
    @Inject @Named(AddToolName.T_IMPORTDATE)
    private Document t_importDate;
    @Inject @Named(AddToolName.T_EXPIREDATE)
    private Document t_expireDate;
    @Inject @Named(AddToolName.T_STATUS)
    private ComboBoxModel t_status;
    private DatabaseContext databaseContext;
    @Inject 
    private Provider<ShowToolWorker> showToolWorkerProvider;
    @Inject
    private ToolService toolService;
    @Inject
    private RoomService roomService;
    @Inject
    private AddTool_Admin addToolAdmin;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
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
                toolService.addTool(roomId, name, importDate, expireDate, status);
                toolManagementAdmin.setVisible(true);
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
            addToolAdmin.setVisible(false);
            try {
                if (get()) {
                    showToolWorkerProvider.get().refreshTable(toolService.getListTool());
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
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
