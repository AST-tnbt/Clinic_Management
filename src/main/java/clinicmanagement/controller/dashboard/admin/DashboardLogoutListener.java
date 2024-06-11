package clinicmanagement.controller.dashboard.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDashboardLogoutListener.class)
public interface DashboardLogoutListener extends MouseListener {}
