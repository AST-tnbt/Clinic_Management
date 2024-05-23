package clinicmanagement.controller.medcinemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultMedicineManagementSearchButtonListener_Expert.class)
public interface MedicineManagementSearchButtonListener_Expert extends ActionListener {}
