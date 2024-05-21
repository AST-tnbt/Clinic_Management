/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addroom;

import clinicmanagement.constant.AddEmployeeName;
import clinicmanagement.constant.AddRoomName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.controller.roommanagement.worker.ShowRoomWorker;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddEmployee_Admin;
import clinicmanagement.view.manager.AddRoom_Admin;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
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
public class DefaultAddRoomSubmitListener implements AddRoomSubmitListener {
    @Inject
    private RoomManagement_Admin roomManagement;
    @Inject
    private AddRoom_Admin addRoom;
    @Inject @Named(AddRoomName.R_NAME)
    private Document r_Name;
    @Inject @Named(AddRoomName.R_CAPACITY)
    private Document r_Capacity;
    private DatabaseContext databaseContext;
    @Inject 
    private Provider<ShowRoomWorker> showRoomWorkerProvider;
    @Inject
    private RoomService roomService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            String name = DocumentUtil.getText(r_Name);
            String capacity = DocumentUtil.getText(r_Capacity);
            if (
                    name.isEmpty() || capacity.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                roomService.addRoom(name, Integer.parseInt(capacity));
                roomManagement.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(r_Name);
            DocumentUtil.removeText(r_Capacity);
            addRoom.setVisible(false);
            try {
                if (get()) {
                    showRoomWorkerProvider.get().refreshTable(roomService.getListRoom());
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
