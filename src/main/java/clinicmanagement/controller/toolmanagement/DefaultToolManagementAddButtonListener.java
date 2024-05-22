/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.toolmanagement;

import clinicmanagement.constant.AddToolName;
import clinicmanagement.view.manager.AddRoom_Admin;
import clinicmanagement.view.manager.AddTool_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultToolManagementAddButtonListener extends MouseAdapter implements ToolManagementAddButtonListener {
    @Inject
    private AddTool_Admin addToolAdmin;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addToolAdmin.setVisible(true);
    }
}
