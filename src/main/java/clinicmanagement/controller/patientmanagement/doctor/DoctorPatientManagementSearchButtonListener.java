package clinicmanagement.controller.patientmanagement.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultDoctorPatientManagementSearchButtonListener.class)
public interface DoctorPatientManagementSearchButtonListener extends ActionListener {}
