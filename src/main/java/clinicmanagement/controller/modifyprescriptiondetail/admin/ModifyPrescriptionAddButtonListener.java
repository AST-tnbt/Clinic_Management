package clinicmanagement.controller.modifyprescriptiondetail.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultModifyPrescriptionAddButtonListener.class)
public interface ModifyPrescriptionAddButtonListener extends ActionListener {
}
