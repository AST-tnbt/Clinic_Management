package clinicmanagement.controller.patientmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultPatientManagementSearchButtonListener_Expert.class)
public interface PatientManagementSearchButtonListener_Expert extends ActionListener {}
