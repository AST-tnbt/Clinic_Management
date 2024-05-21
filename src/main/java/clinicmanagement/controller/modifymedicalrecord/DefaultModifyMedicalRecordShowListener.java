package clinicmanagement.controller.modifymedicalrecord;

import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.view.manager.ModifyMedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class DefaultModifyMedicalRecordShowListener extends ComponentAdapter implements ModifyMedicalRecordShowListener {
    @Inject @Named(ModifyMedicalRecordName.P_MEDICINELIST)
    private ComboBoxModel medicineList;
    @Inject
    private MedicineService medicineService;
    @Override
    public void componentShown(ComponentEvent e) {
        DefaultComboBoxModel mList = (DefaultComboBoxModel) medicineList;
        mList.removeAllElements();
        ArrayList<String> nameList = medicineService.getListMedicine();
        mList.addAll(nameList);
    }
}
