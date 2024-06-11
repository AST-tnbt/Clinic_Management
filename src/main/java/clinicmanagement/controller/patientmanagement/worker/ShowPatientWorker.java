/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.patientmanagement.worker;

import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Patient;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author tin-ast
 */
public class ShowPatientWorker {
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    
    public void refreshTable(ArrayList<Patient> patientsArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (Patient patient : patientsArrayList) {
                tableModel.addRow(new String[]{String.valueOf(patient.getId()), patient.getName(), String.valueOf(patient.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))), patient.getSex(), patient.getPhoneNum(), patient.getAddress(), patient.getTotalCost().toString()});
            }
    }
}
