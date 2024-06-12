package clinicmanagement.controller.patientmanagement.expert;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultExpertPatientManagementBackDashboard.class)
public interface ExpertPatientManagementBackDashboard extends MouseListener {
}
