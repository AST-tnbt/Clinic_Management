package clinicmanagement.model.entity;

public class Prescription {
    private int id;
    private int doctorId;

    public Prescription(int id, int doctorId) {
        this.id = id;
        this.doctorId = doctorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
