package clinicmanagement.controller.addprescription.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultDoctorPrescriptionAddButtonListener.class)
public interface DoctorPrescriptionAddButtonListener extends ActionListener {
}
