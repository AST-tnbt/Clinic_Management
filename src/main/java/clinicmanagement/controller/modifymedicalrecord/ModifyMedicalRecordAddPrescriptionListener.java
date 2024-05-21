package clinicmanagement.controller.modifymedicalrecord;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

@ImplementedBy(DefaultModifyMedicalRecordAddPrescriptionListener.class)
public interface ModifyMedicalRecordAddPrescriptionListener extends ActionListener {
}
