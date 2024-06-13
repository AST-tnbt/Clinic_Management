package clinicmanagement.controller.dashboard.clerk;

import clinicmanagement.view.clerk.Dashboard_Clerk;
import clinicmanagement.view.clerk.FeeManagement_Clerk;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.FeeManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultClerkDashboardFeeListener extends MouseAdapter implements ClerkDashboardFeeListener {
    @Inject
    FeeManagement_Clerk feeManagementAdmin;
    @Inject
    Dashboard_Clerk dashboardAdmin;
    @Override
    public void mouseClicked(MouseEvent e) {
        dashboardAdmin.setVisible(false);
        feeManagementAdmin.setVisible(true);
    }
}
