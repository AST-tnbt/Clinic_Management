package clinicmanagement.controller.toolmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultToolManagementModifyButtonListener.class)
public interface ToolManagementModifyButtonListener extends MouseListener {}
