///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package clinicmanagement.controller.modifymedicalrecord;
//
//import clinicmanagement.constant.ModifyEmployeeName;
//import clinicmanagement.constant.ModifyMedicalRecordName;
//import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
//import clinicmanagement.model.service.EmployeeService;
//import clinicmanagement.model.service.MedicalRecordService;
//import clinicmanagement.model.service.MedicineService;
//import clinicmanagement.util.DocumentUtil;
//import clinicmanagement.view.manager.EmployeeManagement_Admin;
//import clinicmanagement.view.manager.MedicalRecord_Admin;
//import clinicmanagement.view.manager.ModifyEmployee_Admin;
//import clinicmanagement.view.manager.ModifyMedicalRecord_Admin;
//import com.google.inject.Inject;
//import com.google.inject.Provider;
//import com.google.inject.name.Named;
//
//import javax.swing.*;
//import javax.swing.text.Document;
//import java.awt.event.ActionEvent;
//import java.sql.SQLException;
//import java.util.concurrent.ExecutionException;
//
///**
// *
// * @author tin-ast
// */
//public class DefaultModifyMedicalRecordSubmitListener implements ModifyMedicalRecordSubmitListener {
//    @Inject
//    private MedicalRecord_Admin medicalRecordAdmin;
//    @Inject
//    private ModifyMedicalRecord_Admin modifyMedicalRecordAdmin;
//    @Inject @Named(ModifyMedicalRecordName.P_DIAGNOSIS)
//    private Document inputDiagnosis;
//    @Inject @Named(ModifyMedicalRecordName.P_APPOINTMENTDATE)
//    private Document inputAppointmentDate;
//    @Inject @Named(ModifyMedicalRecordName.P_STATUS)
//    private ComboBoxModel inputStatus;
//    @Inject @Named(ModifyMedicalRecordName.P_ROOM)
//    private Document inputRoom;
//    @Inject @Named(ModifyMedicalRecordName.P_NAME)
//    private Document inputName;
//    @Inject @Named(ModifyMedicalRecordName.P_DATEOFBIRTH)
//    private Document inputDateOfBirth;
//    @Inject @Named(ModifyMedicalRecordName.P_SEX)
//    private ComboBoxModel inputSex;
//    @Inject
//    private MedicalRecordService medicalRecordService;
//
//    class Worker extends SwingWorker<Boolean, Integer> {
//        @Override
//        protected Boolean doInBackground() throws Exception {
//            int id = Integer.parseInt(DocumentUtil.getText(emp_ID));
//            String name = DocumentUtil.getText(emp_Name);
//            String position = emp_Position.getSelectedItem().toString();
//            String sex = emp_Sex.getSelectedItem().toString();
//            String address = DocumentUtil.getText(emp_Address);
//            String dateOfBirth = DocumentUtil.getText(emp_DayOfBirth);
//            String phone = DocumentUtil.getText(emp_PhoneNumber);
//            String username = DocumentUtil.getText(emp_Username);
//            String password = DocumentUtil.getText(emp_Password);
//            if (
//                name.isEmpty() ||
//                address.isEmpty() || dateOfBirth.isEmpty() ||
//                    phone.isEmpty() || username.isEmpty() || password.isEmpty()
//            ) {
//                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
//                return false;
//            }
//            try {
//                employeeService.modifyEmployee(id, name, phone, position, dateOfBirth, sex, username, password,  address);
//                modifyEmployeeAdmin.setVisible(false);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
//            return true;
//        }
//
//        @Override
//        protected void done() {
//            DocumentUtil.removeText(emp_ID);
//            DocumentUtil.removeText(emp_Name);
//            DocumentUtil.removeText(emp_Address);
//            DocumentUtil.removeText(emp_DayOfBirth);
//            DocumentUtil.removeText(emp_PhoneNumber);
//            DocumentUtil.removeText(emp_Username);
//            DocumentUtil.removeText(emp_Password);
//            modifyEmployeeAdmin.setVisible(false);
//            try {
//                if (get()) {
//                    JOptionPane.showMessageDialog(null, "Sửa thành công");
//                    showEmployeeWorkerProvider.get().refreshTable(employeeService.getListEmployee());
//                }
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        new Worker().execute();
//    }
//}
