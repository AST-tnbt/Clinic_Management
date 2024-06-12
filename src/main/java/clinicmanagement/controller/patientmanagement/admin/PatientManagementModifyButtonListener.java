package clinicmanagement.controller.patientmanagement.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultPatientManagementModifyButtonListener.class)
public interface PatientManagementModifyButtonListener extends MouseListener {}
