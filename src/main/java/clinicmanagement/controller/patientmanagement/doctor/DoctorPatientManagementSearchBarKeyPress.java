package clinicmanagement.controller.patientmanagement.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultDoctorPatientManagementSearchBarKeyPress.class)
public interface DoctorPatientManagementSearchBarKeyPress extends KeyListener {}
