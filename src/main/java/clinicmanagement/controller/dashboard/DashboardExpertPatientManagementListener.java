package clinicmanagement.controller.dashboard;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDashboardExpertPatientManagementListener.class)
public interface DashboardExpertPatientManagementListener extends MouseListener {}
