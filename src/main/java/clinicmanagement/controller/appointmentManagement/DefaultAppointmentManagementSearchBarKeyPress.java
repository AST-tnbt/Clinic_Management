package clinicmanagement.controller.appointmentManagement;

import clinicmanagement.constant.AppointmentManagementName;
import clinicmanagement.controller.appointmentManagement.worker.ShowAppointmentWorker;
import clinicmanagement.model.service.AppointmentService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultAppointmentManagementSearchBarKeyPress extends KeyAdapter implements AppointmentManagementSearchBarKeyPress {
    @Inject @Named(AppointmentManagementName.APPOINTMENT_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowAppointmentWorker> showAppointmentWorkerProvider;
    @Inject
    private AppointmentService appointmentService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).equals("")) {
            showAppointmentWorkerProvider.get().refreshTable(appointmentService.getListAppointment());
        }
    }
}
