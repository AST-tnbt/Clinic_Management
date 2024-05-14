package clinicmanagement.controller.appointmentManagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultAppointmentManagementBackDashboard.class)
public interface AppointmentManagementBackDashboard extends MouseListener {
}
