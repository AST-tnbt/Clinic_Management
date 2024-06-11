package clinicmanagement.controller.medcinemanagement.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultMedicineManagementSearchButtonListener.class)
public interface MedicineManagementSearchButtonListener extends ActionListener {}
