package clinicmanagement.controller.dashboard;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.MedicineManagement_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.MedicineManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDashboardExpertMedicineListener extends MouseAdapter implements DashboardExpertMedicineListener {
    @Inject
    MedicineManagement_Expert medicineManagementAdmin;
    @Inject
    Dashboard_Expert dashboardAdmin;
    @Override
    public void mouseClicked(MouseEvent e) {
        dashboardAdmin.setVisible(false);
        medicineManagementAdmin.setVisible(true);
    }
}
