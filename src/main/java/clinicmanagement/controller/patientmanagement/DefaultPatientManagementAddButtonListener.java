/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.patientmanagement;

import clinicmanagement.view.manager.AddEmployee_Admin;
import clinicmanagement.view.manager.AddPatient_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultPatientManagementAddButtonListener extends MouseAdapter implements PatientManagementAddButtonListener {
    @Inject
    private AddPatient_Admin addPatientAdmin;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addPatientAdmin.setVisible(true);
    }
}
