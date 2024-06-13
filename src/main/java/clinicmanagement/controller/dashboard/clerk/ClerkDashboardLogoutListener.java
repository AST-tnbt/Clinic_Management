package clinicmanagement.controller.dashboard.clerk;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultClerkDashboardLogoutListener.class)
public interface ClerkDashboardLogoutListener extends MouseListener {}
