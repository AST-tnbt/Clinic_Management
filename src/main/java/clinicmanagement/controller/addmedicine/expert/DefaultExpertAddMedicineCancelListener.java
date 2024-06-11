/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addmedicine.expert;

import clinicmanagement.constant.admin.AddMedicineName;
import clinicmanagement.constant.expert.ExpertAddMedicineName;
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
public class DefaultExpertAddMedicineCancelListener implements ExpertAddMedicineCancelListener {
    @Inject
    private AddMedicine_Expert addMedicineExpert;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_NAME)
    private Document name;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_PRICE)
    private Document price;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_QUANTITY)
    private Document quantity;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_IMPORTDATE)
    private Document importDate;
    @Inject @Named(ExpertAddMedicineName.MEDICINE_EXPIREDATE)
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
