/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.view.expert.AddMedicine_Expert;
import clinicmanagement.view.manager.AddMedicine_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultMedicineManagementAddButtonListener_Expert extends MouseAdapter implements MedicineManagementAddButtonListener_Expert {
    @Inject
    private AddMedicine_Expert addMedicineExpert;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addMedicineExpert.setVisible(true);
    }
}
