package clinicmanagement.controller.toolmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultToolManagementSearchButtonListener.class)
public interface ToolManagementSearchButtonListener extends ActionListener {}
