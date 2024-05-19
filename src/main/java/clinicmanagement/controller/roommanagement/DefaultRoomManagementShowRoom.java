/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.roommanagement;

import clinicmanagement.constant.RoomManagementName;
import clinicmanagement.controller.roommanagement.worker.ShowRoomWorker;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.RoomService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 *
 * @author tin-ast
 */
public class DefaultRoomManagementShowRoom extends ComponentAdapter implements RoomManagementShowRoom {
    @Inject
    private Provider<ShowRoomWorker> showRoomWorkerProvider;
    @Inject @Named(RoomManagementName.ROOM_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject
    private RoomService roomService;

    @Override
    public void componentShown(ComponentEvent e) {
        showRoomWorkerProvider.get().refreshTable(roomService.getListRoom());
    }
}
