package clinicmanagement.controller.medcinemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultMedicineManagementSearchBarKeyPress_Expert.class)
public interface MedicineManagementSearchBarKeyPress_Expert extends KeyListener {}
