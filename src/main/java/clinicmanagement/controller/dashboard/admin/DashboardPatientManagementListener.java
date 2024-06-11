package clinicmanagement.controller.dashboard.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDashboardPatientManagementListener.class)
public interface DashboardPatientManagementListener extends MouseListener {}
