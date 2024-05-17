package clinicmanagement.model.entity;

public class PrescriptionDetail {
    private int medicineId;
    private int prescriptionId;
    private int amount;

    public PrescriptionDetail(int medicineId, int prescriptionId, int amount) {
        this.medicineId = medicineId;
        this.prescriptionId = prescriptionId;
        this.amount = amount;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
