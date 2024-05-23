/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addMedicine;

import clinicmanagement.constant.AddMedicineName;
import clinicmanagement.constant.AddMedicineName_Expert;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.AddMedicine_Expert;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultAddMedicineCancelListener_Expert implements AddMedicineCancelListener_Expert {
    @Inject
    private AddMedicine_Expert addMedicineExpert;
    @Inject @Named(AddMedicineName_Expert.MEDICINE_NAME)
    private Document name;
    @Inject @Named(AddMedicineName_Expert.MEDICINE_PRICE)
    private Document price;
    @Inject @Named(AddMedicineName_Expert.MEDICINE_QUANTITY)
    private Document quantity;
    @Inject @Named(AddMedicineName_Expert.MEDICINE_IMPORTDATE)
    private Document importDate;
    @Inject @Named(AddMedicineName_Expert.MEDICINE_EXPIREDATE)
    private Document expireDate;

    @Override
    public void actionPerformed(ActionEvent e) {
        DocumentUtil.removeText(this.name);
        DocumentUtil.removeText(this.importDate);
        DocumentUtil.removeText(this.expireDate);
        DocumentUtil.removeText(this.quantity);
        DocumentUtil.removeText(this.price);
        this.addMedicineExpert.setVisible(false);
    }
}
