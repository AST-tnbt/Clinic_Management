package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.Patient;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class PatientService {
    @Inject @Named(EntityName.PATIENT_MODEL)
    private ArrayList<Patient> listPatient;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL LayTatBenhNhan()}";
            CallableStatement stm = con.prepareCall(sqlQuery);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBigDecimal(7)
                );
                listPatient.add(patient);
            }
        con.close();
    }

    public void addPatient(String name, String dateOfBirth, String sex, String address, String phoneNum) throws SQLException {
        LocalDate realDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.listPatient.add(new Patient(listPatient.size()+1, name, realDateOfBirth, sex, address, phoneNum, BigDecimal.valueOf(0)));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL ThemBenhNhan(?, ?, ?, ?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setString(1, name);
        stm.setDate(2, Date.valueOf(realDateOfBirth));
        stm.setString(3, sex);
        stm.setString(4, address);
        stm.setString(5, phoneNum);
        stm.execute();
        con.close();
    }

    public void deleteById(ArrayList<Integer> listId) throws SQLException {
        for (int tmpId : listId) {
            for (int i = 0; i < listPatient.size(); i++) {
                if (listPatient.get(i).getId() == tmpId) {
                    listPatient.remove(i);
                    break;
                }
            }
            Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL XoaBenhNhan(?)}";
            CallableStatement stm;
            stm = con.prepareCall(sqlQuery);
            stm.setInt(1, tmpId );
            stm.execute();
            con.close();
        }
    }

    public ArrayList<Patient> getListPatient() {
        return listPatient;
    }

    public void modifyPatient(int id, String name, String phone, String dateOfBirth, String sex, String address) throws SQLException {
        LocalDate realDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (Patient patient : listPatient) {
            if (patient.getId() == id) {
                patient.setName(name);
                patient.setPhoneNum(phone);
                patient.setSex(sex);
                patient.setDateOfBirth(realDateOfBirth);
                patient.setAddress(address);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL CapNhatBenhNhan(?, ?, ?, ?, ?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setDate(3, Date.valueOf(realDateOfBirth));
        pst.setString(4, sex);
        pst.setString(5, address);
        pst.setString(6, phone);
        pst.executeUpdate();
        con.close();
    }
    public void removeAllObject() {
        this.listPatient.removeAll(listPatient);
    }

    public String getNameById(int patientId) {
        for (Patient patient : listPatient) {
            if (patient.getId() == patientId) return patient.getName();
        }
        return "";
    }
}
