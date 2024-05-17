package clinicmanagement.model.entity;

import java.time.LocalDate;

public class MedicalRecord {
    private int id;
    private int roomId;
    private int prescriptionId;
    private int employeeId;
    private int patientId;
    private LocalDate appointmentDate;
    private String diagnosis;
    private String status;

    public MedicalRecord(int id, int roomId, int prescriptionId, int employeeId, int patientId, LocalDate appointmentDate, String diagnosis, String status) {
        this.id = id;
        this.roomId = roomId;
        this.prescriptionId = prescriptionId;
        this.employeeId = employeeId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.diagnosis = diagnosis;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
