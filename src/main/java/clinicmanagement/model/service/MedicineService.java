package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Medicine;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void removeAllObject() {this.listMedicine.removeAll(listMedicine);}

    public String getNameById(int id) {
        for (Medicine medicine : listMedicine) {
            if (medicine.getId() == id) {
                return medicine.getName();
            }
        }
        return "";
    }

    public ArrayList<String> getListMedicine() {
        ArrayList<String> list = new ArrayList<>();
        for (Medicine medicine : listMedicine) {
            list.add(medicine.getName());
        }
        return list;
    }
}
