/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.patientmanagement;

import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.constant.PatientManagementName_Expert;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker;
import clinicmanagement.controller.patientmanagement.worker.ShowPatientWorker_Expert;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.PatientService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 *
 * @author tin-ast
 */
public class DefaultPatientManagementShowPatient_Expert extends ComponentAdapter implements PatientManagementShowPatient_Expert {
    @Inject private Provider<ShowPatientWorker_Expert> showPatientWorkerProvider;

    @Inject @Named(PatientManagementName_Expert.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;

    @Inject
    PatientService patientService;

    @Override
    public void componentShown(ComponentEvent e) {
        showPatientWorkerProvider.get().refreshTable(patientService.getListPatient());
    }
}
