package clinicmanagement.controller.patientmanagement.admin;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultPatientManagementBackDashboard.class)
public interface PatientManagementBackDashboard extends MouseListener {
}
