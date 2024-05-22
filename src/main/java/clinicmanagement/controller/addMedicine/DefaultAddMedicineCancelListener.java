/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addMedicine;

import clinicmanagement.constant.AddMedicineName;
import clinicmanagement.constant.AddToolName;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddMedicine_Admin;
import clinicmanagement.view.manager.AddTool_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultAddMedicineCancelListener implements AddMedicineCancelListener {
    @Inject
    private AddMedicine_Admin addMedicineAdmin;
    @Inject @Named(AddMedicineName.MEDICINE_NAME)
    private Document name;
    @Inject @Named(AddMedicineName.MEDICINE_PRICE)
    private Document price;
    @Inject @Named(AddMedicineName.MEDICINE_QUANTITY)
    private Document quantity;
    @Inject @Named(AddMedicineName.MEDICINE_IMPORTDATE)
    private Document importDate;
    @Inject @Named(AddMedicineName.MEDICINE_EXPIREDATE)
    private Document expireDate;

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.name);
        DocumentUtil.removeText(this.importDate);
        DocumentUtil.removeText(this.expireDate);
        DocumentUtil.removeText(this.quantity);
        DocumentUtil.removeText(this.price);
        this.addMedicineAdmin.setVisible(false);
    }
}
