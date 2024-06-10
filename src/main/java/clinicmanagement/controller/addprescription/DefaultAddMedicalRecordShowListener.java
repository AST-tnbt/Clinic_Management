package clinicmanagement.controller.addprescription;

import clinicmanagement.constant.AddMedicalRecordName;
import clinicmanagement.model.entity.Medicine;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PrescriptionService;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class DefaultAddMedicalRecordShowListener extends ComponentAdapter implements AddMedicalRecordShowListener {
    @Inject @Named(AddMedicalRecordName.P_MEDICINELIST)
    private ComboBoxModel medicineList;
    @Inject
    private MedicineService medicineService;
    @Inject
    private PrescriptionService prescriptionService;
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
        try {
            prescriptionService.addPrescription();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
