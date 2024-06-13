/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinicmanagement.controller.dashboard.clerk;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

/**
 *
 * @author tin-ast
 */
@ImplementedBy(DefaultClerkDashboardFeeListener.class)
public interface ClerkDashboardFeeListener extends MouseListener{}
