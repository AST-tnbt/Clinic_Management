package clinicmanagement.controller.modifymedicalrecord.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultDoctorModifyMedicalRecordAddPrescriptionListener.class)
public interface DoctorModifyMedicalRecordAddPrescriptionListener extends ActionListener {
}
