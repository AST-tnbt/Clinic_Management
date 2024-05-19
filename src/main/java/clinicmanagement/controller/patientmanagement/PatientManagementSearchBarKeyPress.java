package clinicmanagement.controller.patientmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultPatientManagementSearchBarKeyPress.class)
public interface PatientManagementSearchBarKeyPress extends KeyListener {}
