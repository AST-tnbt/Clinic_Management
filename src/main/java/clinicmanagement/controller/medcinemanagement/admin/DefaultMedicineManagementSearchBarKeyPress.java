package clinicmanagement.controller.medcinemanagement.admin;

import clinicmanagement.constant.admin.MedicineManagementName;
import clinicmanagement.controller.medcinemanagement.admin.worker.ShowMedicineWorker;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultMedicineManagementSearchBarKeyPress extends KeyAdapter implements MedicineManagementSearchBarKeyPress {
    @Inject @Named(MedicineManagementName.MEDICINE_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowMedicineWorker> showMedicineWorkerProvider;
    @Inject
    private MedicineService medicineService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).isEmpty()) {
            showMedicineWorkerProvider.get().refreshTable(medicineService.getListMedicine());
        }
    }
}
