package clinicmanagement.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private int ordinalNumbers;
    private LocalDate appointmentDate;

    public Appointment(int id, int patientId, int doctorId, int ordinalNumbers, LocalDate appointmentDate) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.ordinalNumbers = ordinalNumbers;
        this.appointmentDate = appointmentDate;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getOrdinalNumbers() {
        return ordinalNumbers;
    }

    public void setOrdinalNumbers(int ordinalNumbers) {
        this.ordinalNumbers = ordinalNumbers;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
