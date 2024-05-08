/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.dashboard;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@ImplementedBy(DefaultDashboardEmployeeListener.class)
public interface DashboardEmployeeListener extends MouseListener {}
