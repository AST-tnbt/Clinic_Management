/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addpatient;

import clinicmanagement.constant.admin.AddPatientName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddPatient_Admin;
import clinicmanagement.view.manager.PatientManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.Provider;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tin-ast
 */
public class DefaultAddPatientSubmitListener implements AddPatientSubmitListener {
    @Inject
    private PatientManagement_Admin patientManagement;
    @Inject
    private AddPatient_Admin addPatient;
    @Inject @Named(AddPatientName.P_NAME)
    private Document patient_Name;
    @Inject @Named(AddPatientName.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(AddPatientName.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(AddPatientName.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(AddPatientName.P_PHONENUMBER)
    private Document patient_PhoneNumber;

    @Inject
    private DatabaseContext databaseContext;
    @Inject 
    private Provider<ShowPatientWorker> showPatientWorkerProvider;
    @Inject
    private PatientService patientService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            String name = DocumentUtil.getText(patient_Name);
            String sex = patient_Sex.getSelectedItem().toString();
            String address = DocumentUtil.getText(patient_Address);
            String dateOfBirth = DocumentUtil.getText(patient_DayOfBirth);
            String phone = DocumentUtil.getText(patient_PhoneNumber);
            if (
                name.isEmpty() || address.isEmpty() ||
                dateOfBirth.isEmpty() || phone.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                patientService.addPatient(name, dateOfBirth, sex, address, phone);
                patientManagement.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(patient_Name);
            DocumentUtil.removeText(patient_Address);
            DocumentUtil.removeText(patient_DayOfBirth);
            DocumentUtil.removeText(patient_PhoneNumber);
            addPatient.setVisible(false);
            try {
                if (get()) {
                    showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Worker().execute();
    }
}
