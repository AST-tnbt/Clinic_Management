package clinicmanagement.controller.feemanagement.clerk;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultClerkFeeManagementBackDashboard.class)
public interface ClerkFeeManagementBackDashboard extends MouseListener {
}
