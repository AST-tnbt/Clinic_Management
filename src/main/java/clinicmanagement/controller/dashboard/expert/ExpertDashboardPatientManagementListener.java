package clinicmanagement.controller.dashboard.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultExpertDashboardPatientManagementListener.class)
public interface ExpertDashboardPatientManagementListener extends MouseListener {}
