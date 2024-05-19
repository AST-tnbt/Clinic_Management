package clinicmanagement.controller.roommanagement;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.constant.ModifyRoomName;
import clinicmanagement.constant.RoomManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import clinicmanagement.view.manager.ModifyRoom_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultRoomManagementModifyButtonListener extends MouseAdapter implements RoomManagementModifyButtonListener {
    @Inject
    ModifyRoom_Admin modifyRoomAdmin;
    @Inject @Named(RoomManagementName.ROOM_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(RoomManagementName.ROOM_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(ModifyRoomName.R_ID)
    private Document r_ID;
    @Inject @Named(ModifyRoomName.R_NAME)
    private Document r_Name;
    @Inject @Named(ModifyRoomName.R_CAPACITY)
    private Document r_Capacity;
    @Inject
    RoomService roomService;

    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng để chỉnh sửa.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 phòng.");
        }
        else {
            modifyRoomAdmin.setVisible(true);
            try {
                this.r_ID.remove(0, this.r_ID.getLength());
                this.r_Name.remove(0, this.r_Name.getLength());
                this.r_Capacity.remove(0, this.r_Capacity.getLength());

                this.r_ID.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 0), null);
                this.r_Name.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1), null);
                this.r_Capacity.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 2), null);
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
