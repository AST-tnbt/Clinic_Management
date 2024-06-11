package clinicmanagement.controller.dashboard.expert;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.MedicineManagement_Expert;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultExpertDashboardMedicineListener extends MouseAdapter implements ExpertDashboardMedicineListener {
    @Inject
    MedicineManagement_Expert medicineManagementExpert;
    @Inject
    Dashboard_Expert dashboardExpert;
    @Override
    public void mouseClicked(MouseEvent e) {
        dashboardExpert.setVisible(false);
        medicineManagementExpert.setVisible(true);
    }
}
