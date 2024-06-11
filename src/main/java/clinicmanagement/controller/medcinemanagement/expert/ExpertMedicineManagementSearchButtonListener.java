package clinicmanagement.controller.medcinemanagement.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultExpertMedicineManagementSearchButtonListener.class)
public interface ExpertMedicineManagementSearchButtonListener extends ActionListener {}
