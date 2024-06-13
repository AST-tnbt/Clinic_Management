package clinicmanagement.controller.addmedicalrecord.admin;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultAddMedicalRecordAddPrescriptionListener.class)
public interface AddMedicalRecordAddPrescriptionListener extends ActionListener {
}
