package clinicmanagement.controller.addprescription.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultPrescriptionAddButtonListener.class)
public interface PrescriptionAddButtonListener extends ActionListener {
}
