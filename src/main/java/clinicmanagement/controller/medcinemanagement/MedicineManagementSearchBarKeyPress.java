package clinicmanagement.controller.medcinemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultMedicineManagementSearchBarKeyPress.class)
public interface MedicineManagementSearchBarKeyPress extends KeyListener {}
