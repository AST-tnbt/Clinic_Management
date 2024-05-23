package clinicmanagement.controller.medcinemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultMedicineManagementModifyButtonListener_Expert.class)
public interface MedicineManagementModifyButtonListener_Expert extends MouseListener {}
