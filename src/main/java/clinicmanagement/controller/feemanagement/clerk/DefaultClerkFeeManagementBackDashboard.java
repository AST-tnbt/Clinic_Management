package clinicmanagement.controller.feemanagement.clerk;

import clinicmanagement.view.clerk.Dashboard_Clerk;
import clinicmanagement.view.clerk.FeeManagement_Clerk;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultClerkFeeManagementBackDashboard extends MouseAdapter implements ClerkFeeManagementBackDashboard {
    @Inject
    Dashboard_Clerk dashboard;
    @Inject
    FeeManagement_Clerk feeManagementClerk;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        feeManagementClerk.setVisible(false);
    }
}
