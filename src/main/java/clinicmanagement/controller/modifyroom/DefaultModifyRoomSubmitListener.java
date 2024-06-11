/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifyroom;

import clinicmanagement.constant.admin.ModifyRoomName;
import clinicmanagement.controller.roommanagement.worker.ShowRoomWorker;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyRoom_Admin;
import clinicmanagement.view.manager.RoomManagement_Admin;
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
public class DefaultModifyRoomSubmitListener implements ModifyRoomSubmitListener {
    @Inject
    private RoomManagement_Admin roomManagementAdmin;
    @Inject
    private ModifyRoom_Admin modifyRoomAdmin;
    @Inject @Named(ModifyRoomName.R_ID)
    private Document r_ID;
    @Inject @Named(ModifyRoomName.R_NAME)
    private Document r_Name;
    @Inject @Named(ModifyRoomName.R_CAPACITY)
    private Document r_Capacity;
    @Inject
    private Provider<ShowRoomWorker> showRoomWorkerProvider;
    @Inject
    private RoomService roomService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            int id = Integer.parseInt(DocumentUtil.getText(r_ID));
            String name = DocumentUtil.getText(r_Name);
            String capacity =DocumentUtil.getText(r_Capacity);
            if (
                    name.isEmpty() || capacity.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                roomService.modifyRoom(id, name, Integer.parseInt(capacity));
                modifyRoomAdmin.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(r_ID);
            DocumentUtil.removeText(r_Name);
            DocumentUtil.removeText(r_Capacity);
            modifyRoomAdmin.setVisible(false);
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    showRoomWorkerProvider.get().refreshTable(roomService.getListRoom());
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
