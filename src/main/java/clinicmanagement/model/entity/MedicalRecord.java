package clinicmanagement.model.entity;

import java.time.LocalDate;

public class MedicalRecord {
    private int id;
    private int patientId;
    private int prescriptionId;
    private String doctor;
    private String room;
    private LocalDate appointmentDate;
    private String diagnosis;
    private String status;

    public MedicalRecord(int id, int patientId, int prescriptionId, String doctor, String room, LocalDate appointmentDate, String diagnosis, String status) {
        this.id = id;
        this.patientId = patientId;
        this.prescriptionId = prescriptionId;
        this.doctor = doctor;
        this.room = room;
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
