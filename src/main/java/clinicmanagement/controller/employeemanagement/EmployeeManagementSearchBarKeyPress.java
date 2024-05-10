package clinicmanagement.controller.employeemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultEmployeeManagementSearchBarKeyPress.class)
public interface EmployeeManagementSearchBarKeyPress extends KeyListener {}
