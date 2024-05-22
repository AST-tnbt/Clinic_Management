/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicine;

import clinicmanagement.constant.ModifyMedicineName;
import clinicmanagement.constant.ModifyToolName;
import clinicmanagement.controller.medcinemanagement.worker.ShowMedicineWorker;
import clinicmanagement.controller.toolmanagement.worker.ShowToolWorker;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.RoomService;
import clinicmanagement.model.service.ToolService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.MedicineManagement_Admin;
import clinicmanagement.view.manager.ModifyMedicine_Admin;
import clinicmanagement.view.manager.ModifyTool_Admin;
import clinicmanagement.view.manager.ToolManagement_Admin;
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
public class DefaultModifyMedicineSubmitListener implements ModifyMedicineSubmitListener {
    @Inject
    private MedicineManagement_Admin medicineManagementAdmin;
    @Inject @Named(ModifyMedicineName.MEDICINE_ID)
    private Document m_id;
    @Inject @Named(ModifyMedicineName.MEDICINE_NAME)
    private Document m_name;
    @Inject @Named(ModifyMedicineName.MEDICINE_EXPIREDATE)
    private Document m_expireDate;
    @Inject @Named(ModifyMedicineName.MEDICINE_IMPORTDATE)
    private Document m_importDate;
    @Inject @Named(ModifyMedicineName.MEDICINE_PRICE)
    private Document m_price;
    @Inject @Named(ModifyMedicineName.MEDICINE_QUANTITY)
    private Document m_quantity;
    @Inject
    private Provider<ShowMedicineWorker> showMedicineWorkerProvider;
    @Inject
    private MedicineService medicineService;
    @Inject
    private ModifyMedicine_Admin modifyMedicineAdmin;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
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
            medicineService.modifyMedicine(id, name, importDate, price, expireDate, quantity);
            modifyMedicineAdmin.setVisible(false);
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
            modifyMedicineAdmin.setVisible(false);
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
