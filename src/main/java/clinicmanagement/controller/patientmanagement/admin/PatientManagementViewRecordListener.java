package clinicmanagement.controller.patientmanagement.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultPatientManagementViewRecordListener.class)
public interface PatientManagementViewRecordListener extends MouseListener {}
