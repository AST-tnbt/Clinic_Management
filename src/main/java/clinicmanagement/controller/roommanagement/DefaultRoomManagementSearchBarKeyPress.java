package clinicmanagement.controller.roommanagement;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.constant.RoomManagementName;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.controller.roommanagement.worker.ShowRoomWorker;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultRoomManagementSearchBarKeyPress extends KeyAdapter implements RoomManagementSearchBarKeyPress {
    @Inject @Named(RoomManagementName.ROOM_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowRoomWorker> showRoomWorkerProvider;
    @Inject
    private RoomService roomService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).isEmpty()) {
            showRoomWorkerProvider.get().refreshTable(roomService.getListRoom());
        }
    }
}
