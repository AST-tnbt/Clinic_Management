package clinicmanagement.controller.medcinemanagement.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultExpertMedicineManagementSearchBarKeyPress.class)
public interface ExpertMedicineManagementSearchBarKeyPress extends KeyListener {}
