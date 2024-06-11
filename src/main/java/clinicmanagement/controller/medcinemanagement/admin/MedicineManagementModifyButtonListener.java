package clinicmanagement.controller.medcinemanagement.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultMedicineManagementModifyButtonListener.class)
public interface MedicineManagementModifyButtonListener extends MouseListener {}
