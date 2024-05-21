package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.Room;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class RoomService {
    @Inject @Named(EntityName.ROOM)
    private ArrayList<Room> listRoom;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL sp_LayTatCaPhong()}";
        CallableStatement pst = con.prepareCall(sqlQuery);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Room room = new Room(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)
            );
            listRoom.add(room);
        }
    }

    public void addRoom(String name, int amount) throws SQLException {
        listRoom.add(new Room(listRoom.size()+1, name, amount));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL sp_ThemPhong(?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setString(1, name);
        stm.setInt(2, amount);
        stm.execute();
        con.close();
    }

    public void deleteById(ArrayList<Integer> listId) throws SQLException {
        for (int tmpId : listId) {
            for (int i = 0; i < listRoom.size(); i++) {
                if (listRoom.get(i).getId() == tmpId) {
                    listRoom.remove(i);
                    break;
                }
            }
            Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL sp_XoaPhong(?)}";
            CallableStatement stm;
            stm = con.prepareCall(sqlQuery);
            stm.setInt(1, tmpId );
            stm.execute();
            con.close();
        }
    }


    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public void modifyRoom(int id, String name, int amount) throws SQLException {
        for (Room room : listRoom) {
            if (room.getId() == id) {
                room.setName(name);
                room.setCapacity(amount);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL sp_SuaPhong(?, ?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setInt(3, amount);
        pst.executeUpdate();
    }

    public void removeAllObject() {
        this.listRoom.removeAll(listRoom);
    }

    public String getNameById(int id) {
        for (Room room : listRoom) {
            if (room.getId() == id) return room.getName();
        }
        return "";
    }

    public int getIdByName(String name) {
        for (Room room : listRoom) {
            if (room.getName().equals(name)) return room.getId();
        }
        return -1;
    }
}
