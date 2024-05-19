package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.MedicalRecord;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
