/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicine.expert;

import clinicmanagement.constant.expert.ExpertModifyMedicineName;
import clinicmanagement.controller.medcinemanagement.expert.worker.ExpertShowMedicineWorker;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.MedicineManagement_Expert;
import clinicmanagement.view.expert.ModifyMedicine_Expert;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tin-ast
 */
public class DefaultExpertModifyMedicineSubmitListener implements ExpertModifyMedicineSubmitListener {
    @Inject
    private MedicineManagement_Expert medicineManagementExpert;
    @Inject @Named(ExpertModifyMedicineName.MEDICINE_ID)
    private Document m_id;
    @Inject @Named(ExpertModifyMedicineName.MEDICINE_NAME)
    private Document m_name;
    @Inject @Named(ExpertModifyMedicineName.MEDICINE_EXPIREDATE)
    private Document m_expireDate;
    @Inject @Named(ExpertModifyMedicineName.MEDICINE_IMPORTDATE)
    private Document m_importDate;
    @Inject @Named(ExpertModifyMedicineName.MEDICINE_PRICE)
    private Document m_price;
    @Inject @Named(ExpertModifyMedicineName.MEDICINE_QUANTITY)
    private Document m_quantity;
    @Inject
    private Provider<ExpertShowMedicineWorker> showMedicineWorkerProvider;
    @Inject
    private MedicineService medicineService;
    @Inject
    private ModifyMedicine_Expert modifyMedicineExpert;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() {
            int id = Integer.parseInt(DocumentUtil.getText(m_id));
            String name = DocumentUtil.getText(m_name);
            String importDate = DocumentUtil.getText(m_importDate);
            String expireDate = DocumentUtil.getText(m_expireDate);
            BigDecimal price = new BigDecimal(DocumentUtil.getText(m_price));
            int quantity = Integer.parseInt(DocumentUtil.getText(m_quantity));
            if (
                    name.isEmpty() || DocumentUtil.getText(m_quantity).isEmpty()
                    || importDate.isEmpty() || expireDate.isEmpty()
                    ||  DocumentUtil.getText(m_price).isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                medicineService.modifyMedicine(id, name, importDate, price, expireDate, quantity);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            modifyMedicineExpert.setVisible(false);
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(m_id);
            DocumentUtil.removeText(m_name);
            DocumentUtil.removeText(m_importDate);
            DocumentUtil.removeText(m_price);
            DocumentUtil.removeText(m_expireDate);
            DocumentUtil.removeText(m_quantity);
            modifyMedicineExpert.setVisible(false);
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    showMedicineWorkerProvider.get().refreshTable(medicineService.getListMedicine());
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Worker().execute();
    }
}
