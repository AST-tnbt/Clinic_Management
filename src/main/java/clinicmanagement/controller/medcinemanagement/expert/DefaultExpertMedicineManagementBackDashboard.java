package clinicmanagement.controller.medcinemanagement.expert;

import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.expert.MedicineManagement_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.MedicineManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultExpertMedicineManagementBackDashboard extends MouseAdapter implements ExpertMedicineManagementBackDashboard {
    @Inject
    Dashboard_Expert dashboard;
    @Inject
    MedicineManagement_Expert medicineManagementAdmin;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        medicineManagementAdmin.setVisible(false);
    }
}
