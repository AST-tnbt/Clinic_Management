package clinicmanagement.controller.appointmentManagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultAppointmentManagementSearchButtonListener.class)
public interface AppointmentManagementSearchButtonListener extends ActionListener {}
