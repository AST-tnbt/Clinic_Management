package clinicmanagement.controller.appointmentManagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultAppointmentManagementSearchBarKeyPress.class)
public interface AppointmentManagementSearchBarKeyPress extends KeyListener {}
