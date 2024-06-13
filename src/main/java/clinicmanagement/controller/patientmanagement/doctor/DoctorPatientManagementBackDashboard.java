package clinicmanagement.controller.patientmanagement.doctor;
import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;

@ImplementedBy(DefaultDoctorPatientManagementBackDashboard.class)
public interface DoctorPatientManagementBackDashboard extends MouseListener {
}
