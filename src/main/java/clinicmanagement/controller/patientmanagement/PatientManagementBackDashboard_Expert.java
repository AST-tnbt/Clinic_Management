package clinicmanagement.controller.patientmanagement;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultPatientManagementBackDashboard_Expert.class)
public interface PatientManagementBackDashboard_Expert extends MouseListener {
}
