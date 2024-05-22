package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.view.manager.AppointmentManagement_Admin;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.manager.MedicineManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultMedicineManagementBackDashboard extends MouseAdapter implements MedicineManagementBackDashboard {
    @Inject
    Dashboard_Admin dashboard;
    @Inject
    MedicineManagement_Admin medicineManagementAdmin;

    @Override
    public void mouseClicked(MouseEvent e) {
        dashboard.setVisible(true);
        medicineManagementAdmin.setVisible(false);
    }
}
