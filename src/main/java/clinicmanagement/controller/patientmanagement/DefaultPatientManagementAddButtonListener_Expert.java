/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.patientmanagement;

import clinicmanagement.view.expert.AddPatient_Expert;
import clinicmanagement.view.manager.AddPatient_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultPatientManagementAddButtonListener_Expert extends MouseAdapter implements PatientManagementAddButtonListener_Expert {
    @Inject
    private AddPatient_Expert addPatientExpert;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addPatientExpert.setVisible(true);
    }
}
