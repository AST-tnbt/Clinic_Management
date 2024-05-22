package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Patient;
import clinicmanagement.model.entity.Prescription;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class PrescriptionService {
    @Inject @Named(EntityName.PRESCRIPTION)
    private ArrayList<Prescription> listPrescription;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL LayTatCaToaThuoc()}";
        CallableStatement stm = con.prepareCall(sqlQuery);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Prescription prescription = new Prescription(
                    rs.getInt(1),
                    rs.getInt(2)
            );
            listPrescription.add(prescription);
        }
    }
    public void addPrescription(int doctorId) throws SQLException {
        this.listPrescription.add(new Prescription(listPrescription.size()+1, doctorId));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL ThemToaThuoc(?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setInt(1, doctorId);
        stm.execute();
        con.close();
    }
    public ArrayList<Prescription> getListPrescription() {
        return listPrescription;
    }
    public void deleteLastItem() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL XoaToaThuoc(?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setInt(1, listPrescription.size());
        stm.execute();
        con.close();
        listPrescription.removeLast();
    }

    public void removeAllObject() {
        listPrescription.removeAll(listPrescription);
    }
}
