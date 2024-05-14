package clinicmanagement.controller.appointmentManagement;

import clinicmanagement.view.manager.AppointmentManagement_Admin;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultAppointmentManagementBackDashboard extends MouseAdapter implements AppointmentManagementBackDashboard{
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    AppointmentManagement_Admin appointmentManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        appointmentManagement.setVisible(false);
    }
}
