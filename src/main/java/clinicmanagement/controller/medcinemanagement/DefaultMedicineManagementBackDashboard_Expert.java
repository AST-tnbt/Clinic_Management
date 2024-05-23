package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.MedicineManagement_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.MedicineManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultMedicineManagementBackDashboard_Expert extends MouseAdapter implements MedicineManagementBackDashboard_Expert {
    @Inject
    Dashboard_Expert dashboard;
    @Inject
    MedicineManagement_Expert medicineManagementExpert;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        medicineManagementExpert.setVisible(false);
    }
}
