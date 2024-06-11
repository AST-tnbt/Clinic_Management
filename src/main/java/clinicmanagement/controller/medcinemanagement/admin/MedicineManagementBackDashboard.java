package clinicmanagement.controller.medcinemanagement.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultMedicineManagementBackDashboard.class)
public interface MedicineManagementBackDashboard extends MouseListener {
}
