package clinicmanagement.controller.employeemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultEmployeeManagementSearchButtonListener.class)
public interface EmployeeManagementSearchButtonListener extends ActionListener {}
