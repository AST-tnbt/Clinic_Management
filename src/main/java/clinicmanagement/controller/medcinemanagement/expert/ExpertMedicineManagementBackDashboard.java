package clinicmanagement.controller.medcinemanagement.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultExpertMedicineManagementBackDashboard.class)
public interface ExpertMedicineManagementBackDashboard extends MouseListener {
}
