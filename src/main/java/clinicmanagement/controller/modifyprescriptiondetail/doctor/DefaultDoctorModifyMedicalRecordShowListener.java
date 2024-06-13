package clinicmanagement.controller.modifyprescriptiondetail.doctor;

import clinicmanagement.constant.admin.ModifyMedicalRecordName;
import clinicmanagement.constant.doctor.DoctorModifyMedicalRecordName;
import clinicmanagement.model.entity.Medicine;
import clinicmanagement.model.service.MedicineService;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class DefaultDoctorModifyMedicalRecordShowListener extends ComponentAdapter implements DoctorModifyMedicalRecordShowListener {
    @Inject @Named(DoctorModifyMedicalRecordName.P_MEDICINELIST)
    private ComboBoxModel medicineList;
    @Inject
    private MedicineService medicineService;
    @Override
    public void componentShown(ComponentEvent e) {
        DefaultComboBoxModel mList = (DefaultComboBoxModel) medicineList;
        mList.removeAllElements();
        ArrayList<String> nameList = new ArrayList<>();
        for (Medicine medicine : medicineService.getListMedicine()) {
            if (medicine.getInventoryQuantity() > 0) {
                nameList.add(medicine.getName());
            }
        }
        mList.addAll(nameList);
    }
}
