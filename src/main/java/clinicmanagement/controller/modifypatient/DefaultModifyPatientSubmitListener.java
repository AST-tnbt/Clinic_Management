/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifypatient;

import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.constant.ModifyPatientName;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import clinicmanagement.view.manager.ModifyPatient_Admin;
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
public class DefaultModifyPatientSubmitListener implements ModifyPatientSubmitListener {
    @Inject
    private ModifyPatient_Admin modifyPatientAdmin;
    @Inject @Named(ModifyPatientName.P_ID)
    private Document patient_ID;
    @Inject @Named(ModifyPatientName.P_NAME)
    private Document patient_Name;
    @Inject @Named(ModifyPatientName.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(ModifyPatientName.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(ModifyPatientName.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(ModifyPatientName.P_PHONENUMBER)
    private Document patient_PhoneNumber;
    @Inject 
    private Provider<ShowPatientWorker> showPatientWorkerProvider;
    @Inject
    private PatientService patientService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            int id = Integer.parseInt(DocumentUtil.getText(patient_ID));
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
                patientService.modifyPatient(id, name, dateOfBirth, sex, address, phone);
                modifyPatientAdmin.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(patient_ID);
            DocumentUtil.removeText(patient_Name);
            DocumentUtil.removeText(patient_Address);
            DocumentUtil.removeText(patient_DayOfBirth);
            DocumentUtil.removeText(patient_PhoneNumber);
            modifyPatientAdmin.setVisible(false);
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
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
