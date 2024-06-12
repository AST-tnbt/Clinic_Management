/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.patientmanagement.expert;

import clinicmanagement.view.expert.AddPatient_Expert;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultExpertPatientManagementAddButtonListener extends MouseAdapter implements ExpertPatientManagementAddButtonListener {
    @Inject
    private AddPatient_Expert addPatientExpert;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addPatientExpert.setVisible(true);
    }
}
