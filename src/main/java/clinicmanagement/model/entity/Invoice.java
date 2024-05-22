package clinicmanagement.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    private int id;
    private int patientId;
    private int prescriptionId;
    private LocalDate dateExport;
    private BigDecimal total;

    public Invoice(int id, int patientId, int prescriptionId, LocalDate dateExport, BigDecimal total) {
        this.id = id;
        this.patientId = patientId;
        this.prescriptionId = prescriptionId;
        this.dateExport = dateExport;
        this.total = total;
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

    public LocalDate getDateExport() {
        return dateExport;
    }

    public void setDateExport(LocalDate dateExport) {
        this.dateExport = dateExport;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
