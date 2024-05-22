package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.constant.MedicineManagementName;
import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.constant.ModifyMedicineName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import clinicmanagement.view.manager.ModifyMedicine_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultMedicineManagementModifyButtonListener extends MouseAdapter implements MedicineManagementModifyButtonListener {
    @Inject
    ModifyMedicine_Admin modifyMedicineAdmin;
    @Inject @Named(MedicineManagementName.MEDICINE_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(MedicineManagementName.MEDICINE_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
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
    MedicineService medicineService;

    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc để chỉnh sửa.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 loại thuốc.");
        }
        else {
            modifyMedicineAdmin.setVisible(true);
            try {
                DocumentUtil.removeText(this.m_id);
                DocumentUtil.removeText(this.m_name);
                DocumentUtil.removeText(this.m_importDate);
                DocumentUtil.removeText(this.m_price);
                DocumentUtil.removeText(this.m_expireDate);
                DocumentUtil.removeText(this.m_quantity);

                this.m_id.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 0), null);
                this.m_name.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1), null);
                this.m_importDate.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 2), null);
                this.m_expireDate.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 3), null);
                this.m_price.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 4), null);
                this.m_quantity.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 5), null);
                } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
