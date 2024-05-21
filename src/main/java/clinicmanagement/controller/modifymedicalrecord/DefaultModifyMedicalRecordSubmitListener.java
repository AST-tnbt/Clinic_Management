/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicalrecord;

import clinicmanagement.constant.LoginName;
import clinicmanagement.constant.MedicalRecordName;
import clinicmanagement.constant.ModifyEmployeeName;
import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.EmployeeManagement_Admin;
import clinicmanagement.view.manager.MedicalRecord_Admin;
import clinicmanagement.view.manager.ModifyEmployee_Admin;
import clinicmanagement.view.manager.ModifyMedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyMedicalRecordSubmitListener implements ModifyMedicalRecordSubmitListener {
    @Inject
    private MedicalRecord_Admin medicalRecordAdmin;
    @Inject
    private ModifyMedicalRecord_Admin modifyMedicalRecordAdmin;
    @Inject @Named(ModifyMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(ModifyMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject @Named(ModifyMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject @Named(ModifyMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject @Named(MedicalRecordName.P_ID)
    private Document patientId;
    @Inject @Named(ModifyMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(ModifyMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(ModifyMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject
    private RoomService roomService;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject @Named(LoginName.USERNAME)
    private Document username;
    @Inject
    private EmployeeService employeeService;

    class Worker extends SwingWorker<Boolean, Integer> {
        @Override
        protected Boolean doInBackground() throws Exception {
            int p_Id = Integer.parseInt(DocumentUtil.getText(patientId));
            String diagnosis = DocumentUtil.getText(inputDiagnosis);
            String room = DocumentUtil.getText(inputRoom);
            String status = (String) inputStatus.getSelectedItem();
            if (
                diagnosis.isEmpty() || room.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            try {
                medicalRecordService.updateMedicalRecord(medicalRecordService.getIdByPatientId(p_Id), roomService.getIdByName(room), prescriptionService.getListPrescription().size(), employeeService.getIdByUsername(DocumentUtil.getText(username)), p_Id, DocumentUtil.getText(inputAppointmentDate), diagnosis, status);
                modifyMedicalRecordAdmin.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(inputDiagnosis);
            DocumentUtil.removeText(inputDateOfBirth);
            DocumentUtil.removeText(inputRoom);
            DocumentUtil.removeText(inputAppointmentDate);
            DocumentUtil.removeText(inputName);
            modifyMedicalRecordAdmin.setVisible(false);
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
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
