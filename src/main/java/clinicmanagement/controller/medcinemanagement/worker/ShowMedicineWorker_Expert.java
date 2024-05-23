/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medcinemanagement.worker;

import clinicmanagement.constant.MedicineManagementName;
import clinicmanagement.constant.MedicineManagementName_Expert;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Medicine;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author tin-ast
 */
public class ShowMedicineWorker_Expert {
    @Inject @Named(MedicineManagementName_Expert.MEDICINE_TABLE)
    private TableModelWrapper tableModelWrapper;
    
    public void refreshTable(ArrayList<Medicine> medicineArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (Medicine medicine : medicineArrayList) {
                tableModel.addRow(new String[]{String.valueOf(medicine.getId()),
                medicine.getName(),
                String.valueOf(medicine.getImportDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
                String.valueOf(medicine.getExpireDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
                String.valueOf(medicine.getPrice()), String.valueOf(medicine.getInventoryQuantity())});
            }
    }
}
