package clinicmanagement.controller.patientmanagement.expert;

import com.google.inject.ImplementedBy;

import java.awt.event.MouseListener;


@ImplementedBy(DefaultExpertPatientManagementModifyButtonListener.class)
public interface ExpertPatientManagementModifyButtonListener extends MouseListener {}
