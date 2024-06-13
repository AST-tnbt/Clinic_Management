package clinicmanagement.controller.dashboard.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDoctorDashboardPatientManagementListener.class)
public interface DoctorDashboardPatientManagementListener extends MouseListener {}
