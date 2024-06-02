package clinicmanagement.controller.modifymedicalrecord;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultModifyMedicalRecordAddPrescriptionListener.class)
public interface ModifyMedicalRecordAddPrescriptionListener extends ActionListener {
}
