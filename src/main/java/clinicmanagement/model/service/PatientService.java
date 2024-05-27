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
import java.util.Comparator;

@Singleton
public class PatientService {
    @Inject @Named(EntityName.PATIENT_MODEL)
    private ArrayList<Patient> listPatient;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL LayTatCaBenhNhan()}";
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
                        rs.getBigDecimal(7),
                        rs.getInt(8),
                        rs.getInt(9)
                );
                listPatient.add(patient);
            }
        con.close();
    }

    public void addPatient(String name, String dateOfBirth, String sex, String address, String phoneNum) throws SQLException {
        LocalDate realDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int nexId = 0;
        for (Patient patient : listPatient) {
            nexId = Math.max(nexId, patient.getId());
        }
        this.listPatient.add(new Patient(nexId +1 , name, realDateOfBirth, sex, address, phoneNum, BigDecimal.valueOf(0), 0, 0));
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

    public void modifyPatient(int id, String name, String dateOfBirth, String sex, String address, String phone) throws SQLException {
        LocalDate realDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (Patient patient : listPatient) {
            if (patient.getId() == id) {
                patient.setName(name);
                patient.setDateOfBirth(realDateOfBirth);
                patient.setSex(sex);
                patient.setAddress(address);
                patient.setPhoneNum(phone);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL SuaBenhNhan(?, ?, ?, ?, ?, ?)}";
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

    public int getRoomIdById(int id) {
        for (Patient patient : listPatient) {
            if (patient.getId() == id) return patient.getRoomId();
        }
        return -1;
    }

    public void setDoctorIdById(int id, int doctorId) throws SQLException {
        for (Patient patient : listPatient) {
            if (patient.getId() == id) {
                patient.setDoctorId(doctorId);
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL DatMaNV(?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, id);
        if (doctorId == 0) {
            pst.setNull(2, java.sql.Types.INTEGER);
        }
        else {
            pst.setInt(2, doctorId);
        }
        pst.executeUpdate();
        con.close();
    }

    public int getDoctorIdById(int id) {
        for (Patient patient : listPatient) {
            if (patient.getId() == id) return patient.getDoctorId();
        }
        return -1;
    }

    public void setRoomById(int id, int roomId) throws SQLException {
        for (Patient patient : listPatient) {
            if (patient.getId() == id) {
                patient.setRoomId(roomId);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL DatMaP(?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, id);
        if (roomId == 0) {
            pst.setNull(2, java.sql.Types.INTEGER);
        }
        else {
            pst.setInt(2, roomId);
        }
        pst.executeUpdate();
        con.close();
    }

    public int getPatientOfRoom(int roomId) {
        int result = 0;
        for (Patient patient : listPatient) {
            if (patient.getRoomId() == roomId) result ++;
        }
        return result;
    }

    public String getNameById(int id) {
        for (Patient patient : listPatient) {
            if (patient.getId() == id) return patient.getName();
        }
        return "";
    }
}
