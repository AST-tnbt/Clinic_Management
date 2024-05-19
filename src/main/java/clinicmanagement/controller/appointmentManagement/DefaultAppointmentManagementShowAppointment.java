/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.appointmentManagement;

import clinicmanagement.constant.AppointmentManagementName;
import clinicmanagement.controller.appointmentManagement.worker.ShowAppointmentWorker;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.AppointmentService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 *
 * @author tin-ast
 */
public class DefaultAppointmentManagementShowAppointment extends ComponentAdapter implements AppointmentManagementShowAppointment {
    @Inject
    private Provider<ShowAppointmentWorker> showAppointmentWorkerProvider;
    @Inject @Named(AppointmentManagementName.APPOINTMENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject
    private AppointmentService appointmentService;

    @Override
    public void componentShown(ComponentEvent e) {
        showAppointmentWorkerProvider.get().refreshTable(appointmentService.getListAppointment());
    }
}
