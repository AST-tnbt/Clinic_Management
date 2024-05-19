/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.roommanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

/**
 *
 * @author tin-ast
 */
@ImplementedBy(DefaultRoomManagementAddButtonListener.class)
public interface RoomManagementAddButtonListener extends MouseListener {}
