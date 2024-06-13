package clinicmanagement.controller.feemanagement.admin;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultFeeManagementBackDashboard.class)
public interface FeeManagementBackDashboard extends MouseListener {
}
