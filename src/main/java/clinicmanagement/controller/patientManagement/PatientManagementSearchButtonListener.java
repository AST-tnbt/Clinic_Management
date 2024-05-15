package clinicmanagement.controller.patientManagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultPatientManagementSearchButtonListener.class)
public interface PatientManagementSearchButtonListener extends ActionListener {}
