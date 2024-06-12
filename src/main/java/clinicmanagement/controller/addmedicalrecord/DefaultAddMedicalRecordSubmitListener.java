/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.addmedicalrecord;

import clinicmanagement.constant.admin.AddMedicalRecordName;
import clinicmanagement.constant.LoginName;
import clinicmanagement.controller.medicalrecordmanagement.worker.ShowMedicalRecordWorker;
import clinicmanagement.controller.patientmanagement.admin.worker.ShowPatientWorker;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddMedicalRecord_Admin;
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
public class DefaultAddMedicalRecordSubmitListener implements AddMedicalRecordSubmitListener {
    @Inject
    private AddMedicalRecord_Admin addMedicalRecordAdmin;
    @Inject @Named(AddMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription_p;
    @Inject @Named(AddMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(AddMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject @Named(AddMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject @Named(AddMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject @Named(AddMedicalRecordName.P_ID)
    private Document patientId;
    @Inject @Named(AddMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(AddMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(AddMedicalRecordName.P_SEX)
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
    @Inject
    private PatientService patientService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private Provider<ShowMedicalRecordWorker> showMedicalRecordWorkerProvider;
    @Inject
    private InvoiceService invoiceService;
    @Inject
    private Provider<ShowPatientWorker> showPatientWorkerProvider;

    class Worker extends SwingWorker<Boolean, Integer> {
        int p_Id = Integer.parseInt(DocumentUtil.getText(patientId));
        @Override
        protected Boolean doInBackground() throws SQLException {
            String room = DocumentUtil.getText(inputRoom);
            String diagnosis = DocumentUtil.getText(inputDiagnosis);
            String appointmentDate = DocumentUtil.getText(inputAppointmentDate);
            String status = (String) inputStatus.getSelectedItem();
            String prescription = DocumentUtil.getText(prescription_p);
            if (
                diagnosis.isEmpty() || appointmentDate.isEmpty() || prescription.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            }
            else {
                try {
                    switch (status) {
                        case "Đang điều trị":
                            if (room.isEmpty())
                                patientService.setRoomById(p_Id, 0);
                            else {
                                patientService.setRoomById(p_Id, roomService.getIdByName(room));
                            }
                            break;
                        case "Nhập viện":
                            if (room.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập phòng");
                                patientService.setDoctorIdById(p_Id, 0);
                                return false;
                            }
                            patientService.setRoomById(p_Id, roomService.getIdByName(room));
                            break;
                        case "Đã xuất viện":
                            patientService.setRoomById(p_Id, 0);
                            break;
                    }
                    medicalRecordService.addMedicalRecord(p_Id, prescriptionService.getLastId(), employeeService.getNameById(patientService.getDoctorIdById(p_Id)), room, appointmentDate, diagnosis, status);
                    invoiceService.addInvoice(medicalRecordService.getLastId(), appointmentDate);
                    addMedicalRecordAdmin.setVisible(false);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    patientService.setRoomById(p_Id, 0);
                    patientService.setDoctorIdById(p_Id, 0);
                    prescriptionDetailService.deleteByPrescriptionId(prescriptionService.getLastId());
                    prescriptionService.deleteLastItem();
                    medicalRecordService.deleteById(medicalRecordService.getLastId());
                    throw new RuntimeException(e);
                }
                return true;
            }
        }

        @Override
        protected void done() {
            DocumentUtil.removeText(inputDiagnosis);
            DocumentUtil.removeText(inputDateOfBirth);
            DocumentUtil.removeText(inputRoom);
            DocumentUtil.removeText(inputAppointmentDate);
            DocumentUtil.removeText(inputName);
            DocumentUtil.removeText(prescription_p);
            try {
                patientService.setDoctorIdById(p_Id, 0);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            addMedicalRecordAdmin.setVisible(false);
            try {
                if (get()) {
                    showMedicalRecordWorkerProvider.get().refreshTable(medicalRecordService.getListMedicalRecordByPatientId(p_Id));
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
