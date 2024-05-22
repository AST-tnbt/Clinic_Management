/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicine;

import clinicmanagement.constant.ModifyMedicineName;
import clinicmanagement.constant.ModifyToolName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyMedicine_Admin;
import clinicmanagement.view.manager.ModifyTool_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyMedicineCancelListener implements ModifyMedicineCancelListener {
    @Inject
    private ModifyMedicine_Admin modifyMedicineAdmin;
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
