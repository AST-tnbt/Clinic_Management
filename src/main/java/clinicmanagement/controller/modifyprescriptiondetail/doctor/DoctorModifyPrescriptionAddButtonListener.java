package clinicmanagement.controller.modifyprescriptiondetail.doctor;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultDoctorModifyPrescriptionAddButtonListener.class)
public interface DoctorModifyPrescriptionAddButtonListener extends ActionListener {
}
