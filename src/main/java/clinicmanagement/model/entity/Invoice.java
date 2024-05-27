package clinicmanagement.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    private int id;
    private int medicalRecord;
    private LocalDate dateExport;
    private BigDecimal total;

    public Invoice(int id, int medicalRecord, LocalDate dateExport, BigDecimal total) {
        this.id = id;
        this.medicalRecord = medicalRecord;
        this.dateExport = dateExport;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(int medicalRecord) {
        this.medicalRecord = medicalRecord;
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
