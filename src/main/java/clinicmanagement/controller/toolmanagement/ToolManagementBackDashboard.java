package clinicmanagement.controller.toolmanagement;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultToolManagementBackDashboard.class)
public interface ToolManagementBackDashboard extends MouseListener {
}
