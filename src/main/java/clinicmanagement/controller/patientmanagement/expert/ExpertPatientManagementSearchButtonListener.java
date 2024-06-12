package clinicmanagement.controller.patientmanagement.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultExpertPatientManagementSearchButtonListener.class)
public interface ExpertPatientManagementSearchButtonListener extends ActionListener {}
