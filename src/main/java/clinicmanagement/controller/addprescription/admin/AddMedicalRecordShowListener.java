package clinicmanagement.controller.addprescription.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.ComponentListener;

@ImplementedBy(DefaultAddMedicalRecordShowListener.class)
public interface AddMedicalRecordShowListener extends ComponentListener {
}
