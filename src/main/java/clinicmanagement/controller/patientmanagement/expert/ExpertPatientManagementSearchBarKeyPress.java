package clinicmanagement.controller.patientmanagement.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultExpertPatientManagementSearchBarKeyPress.class)
public interface ExpertPatientManagementSearchBarKeyPress extends KeyListener {}
