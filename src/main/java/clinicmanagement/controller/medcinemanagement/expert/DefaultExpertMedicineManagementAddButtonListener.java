/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medcinemanagement.expert;

import clinicmanagement.view.expert.AddMedicine_Expert;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultExpertMedicineManagementAddButtonListener extends MouseAdapter implements ExpertMedicineManagementAddButtonListener {
    @Inject
    private AddMedicine_Expert addMedicineExpert;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addMedicineExpert.setVisible(true);
    }
}
