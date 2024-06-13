package clinicmanagement.controller.addprescription.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.ComponentListener;

@ImplementedBy(DefaultDoctorAddMedicalRecordShowListener.class)
public interface DoctorAddMedicalRecordShowListener extends ComponentListener {
}
