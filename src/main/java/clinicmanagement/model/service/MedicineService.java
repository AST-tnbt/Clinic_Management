package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Medicine;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class MedicineService {
    @Inject @Named(EntityName.MEDICINE)
    private ArrayList<Medicine> listMedicine;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL LayTatCaThuoc()}";
        CallableStatement stm = con.prepareCall(sqlQuery);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Medicine medicine = new Medicine(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDate(3).toLocalDate(),
                    rs.getBigDecimal(4),
                    rs.getDate(5).toLocalDate(),
                    rs.getInt(6)
            );
            listMedicine.add(medicine);
        }
        con.close();
    }

    public void addMedicine(String name, String importDate, String expireDate, BigDecimal price, int inventoryQuantity) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate realImportDate = LocalDate.parse(importDate, formatter);
        LocalDate realExpireDate = LocalDate.parse(expireDate, formatter);
        int nextId = 0;
        for (Medicine medicine : listMedicine) {
            nextId = Math.max(nextId, medicine.getId());
            if (medicine.getName().toLowerCase().trim().equals(name.toLowerCase().trim())){
                medicine.setImportDate(realImportDate);
                medicine.setExpireDate(realExpireDate);
                medicine.setPrice(price);
                medicine.setInventoryQuantity(medicine.getInventoryQuantity() + inventoryQuantity);

                Connection con = databaseContext.getConnection();
                String sqlQuery = "{CALL SuaThuoc(?, ?, ?, ?, ?, ?)}";
                CallableStatement pst;
                pst = con.prepareCall(sqlQuery);
                pst.setInt(1, medicine.getId());
                pst.setString(2, name);
                pst.setDate(3, Date.valueOf(realImportDate));
                pst.setBigDecimal(4, price);
                pst.setDate(5, Date.valueOf(realExpireDate));
                pst.setInt(6, medicine.getInventoryQuantity());
                pst.executeUpdate();
                con.close();
                return;
            }
        }
        listMedicine.add(new Medicine(nextId + 1, name, realImportDate, price, realExpireDate, inventoryQuantity));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL ThemThuoc(?, ?, ?, ?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setString(1, name);
        stm.setDate(2, Date.valueOf(realImportDate));
        stm.setBigDecimal(3, price);
        stm.setDate(4, Date.valueOf(realExpireDate));
        stm.setInt(5, inventoryQuantity);
        stm.execute();
        con.close();
    }

    public void deleteById(ArrayList<Integer> listId) throws SQLException {
        for (int tmpId : listId) {
            for (Medicine medicine : listMedicine) {
                if (medicine.getId() == tmpId) {
                    medicine.setInventoryQuantity(0);
                }
            }
            Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL XoaThuoc(?)}";
            CallableStatement stm;
            stm = con.prepareCall(sqlQuery);
            stm.setInt(1, tmpId);
            stm.execute();
            con.close();
        }
    }

    public void modifyMedicine(int id, String name, String importDate, BigDecimal price, String expireDate, int inventoryQuantity) throws SQLException {
        LocalDate realImportDate = LocalDate.parse(importDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate realExpireDate = LocalDate.parse(expireDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (Medicine medicine : listMedicine) {
            if (medicine.getId() == id) {
                medicine.setName(name);
                medicine.setImportDate(realImportDate);
                medicine.setExpireDate(realExpireDate);
                medicine.setPrice(price);
                medicine.setInventoryQuantity(inventoryQuantity);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL SuaThuoc(?, ?, ?, ?, ?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setDate(3, Date.valueOf(realImportDate));
        pst.setBigDecimal(4, price);
        pst.setDate(5, Date.valueOf(realExpireDate));
        pst.setInt(6, inventoryQuantity);
        pst.executeUpdate();
        con.close();
    }

    public void removeAllObject() {this.listMedicine.removeAll(listMedicine);}

    public String getNameById(int id) {
        for (Medicine medicine : listMedicine) {
            if (medicine.getId() == id) {
                return medicine.getName();
            }
        }
        return "";
    }

    public int getIdByName(String name) {
        for (Medicine medicine : listMedicine) {
            if (medicine.getName().equals(name)) {
                return medicine.getId();
            }
        }
        return -1;
    }

    public ArrayList<String> getListMedicineName() {
        ArrayList<String> list = new ArrayList<>();
        for (Medicine medicine : listMedicine) {
            list.add(medicine.getName());
        }
        return list;
    }

    public ArrayList<Medicine> getListMedicine() {
        return listMedicine;
    }

    public BigDecimal getPriceById(int id) {
        for (Medicine medicine : listMedicine) {
            if (medicine.getId() == id) return medicine.getPrice();
        }
        return BigDecimal.valueOf(0);
    }

    public void decreaseAmountById(int id, int amount) {
        for (Medicine medicine : listMedicine) {
            if ((medicine.getId() == id) && (amount < medicine.getInventoryQuantity())) {
                medicine.setInventoryQuantity(medicine.getInventoryQuantity() - amount);
            }
        }
    }
    public void increaseAmountById(int id, int amount) throws SQLException {
        for (Medicine medicine : listMedicine) {
            if (medicine.getId() == id) {
                medicine.setInventoryQuantity(medicine.getInventoryQuantity() + amount);
                Connection con = databaseContext.getConnection();
                String sqlQuery = "{CALL TangThuoc(?, ?)}";
                CallableStatement pst;
                pst = con.prepareCall(sqlQuery);
                pst.setInt(1, id);
                pst.setInt(2, amount);
                pst.executeUpdate();
                con.close();
                break;
            }
        }
    }
}
