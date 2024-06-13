package clinicmanagement.controller.addmedicalrecord.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultDoctorAddMedicalRecordAddPrescriptionListener.class)
public interface DoctorAddMedicalRecordAddPrescriptionListener extends ActionListener {
}
