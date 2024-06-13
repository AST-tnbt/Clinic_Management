package clinicmanagement.controller.dashboard.clerk;

import clinicmanagement.constant.LoginName;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.Login;
import clinicmanagement.view.clerk.Dashboard_Clerk;
import clinicmanagement.view.manager.Dashboard_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultClerkDashboardLogoutListener extends MouseAdapter implements ClerkDashboardLogoutListener {
    @Inject
    private Dashboard_Clerk dashboard;
    @Inject
    private Login login;
    @Inject @Named(LoginName.USERNAME)
    private Document loginUserName;
    @Inject @Named(LoginName.PASSWORD)
    private Document loginPassword;
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
    public void mouseClicked(MouseEvent e) {
        DocumentUtil.removeText(this.loginUserName);
        DocumentUtil.removeText(this.loginPassword);
        this.dashboard.setVisible(false);
        this.login.setVisible(true);
        invoiceService.removeAllObject();
        medicalRecordService.removeAllObject();
        patientService.removeAllObject();
    }
}
