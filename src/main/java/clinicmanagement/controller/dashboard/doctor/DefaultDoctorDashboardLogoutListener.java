package clinicmanagement.controller.dashboard.doctor;

import clinicmanagement.constant.LoginName;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.Login;
import clinicmanagement.view.doctor.Dashboard_Doctor;
import clinicmanagement.view.expert.Dashboard_Expert;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDoctorDashboardLogoutListener extends MouseAdapter implements DoctorDashboardLogoutListener {
    @Inject
    private Dashboard_Doctor dashboard;
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
    private PrescriptionService prescriptionService;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject
    private MedicineService medicineService;

    @Override
    public void mouseClicked(MouseEvent e) {
        DocumentUtil.removeText(this.loginUserName);
        DocumentUtil.removeText(this.loginPassword);
        this.dashboard.setVisible(false);
        this.login.setVisible(true);
        patientService.removeAllObject();
        prescriptionService.removeAllObject();
        prescriptionDetailService.removeAllObject();
        medicalRecordService.removeAllObject();
        medicineService.removeAllObject();
    }
}
