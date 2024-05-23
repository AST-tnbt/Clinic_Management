package clinicmanagement.controller.dashboard;

import clinicmanagement.constant.LoginName;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.Login;
import clinicmanagement.view.expert.Dashboard_Expert;
import clinicmanagement.view.manager.Dashboard_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultDashboardExpertLogoutListener extends MouseAdapter implements DashboardExpertLogoutListener {
    @Inject
    private Dashboard_Expert dashboard;
    @Inject
    private Login login;
    @Inject @Named(LoginName.USERNAME)
    private Document loginUserName;
    @Inject @Named(LoginName.PASSWORD)
    private Document loginPassword;
    @Inject
    private PatientService patientService;
    @Inject
    private MedicineService medicineService;

    @Override
    public void mouseClicked(MouseEvent e) {
        DocumentUtil.removeText(this.loginUserName);
        DocumentUtil.removeText(this.loginPassword);
        this.dashboard.setVisible(false);
        this.login.setVisible(true);
        patientService.removeAllObject();
        medicineService.removeAllObject();
    }
}
