package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.constant.MedicineManagementName;
import clinicmanagement.constant.MedicineManagementName_Expert;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker_Expert;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultMedicineManagementSearchBarKeyPress_Expert extends KeyAdapter implements MedicineManagementSearchBarKeyPress_Expert {
    @Inject @Named(MedicineManagementName_Expert.MEDICINE_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowMedicineWorker_Expert> showMedicineWorkerProvider;
    @Inject
    private MedicineService medicineService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).isEmpty()) {
            showMedicineWorkerProvider.get().refreshTable(medicineService.getListMedicine());
        }
    }
}
