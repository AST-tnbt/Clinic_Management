package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.MedicalRecord;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class MedicalRecordService {
    @Inject @Named(EntityName.MEDICAL_RECORD)
    private ArrayList<MedicalRecord> listMedicalRecord;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL LayTatCaBenhAn()}";
        CallableStatement stm = con.prepareCall(sqlQuery);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            MedicalRecord medicalRecord = new MedicalRecord(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getDate(6).toLocalDate(),
                    rs.getString(7),
                    rs.getString(8)
            );
            listMedicalRecord.add(medicalRecord);
        }
        con.close();
    }

    public void removeAllObject() {this.listMedicalRecord.removeAll(listMedicalRecord);}

    public String getDiagnosisByPatientId(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord.getDiagnosis();
            }
        }
        return "";
    }

    public int getPrescriptionIdByPatientId(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord.getPrescriptionId();
            }
        }
        return -1;
    }

    public String getAppointmentDateByPatientId(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord.getAppointmentDate().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
            }
        }
        return "";
    }

    public String getStatusByPatientId(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord.getStatus();
            }
        }
        return "";
    }

    public int getRoomByPatientId(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord.getRoomId();
            }
        }
        return -1;
    }

    public void updateMedicalRecord(int medicalRecordId, int roomId, int prescriptionId, int doctorId, int patientId, String appointmentDate, String diagnosis, String status) throws SQLException {
        LocalDate realAppointmentDate = LocalDate.parse(appointmentDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getId() == medicalRecordId) {
                medicalRecord.setRoomId(roomId);
                medicalRecord.setPrescriptionId(prescriptionId);
                medicalRecord.setEmployeeId(doctorId);
                medicalRecord.setPatientId(patientId);
                medicalRecord.setAppointmentDate(realAppointmentDate);
                medicalRecord.setDiagnosis(diagnosis);
                medicalRecord.setStatus(status);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL SuaBenhAn(?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, medicalRecordId);
        pst.setInt(2, roomId);
        pst.setInt(3, prescriptionId);
        pst.setInt(4, doctorId);
        pst.setInt(5, patientId);
        pst.setDate(6, Date.valueOf(realAppointmentDate));
        pst.setString(7, diagnosis);
        pst.setString(8, status);
        pst.executeUpdate();
        con.close();

    }

    public int getIdByPatientId(int patientId) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == patientId) {
                return medicalRecord.getId();
            }
        }
        return -1;
    }
}
