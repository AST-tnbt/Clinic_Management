package clinicmanagement.controller.patientmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultPatientManagementSearchBarKeyPress_Expert.class)
public interface PatientManagementSearchBarKeyPress_Expert extends KeyListener {}
