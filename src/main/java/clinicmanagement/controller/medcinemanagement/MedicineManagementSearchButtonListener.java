package clinicmanagement.controller.medcinemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultMedicineManagementSearchButtonListener.class)
public interface MedicineManagementSearchButtonListener extends ActionListener {}
