package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.MedicalRecord;
import clinicmanagement.model.entity.Patient;
import clinicmanagement.model.entity.PrescriptionDetail;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.math.BigDecimal;
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
    @Inject
    private InvoiceService invoiceService;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;

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
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDate(6).toLocalDate(),
                    rs.getString(7),
                    rs.getString(8)
            );
            listMedicalRecord.add(medicalRecord);
        }
        con.close();
    }

    public void removeAllObject() {this.listMedicalRecord.removeAll(listMedicalRecord);}

    public ArrayList<MedicalRecord> getListMedicalRecordByPatientId (int patientId) {
        ArrayList<MedicalRecord> list = new ArrayList<>();
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == patientId) list.add(medicalRecord);
        }
        return list;
    }

    public void addMedicalRecord(int patientId, int prescriptionId, String doctor, String room, String appointmentDate, String diagnosis, String status) throws SQLException {
        LocalDate realAppointmentDate = LocalDate.parse(appointmentDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int nexId = 0;
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            nexId = Math.max(nexId, medicalRecord.getId());
        }
        this.listMedicalRecord.add(new MedicalRecord(nexId +1 , patientId, prescriptionId, doctor, room, realAppointmentDate, diagnosis, status));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL ThemBenhAn(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setInt(1, patientId);
        stm.setInt(2, prescriptionId);
        stm.setString(3, doctor);
        stm.setString(4, room);
        stm.setDate(5, Date.valueOf(realAppointmentDate));
        stm.setString(6, diagnosis);
        stm.setString(7, status);
        stm.execute();
        con.close();
    }

    public String getRoomByPatientId(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord.getRoom();
            }
        }
        return "";
    }

    public String getRoomById(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getId() == id) return medicalRecord.getRoom();
        }
        return "";
    }

    public void updateMedicalRecord(int medicalRecordId, int patientId, int prescriptionId, String doctor, String room, String appointmentDate, String diagnosis, String status) throws SQLException {
        LocalDate realAppointmentDate = LocalDate.parse(appointmentDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getId() == medicalRecordId) {
                medicalRecord.setRoom(room);
                medicalRecord.setPrescriptionId(prescriptionId);
                medicalRecord.setDoctor(doctor);
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
        pst.setInt(2, patientId);
        pst.setInt(3, prescriptionId);
        pst.setString(4, doctor);
        pst.setString(5, room);
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

    public String getDiagnosisById(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getId() == id) return medicalRecord.getDiagnosis();
        }
        return "";
    }

    public int getPatientIdById(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getId() == id) return medicalRecord.getPatientId();
        }
        return -1;
    }

    public void deleteById(int id) throws SQLException {
        prescriptionDetailService.getListPrescriptionDetail().removeIf(prescriptionDetail -> prescriptionDetail.getPrescriptionId() == getPrescriptionIdById(id));
        prescriptionService.getListPrescription().removeIf(prescription -> prescription.getId() == getPrescriptionIdById(id));
        invoiceService.getListInvoice().removeIf(invoice -> invoice.getMedicalRecord() == id);
        listMedicalRecord.removeIf(medicalRecord -> medicalRecord.getId() == id);
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL XoaBenhAn(?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setInt(1, id);
        stm.execute();
        con.close();
    }

    public int getLastId() {
        return listMedicalRecord.getLast().getId();
    }

    public int getPrescriptionIdById(int id) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getId() == id) return medicalRecord.getPrescriptionId();
        }
        return -1;
    }

    public String getStatusById(int medicalRecordId) {
        for (MedicalRecord medicalRecord : listMedicalRecord) {
            if (medicalRecord.getId() == medicalRecordId) return medicalRecord.getStatus();
        }
        return "";
    }
}
