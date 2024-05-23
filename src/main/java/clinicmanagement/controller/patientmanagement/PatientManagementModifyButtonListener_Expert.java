package clinicmanagement.controller.patientmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultPatientManagementModifyButtonListener_Expert.class)
public interface PatientManagementModifyButtonListener_Expert extends MouseListener {}
