package clinicmanagement.controller.medcinemanagement.expert;

import clinicmanagement.constant.admin.MedicineManagementName;
import clinicmanagement.constant.admin.ModifyMedicineName;
import clinicmanagement.constant.expert.ExpertMedicineManagementName;
import clinicmanagement.constant.expert.ExpertModifyMedicineName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.ModifyMedicine_Expert;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultExpertMedicineManagementModifyButtonListener extends MouseAdapter implements ExpertMedicineManagementModifyButtonListener {
    @Inject
    ModifyMedicine_Expert modifyMedicineExpert;
    @Inject @Named(ExpertMedicineManagementName.MEDICINE_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(ExpertMedicineManagementName.MEDICINE_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
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
            modifyMedicineExpert.setVisible(true);
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
