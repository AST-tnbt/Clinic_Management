package clinicmanagement.controller.dashboard;

import clinicmanagement.constant.LoginName;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.Dashboard_Admin;
import clinicmanagement.view.Login;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.text.Document;

public class DefaultDashboardLogoutListener extends MouseAdapter implements DashboardLogoutListener {
    @Inject
    private Dashboard_Admin dashboard;
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
    private AppointmentService appointmentService;
    @Inject
    private RoomService roomService;

    @Override
    public void mouseClicked(MouseEvent e) {
        DocumentUtil.removeText(this.loginUserName);
        DocumentUtil.removeText(this.loginPassword);
        this.dashboard.setVisible(false);
        this.login.setVisible(true);
        employeeService.removeAllObject();
        patientService.removeAllObject();
        medicalRecordService.removeAllObject();
        prescriptionDetailService.removeAllObject();
        appointmentService.removeAllObject();
        medicineService.removeAllObject();
        roomService.removeAllObject();
    }
}
