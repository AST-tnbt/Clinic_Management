package clinicmanagement.controller.dashboard;

import clinicmanagement.view.manager.AppointmentManagement_Admin;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDashboardAppointmentListener extends MouseAdapter implements DashboardAppointmentListener {
    @Inject
    private Dashboard_Admin dashboard;
    @Inject
    private AppointmentManagement_Admin appointmentManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        this.dashboard.setVisible(false);
        this.appointmentManagement.setVisible(true);
    }
}
