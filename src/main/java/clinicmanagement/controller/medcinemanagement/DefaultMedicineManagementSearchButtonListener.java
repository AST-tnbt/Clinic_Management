package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.constant.MedicineManagementName;
import clinicmanagement.constant.ToolManagementName;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker;
import clinicmanagement.controller.toolmanagement.worker.ShowToolWorker;
import clinicmanagement.model.entity.Medicine;
import clinicmanagement.model.entity.Tool;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.ToolService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultMedicineManagementSearchButtonListener implements MedicineManagementSearchButtonListener {
    @Inject @Named(MedicineManagementName.MEDICINE_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private MedicineService medicineService;
    @Inject
    private Provider<ShowMedicineWorker> showMedicineWorkerProvider;

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
