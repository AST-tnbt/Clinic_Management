/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicine;

import clinicmanagement.constant.ModifyMedicineName;
import clinicmanagement.constant.ModifyMedicineName_Expert;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.ModifyMedicine_Expert;
import clinicmanagement.view.manager.ModifyMedicine_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyMedicineCancelListener_Expert implements ModifyMedicineCancelListener_Expert {
    @Inject
    private ModifyMedicine_Expert modifyMedicineAdmin;
    @Inject @Named(ModifyMedicineName_Expert.MEDICINE_ID)
    private Document m_id;
    @Inject @Named(ModifyMedicineName_Expert.MEDICINE_NAME)
    private Document m_name;
    @Inject @Named(ModifyMedicineName_Expert.MEDICINE_EXPIREDATE)
    private Document m_expireDate;
    @Inject @Named(ModifyMedicineName_Expert.MEDICINE_IMPORTDATE)
    private Document m_importDate;
    @Inject @Named(ModifyMedicineName_Expert.MEDICINE_PRICE)
    private Document m_price;
    @Inject @Named(ModifyMedicineName_Expert.MEDICINE_QUANTITY)
    private Document m_quantity;

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.m_id);
        DocumentUtil.removeText(this.m_name);
        DocumentUtil.removeText(this.m_importDate);
        DocumentUtil.removeText(this.m_price);
        DocumentUtil.removeText(this.m_expireDate);
        DocumentUtil.removeText(this.m_quantity);
        this.modifyMedicineAdmin.setVisible(false);
    }
}
