package clinicmanagement.controller.dashboard;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDashboardAppointmentListener.class)
public interface DashboardAppointmentListener extends MouseListener {
}