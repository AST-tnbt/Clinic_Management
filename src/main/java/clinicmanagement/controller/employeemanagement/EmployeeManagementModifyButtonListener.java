package clinicmanagement.controller.employeemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultEmployeeManagementModifyButtonListener.class)
public interface EmployeeManagementModifyButtonListener extends MouseListener {}
