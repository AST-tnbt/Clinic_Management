package clinicmanagement.controller.roommanagement;

import clinicmanagement.constant.admin.RoomManagementName;
import clinicmanagement.controller.roommanagement.worker.ShowRoomWorker;
import clinicmanagement.model.entity.Room;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultRoomManagementSearchButtonListener implements RoomManagementSearchButtonListener {
    @Inject @Named(RoomManagementName.ROOM_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private RoomService roomService;
    @Inject
    private Provider<ShowRoomWorker> showRoomWorkerProvider;

    @Override
    public void actionPerformed(ActionEvent e) {
        String room_name = DocumentUtil.getText(searchInput);
        ArrayList<Room> listRoom = roomService.getListRoom();
        ArrayList<Room> listRoomFilter = new ArrayList<>();
        for (Room room : listRoom) {
            if (room.getName().toLowerCase().contains(room_name.toLowerCase().trim())) {
                listRoomFilter.add(room);
            }
        }
        showRoomWorkerProvider.get().refreshTable(listRoomFilter);
    }
}
