package clinicmanagement.controller.patientmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultPatientManagementSearchButtonListener.class)
public interface PatientManagementSearchButtonListener extends ActionListener {}
