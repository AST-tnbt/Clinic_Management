/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.constant.MedicineManagementName;
import clinicmanagement.constant.MedicineManagementName_Expert;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker_Expert;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.MedicineService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jakarta.inject.Named;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tin-ast
 */
public class DefaultMedicineManagementDeleteButtonListener_Expert extends MouseAdapter implements MedicineManagementDeleteButtonListener_Expert {
    @Inject @Named(MedicineManagementName_Expert.MEDICINE_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(MedicineManagementName_Expert.MEDICINE_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private Provider<ShowMedicineWorker_Expert> showMedicineWorkerProvider;
    @Inject
    private MedicineService medicineService;

    private ArrayList<Integer> listId = new ArrayList<>();
    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                medicineService.deleteById(listId);
            } catch (SQLException e) {
                return false;
            }
            return true;
        }
        @Override
        protected void done() {
            try {
                if (get()) {
                    showMedicineWorkerProvider.get().refreshTable(medicineService.getListMedicine());
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng");
            return;
        }
        for (int row : rows) {
            listId.add(Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(row, 0)));
        }
        new Worker().execute();
    }
    
}
