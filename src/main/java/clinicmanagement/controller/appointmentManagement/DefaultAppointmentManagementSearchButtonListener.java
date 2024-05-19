package clinicmanagement.controller.appointmentManagement;

import clinicmanagement.constant.AppointmentManagementName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.controller.appointmentManagement.worker.ShowAppointmentWorker;
import clinicmanagement.controller.patientManagement.worker.ShowPatientWorker;
import clinicmanagement.model.entity.Appointment;
import clinicmanagement.model.entity.Patient;
import clinicmanagement.model.service.AppointmentService;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultAppointmentManagementSearchButtonListener implements AppointmentManagementSearchButtonListener {
    @Inject @Named(AppointmentManagementName.APPOINTMENT_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private AppointmentService appointmentService;
    @Inject
    private Provider<ShowAppointmentWorker> showAppointmentWorkerProvider;

    @Override
    public void actionPerformed(ActionEvent e) {
        String patient_name = DocumentUtil.getText(searchInput);
        ArrayList<Appointment> listAppointment = appointmentService.getListAppointment();
        ArrayList<Appointment> listAppointmentFilter = new ArrayList<>();
        for (Appointment appointment : listAppointment) {
            if (String.valueOf(appointment.getOrdinalNumbers()).equals(DocumentUtil.getText(searchInput))) {
                listAppointmentFilter.add(appointment);
            }
        }
        showAppointmentWorkerProvider.get().refreshTable(listAppointmentFilter);
    }
}
