package clinicmanagement.controller.dashboard;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDashboardPatientManagementListener.class)
public interface DashboardPatientManagementListener extends MouseListener {}
