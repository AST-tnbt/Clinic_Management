package clinicmanagement.controller.medcinemanagement.expert;

import clinicmanagement.constant.admin.MedicineManagementName;
import clinicmanagement.constant.expert.ExpertMedicineManagementName;
import clinicmanagement.controller.medcinemanagement.admin.worker.ShowMedicineWorker;
import clinicmanagement.controller.medcinemanagement.expert.worker.ExpertShowMedicineWorker;
import clinicmanagement.model.entity.Medicine;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultExpertMedicineManagementSearchButtonListener implements ExpertMedicineManagementSearchButtonListener {
    @Inject @Named(ExpertMedicineManagementName.MEDICINE_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private MedicineService medicineService;
    @Inject
    private Provider<ExpertShowMedicineWorker> showMedicineWorkerProvider;

    @Override
    public void actionPerformed(ActionEvent e) {
        String medicine_name = DocumentUtil.getText(searchInput);
        ArrayList<Medicine> listMedicine = medicineService.getListMedicine();
        ArrayList<Medicine> listMedicineFilter = new ArrayList<>();
        for (Medicine medicine : listMedicine) {
            if (medicine.getName().toLowerCase().trim().contains(medicine_name.toLowerCase().trim())) {
                listMedicineFilter.add(medicine);
            }
        }
        showMedicineWorkerProvider.get().refreshTable(listMedicineFilter);
    }
}
