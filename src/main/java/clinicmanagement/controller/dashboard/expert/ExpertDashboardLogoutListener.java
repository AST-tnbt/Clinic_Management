package clinicmanagement.controller.dashboard.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultExpertDashboardLogoutListener.class)
public interface ExpertDashboardLogoutListener extends MouseListener {}
