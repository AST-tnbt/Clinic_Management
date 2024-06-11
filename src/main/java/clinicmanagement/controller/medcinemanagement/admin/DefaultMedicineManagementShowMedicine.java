/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medcinemanagement.admin;

import clinicmanagement.constant.admin.MedicineManagementName;
import clinicmanagement.controller.medcinemanagement.admin.worker.ShowMedicineWorker;
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
public class DefaultMedicineManagementShowMedicine extends ComponentAdapter implements MedicineManagementShowMedicine {
    @Inject private Provider<ShowMedicineWorker> showMedicineWorkerProvider;

    @Inject @Named(MedicineManagementName.MEDICINE_TABLE)
    private TableModelWrapper tableModelWrapper;

    @Inject
    MedicineService medicineService;

    @Override
    public void componentShown(ComponentEvent e) {
        showMedicineWorkerProvider.get().refreshTable(medicineService.getListMedicine());
    }
}
