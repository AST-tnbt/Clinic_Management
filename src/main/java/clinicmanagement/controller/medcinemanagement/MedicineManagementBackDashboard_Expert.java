package clinicmanagement.controller.medcinemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultMedicineManagementBackDashboard_Expert.class)
public interface MedicineManagementBackDashboard_Expert extends MouseListener {
}
