/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.toolmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

/**
 *
 * @author tin-ast
 */
@ImplementedBy(DefaultToolManagementAddButtonListener.class)
public interface ToolManagementAddButtonListener extends MouseListener {}