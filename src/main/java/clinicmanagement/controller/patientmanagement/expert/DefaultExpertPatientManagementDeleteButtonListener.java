/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.patientmanagement.expert;

import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.expert.ExpertPatientManagementName;
import clinicmanagement.controller.patientmanagement.admin.worker.ShowPatientWorker;
import clinicmanagement.controller.patientmanagement.expert.worker.ExpertShowPatientWorker;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
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
public class DefaultExpertPatientManagementDeleteButtonListener extends MouseAdapter implements ExpertPatientManagementDeleteButtonListener {
    @Inject @Named(ExpertPatientManagementName.PATIENT_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(ExpertPatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private Provider<ExpertShowPatientWorker> showPatientWorkerProvider;
    @Inject
    private PatientService patientService;

    private ArrayList<Integer> listId = new ArrayList<>();
    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                patientService.deleteById(listId);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
        @Override
        protected void done() {
            try {
                if (get()) {
                    showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
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
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân");
            return;
        }
        for (int row : rows) {
            listId.add(Integer.parseInt((String) tableModelWrapper.getModel().getValueAt(row, 0)));
        }
        new Worker().execute();
    }
    
}
