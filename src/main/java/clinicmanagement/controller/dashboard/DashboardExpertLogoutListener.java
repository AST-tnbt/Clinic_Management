package clinicmanagement.controller.dashboard;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDashboardExpertLogoutListener.class)
public interface DashboardExpertLogoutListener extends MouseListener {}
