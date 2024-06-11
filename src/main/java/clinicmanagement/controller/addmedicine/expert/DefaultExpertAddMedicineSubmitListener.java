/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addmedicine.expert;

import clinicmanagement.constant.expert.ExpertAddMedicineName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.controller.medcinemanagement.expert.worker.ExpertShowMedicineWorker;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.AddMedicine_Expert;
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
public class DefaultExpertAddMedicineSubmitListener implements ExpertAddMedicineSubmitListener {
    @Inject @Named(ExpertAddMedicineName.MEDICINE_NAME)
    private Document m_name;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_PRICE)
    private Document m_price;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_QUANTITY)
    private Document m_quantity;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_IMPORTDATE)
    private Document m_importDate;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_EXPIREDATE)
    private Document m_expireDate;
    private DatabaseContext databaseContext;
    @Inject 
    private Provider<ExpertShowMedicineWorker> showMedicineWorkerProvider;
    @Inject
    private MedicineService medicineService;
    @Inject
    private AddMedicine_Expert addMedicineExpert;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() {
            String name = DocumentUtil.getText(m_name);
            String importDate = DocumentUtil.getText(m_importDate);
            String expireDate = DocumentUtil.getText(m_expireDate);
            if (
                    name.isEmpty() || DocumentUtil.getText(m_quantity).isEmpty()
                    || importDate.isEmpty() || expireDate.isEmpty()
                    ||  DocumentUtil.getText(m_price).isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            BigDecimal price = new BigDecimal(DocumentUtil.getText(m_price));
            int quantity = Integer.parseInt(DocumentUtil.getText(m_quantity));
            try {
                medicineService.addMedicine(name, importDate, expireDate, price, quantity);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(e);
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(m_price);
            DocumentUtil.removeText(m_quantity);
            DocumentUtil.removeText(m_name);
            DocumentUtil.removeText(m_importDate);
            DocumentUtil.removeText(m_expireDate);
            addMedicineExpert.setVisible(false);
            try {
                if (get()) {
                    showMedicineWorkerProvider.get().refreshTable(medicineService.getListMedicine());
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
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
