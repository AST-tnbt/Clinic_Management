package clinicmanagement.controller.dashboard;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
@Singleton
public class DefaultDashboardEmployeeListener extends MouseAdapter implements DashboardEmployeeListener {
    @Inject
    private Dashboard_Admin dashboard;
    @Inject
    private EmployeeManagement_Admin employeeManagement;

    @Override
    public void mouseClicked(MouseEvent e) {
        this.dashboard.setVisible(false);
        this.employeeManagement.setVisible(true);
    }
}
