/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.toolmanagement.worker;

import clinicmanagement.constant.RoomManagementName;
import clinicmanagement.constant.ToolManagementName;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Room;
import clinicmanagement.model.entity.Tool;
import clinicmanagement.model.service.RoomService;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author tin-ast
 */
public class ShowToolWorker {
    @Inject @Named(ToolManagementName.TOOL_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject
    private RoomService roomService;
    
    public void refreshTable(ArrayList<Tool> toolArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (Tool tool : toolArrayList) {
                tableModel.addRow(new String[]{String.valueOf(tool.getId()), tool.getName(),
                String.valueOf(tool.getImportDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
                String.valueOf(tool.getExpireDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))), tool.getStatus(),
                roomService.getNameById(tool.getRoomId())});
            }
    }
}
