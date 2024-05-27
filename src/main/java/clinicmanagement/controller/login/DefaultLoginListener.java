package clinicmanagement.controller.login;

import clinicmanagement.constant.LoginName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.MedicalRecord;
import clinicmanagement.model.entity.Prescription;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.Login;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 *
 * @author tin-ast
 */
@Singleton
public class DefaultLoginListener implements LoginListener {
    @Inject
    private Login login;
    @Inject
    private Dashboard_Admin dashboard;
    @Inject @Named(LoginName.USERNAME)
    private Document loginUserName;
    @Inject @Named(LoginName.PASSWORD)
    private Document loginPassword;
    @Inject
    private DatabaseContext databaseContext;
    @Inject
    private EmployeeService employeeService;
    @Inject
    private PatientService patientService;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private MedicineService medicineService;
    @Inject
    private RoomService roomService;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject
    private ToolService toolService;
    @Inject
    private InvoiceService invoiceService;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            employeeService.getDatabase();
            String username = DocumentUtil.getText(this.loginUserName);
            String password = DocumentUtil.getText(this.loginPassword);
            if (employeeService.getAccount(username, password).equals("Quản lý")) {
                login.setVisible(false);
                dashboard.setVisible(true);
                patientService.getDatabase();
                medicalRecordService.getDatabase();
                prescriptionDetailService.getDatabase();
                medicineService.getDatabase();
                roomService.getDatabase();
                prescriptionService.getDatabase();
//                toolService.getDatabase();
                invoiceService.getDatabase();
            }
//            else if (employeeService.getAccount(username, password).equals("Chuyên viên")) {
//                login.setVisible(false);
//                dashboardExpert.setVisible(true);
//                patientService.getDatabase();
//                medicineService.getDatabase();
//            }
            else if (employeeService.getAccount(username, password).equals("Sai thông tin đăng nhập")) {
                JOptionPane.showMessageDialog(null, employeeService.getAccount(username, password));
                employeeService.removeAllObject();
                DocumentUtil.removeText(this.loginUserName);
                DocumentUtil.removeText(this.loginPassword);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
