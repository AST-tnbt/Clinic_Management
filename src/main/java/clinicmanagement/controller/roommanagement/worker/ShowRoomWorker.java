/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.roommanagement.worker;

import clinicmanagement.constant.RoomManagementName;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Room;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.model.service.RoomService;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author tin-ast
 */
public class ShowRoomWorker {
    @Inject @Named(RoomManagementName.ROOM_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject
    private MedicalRecordService medicalRecordService;
    
    public void refreshTable(ArrayList<Room> roomArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (Room room : roomArrayList) {
                String amountOfPatient = String.valueOf(medicalRecordService.getPatientOfRoom(room.getId()));
                tableModel.addRow(new String[]{String.valueOf(room.getId()), room.getName(), String.valueOf(room.getCapacity()), amountOfPatient});
            }
    }
}
