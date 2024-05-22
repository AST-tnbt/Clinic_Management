package clinicmanagement.controller.dashboard;

import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.MedicineManagement_Admin;
import clinicmanagement.view.manager.ToolManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDashboardMedicineListener extends MouseAdapter implements DashboardMedicineListener {
    @Inject
    MedicineManagement_Admin medicineManagementAdmin;
    @Inject
    Dashboard_Admin dashboardAdmin;
    @Override
    public void mouseClicked(MouseEvent e) {
        dashboardAdmin.setVisible(false);
        medicineManagementAdmin.setVisible(true);
    }
}
