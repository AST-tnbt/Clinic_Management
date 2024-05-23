package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.constant.MedicineManagementName;
import clinicmanagement.constant.MedicineManagementName_Expert;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker_Expert;
import clinicmanagement.model.entity.Medicine;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultMedicineManagementSearchButtonListener_Expert implements MedicineManagementSearchButtonListener_Expert {
    @Inject @Named(MedicineManagementName_Expert.MEDICINE_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private MedicineService medicineService;
    @Inject
    private Provider<ShowMedicineWorker_Expert> showMedicineWorkerProvider;

    @Override
    public void actionPerformed(ActionEvent e) {
        String medicine_name = DocumentUtil.getText(searchInput);
        ArrayList<Medicine> listMedicine = medicineService.getListMedicine();
        ArrayList<Medicine> listMedicineFilter = new ArrayList<>();
        for (Medicine medicine : listMedicine) {
            if (medicine.getName().toLowerCase().contains(medicine_name.toLowerCase().trim())) {
                listMedicineFilter.add(medicine);
            }
        }
        showMedicineWorkerProvider.get().refreshTable(listMedicineFilter);
    }
}
