package clinicmanagement.controller.patientmanagement.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultPatientManagementSearchBarKeyPress.class)
public interface PatientManagementSearchBarKeyPress extends KeyListener {}
