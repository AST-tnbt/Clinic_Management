/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.constant.MedicineManagementName;
import clinicmanagement.constant.MedicineManagementName_Expert;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker_Expert;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.MedicineService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 *
 * @author tin-ast
 */
public class DefaultMedicineManagementShowMedicine_Expert extends ComponentAdapter implements MedicineManagementShowMedicine_Expert {
    @Inject private Provider<ShowMedicineWorker_Expert> showMedicineWorkerProvider;

    @Inject @Named(MedicineManagementName_Expert.MEDICINE_TABLE)
    private TableModelWrapper tableModelWrapper;

    @Inject
    MedicineService medicineService;

    @Override
    public void componentShown(ComponentEvent e) {
        showMedicineWorkerProvider.get().refreshTable(medicineService.getListMedicine());
    }
}
