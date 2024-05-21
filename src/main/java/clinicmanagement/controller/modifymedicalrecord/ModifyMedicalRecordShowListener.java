package clinicmanagement.controller.modifymedicalrecord;

import com.google.inject.ImplementedBy;

import java.awt.event.ComponentListener;

@ImplementedBy(DefaultModifyMedicalRecordShowListener.class)
public interface ModifyMedicalRecordShowListener extends ComponentListener {
}
