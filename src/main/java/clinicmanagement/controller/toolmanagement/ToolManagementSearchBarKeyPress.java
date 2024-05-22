package clinicmanagement.controller.toolmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultToolManagementSearchBarKeyPress.class)
public interface ToolManagementSearchBarKeyPress extends KeyListener {}
