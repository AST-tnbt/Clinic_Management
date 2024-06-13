/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.modifymedicalrecord.admin;

import clinicmanagement.constant.admin.AddMedicalRecordName;
import clinicmanagement.constant.LoginName;
import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.admin.ModifyMedicalRecordName;
import clinicmanagement.controller.medicalrecordmanagement.admin.worker.ShowMedicalRecordWorker;
import clinicmanagement.controller.patientmanagement.admin.worker.ShowPatientWorker;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
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
    private ModifyMedicalRecord_Admin modifyMedicalRecordAdmin;
    @Inject
    @Named(ModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Inject
    @Named(ModifyMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject
    @Named(ModifyMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputAppointmentDate;
    @Inject
    @Named(ModifyMedicalRecordName.P_STATUS)
    private ComboBoxModel inputStatus;
    @Inject
    @Named(ModifyMedicalRecordName.P_ROOM)
    private Document inputRoom;
    @Inject
    @Named(AddMedicalRecordName.P_ID)
    private Document patientId;
    @Inject
    @Named(ModifyMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject
    @Named(ModifyMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject
    @Named(ModifyMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject
    private RoomService roomService;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject
    @Named(LoginName.USERNAME)
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
    @Inject
    @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE)
    private TableModelWrapper medicalRecorTableModelWrapper;
    @Inject
    @Named(MedicalRecordManagementName.MEDICAL_RECORD_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper medicalRecorTableListModelSelectionWrapper;

    class Worker extends SwingWorker<Boolean, Integer> {
        int p_Id = Integer.parseInt(DocumentUtil.getText(patientId));

        @Override
        protected Boolean doInBackground() throws SQLException {
            String room = DocumentUtil.getText(inputRoom);
            String diagnosis = DocumentUtil.getText(inputDiagnosis);
            String appointmentDate = DocumentUtil.getText(inputAppointmentDate);
            String status = (String) inputStatus.getSelectedItem();
            int[] medicalRecordRows = medicalRecorTableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
            int medicalRecordId = Integer.parseInt((String) medicalRecorTableModelWrapper.getModel().getValueAt(medicalRecordRows[0], 0));
            int prescriptionId = medicalRecordService.getPrescriptionIdById(medicalRecordId);
            if (
                    diagnosis.isEmpty() || appointmentDate.isEmpty()
            ) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                return false;
            } else {
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
                    medicalRecordService.updateMedicalRecord(medicalRecordId, p_Id, prescriptionId, employeeService.getNameById(patientService.getDoctorIdById(p_Id)), room, appointmentDate, diagnosis, status);
                    invoiceService.deleteByMedicalRecordId(medicalRecordId);
                    invoiceService.addInvoice(medicalRecordId, appointmentDate);
                    modifyMedicalRecordAdmin.setVisible(false);
                } catch (SQLException e) {
                    medicalRecordService.deleteById(medicalRecordId);
                    patientService.setRoomById(p_Id, 0);
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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
            DocumentUtil.removeText(prescription);
            modifyMedicalRecordAdmin.setVisible(false);
            try {
                if (get()) {
                    patientService.setDoctorIdById(p_Id, 0);
                    showMedicalRecordWorkerProvider.get().refreshTable(medicalRecordService.getListMedicalRecordByPatientId(p_Id));
                    showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                }
            } catch (InterruptedException | ExecutionException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Worker().execute();
    }
}
