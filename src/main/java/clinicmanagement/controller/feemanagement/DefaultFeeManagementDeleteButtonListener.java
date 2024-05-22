/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.feemanagement;

import clinicmanagement.constant.FeeManagementName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.controller.feemanagement.worker.ShowFeeWorker;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.InvoiceService;
import clinicmanagement.model.service.PatientService;
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
public class DefaultFeeManagementDeleteButtonListener extends MouseAdapter implements FeeManagementDeleteButtonListener {
    @Inject @Named(FeeManagementName.FEE_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(FeeManagementName.FEE_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private Provider<ShowFeeWorker> showFeeWorkerProvider;
    @Inject
    private InvoiceService invoiceService;

    private ArrayList<Integer> listId = new ArrayList<>();
    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                invoiceService.deleteById(listId);
            } catch (SQLException e) {
                return false;
            }
            return true;
        }
        @Override
        protected void done() {
            try {
                if (get()) {
                    showFeeWorkerProvider.get().refreshTable(invoiceService.getListInvoice());
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
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn");
            return;
        }
        for (int row : rows) {
            listId.add(Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(row, 0)));
        }
        new Worker().execute();
    }
    
}
