/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medcinemanagement;

import clinicmanagement.view.manager.AddEmployee_Admin;
import clinicmanagement.view.manager.AddMedicine_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultMedicineManagementAddButtonListener extends MouseAdapter implements MedicineManagementAddButtonListener {
    @Inject
    private AddMedicine_Admin addMedicineAdmin;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addMedicineAdmin.setVisible(true);
    }
}
