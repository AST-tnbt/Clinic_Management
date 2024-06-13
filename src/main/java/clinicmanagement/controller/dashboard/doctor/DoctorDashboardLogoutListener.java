package clinicmanagement.controller.dashboard.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDoctorDashboardLogoutListener.class)
public interface DoctorDashboardLogoutListener extends MouseListener {}
