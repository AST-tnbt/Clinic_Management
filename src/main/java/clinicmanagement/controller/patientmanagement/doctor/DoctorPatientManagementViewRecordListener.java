package clinicmanagement.controller.patientmanagement.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDoctorPatientManagementViewRecordListener.class)
public interface DoctorPatientManagementViewRecordListener extends MouseListener {}
