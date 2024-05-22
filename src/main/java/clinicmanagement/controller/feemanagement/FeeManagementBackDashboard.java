package clinicmanagement.controller.feemanagement;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultFeeManagementBackDashboard.class)
public interface FeeManagementBackDashboard extends MouseListener {
}
