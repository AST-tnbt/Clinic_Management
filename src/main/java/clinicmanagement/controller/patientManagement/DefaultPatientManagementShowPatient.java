/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.patientManagement;

import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.controller.patientManagement.worker.ShowPatientWorker;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.PatientService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;


/**
 *
 * @author tin-ast
 */
public class DefaultPatientManagementShowPatient extends ComponentAdapter implements PatientManagementShowPatient {
    @Inject private Provider<ShowPatientWorker> showPatientWorkerProvider;

    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;

    @Inject
    PatientService patientService;

    @Override
    public void componentShown(ComponentEvent e) {
        showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
    }
}
