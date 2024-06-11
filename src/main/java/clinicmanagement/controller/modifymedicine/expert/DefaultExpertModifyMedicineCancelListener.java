/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicine.expert;

import clinicmanagement.constant.admin.ModifyMedicineName;
import clinicmanagement.constant.expert.ExpertModifyMedicineName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.ModifyMedicine_Expert;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultExpertModifyMedicineCancelListener implements ExpertModifyMedicineCancelListener {
    @Inject
    private ModifyMedicine_Expert modifyMedicineExpert;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.m_id);
        DocumentUtil.removeText(this.m_name);
        DocumentUtil.removeText(this.m_importDate);
        DocumentUtil.removeText(this.m_price);
        DocumentUtil.removeText(this.m_expireDate);
        DocumentUtil.removeText(this.m_quantity);
        this.modifyMedicineExpert.setVisible(false);
    }
}
