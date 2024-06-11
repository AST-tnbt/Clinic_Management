package clinicmanagement.controller.medcinemanagement.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultExpertMedicineManagementModifyButtonListener.class)
public interface ExpertMedicineManagementModifyButtonListener extends MouseListener {}
