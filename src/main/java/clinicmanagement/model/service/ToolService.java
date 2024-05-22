package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.constant.ToolManagementName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Room;
import clinicmanagement.model.entity.Tool;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class ToolService {
    @Inject @Named(EntityName.TOOL)
    private ArrayList<Tool> listTool;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL LayTatCaDungCu()}";
        CallableStatement pst = con.prepareCall(sqlQuery);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Tool tool = new Tool(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getDate(4).toLocalDate(),
                    rs.getDate(5).toLocalDate(),
                    rs.getString(6)
            );
            listTool.add(tool);
        }
    }

    public void addTool(int roomId, String name, String importDate, String expireDate, String status) throws SQLException {
        LocalDate realImportDate = LocalDate.parse(importDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate realExpireDate = LocalDate.parse(expireDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        listTool.add(new Tool(listTool.size()+1, roomId, name, realImportDate, realExpireDate, status));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL ThemDungCu(?, ?, ?, ?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setInt(1, roomId);
        stm.setString(2, name);
        stm.setDate(3, Date.valueOf(realImportDate));
        stm.setDate(4, Date.valueOf(realExpireDate));
        stm.setString(5, status);
        stm.execute();
        con.close();
    }

    public void deleteById(ArrayList<Integer> listId) throws SQLException {
        for (int tmpId : listId) {
            for (int i = 0; i < listTool.size(); i++) {
                if (listTool.get(i).getId() == tmpId) {
                    listTool.remove(i);
                    break;
                }
            }
            Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL XoaDungCu(?)}";
            CallableStatement stm;
            stm = con.prepareCall(sqlQuery);
            stm.setInt(1, tmpId );
            stm.execute();
            con.close();
        }
    }


    public ArrayList<Tool> getListTool() {
        return listTool;
    }

    public void modifyTool(int id, int roomId, String name, String importDate, String expireDate, String status) throws SQLException {
        LocalDate realImportDate = LocalDate.parse(importDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate realExpireDate = LocalDate.parse(expireDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (Tool tool : listTool) {
            if (tool.getId() == id) {
                tool.setRoomId(roomId);
                tool.setName(name);
                tool.setImportDate(realImportDate);
                tool.setExpireDate(realExpireDate);
                tool.setStatus(status);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL SuaDungCu(?, ?, ?, ?, ?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, id);
        pst.setInt(2, roomId);
        pst.setString(3, name);
        pst.setDate(4, Date.valueOf(realImportDate));
        pst.setDate(5, Date.valueOf(realExpireDate));
        pst.setString(6, status);
        pst.executeUpdate();
    }

    public void removeAllObject() {
        this.listTool.removeAll(listTool);
    }
}