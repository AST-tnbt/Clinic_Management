/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.appointmentManagement.worker;

import clinicmanagement.constant.AppointmentManagementName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Appointment;
import clinicmanagement.model.entity.Patient;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.PatientService;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author tin-ast
 */
public class ShowAppointmentWorker {
    @Inject @Named(AppointmentManagementName.APPOINTMENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject
    private EmployeeService employeeService;
    @Inject
    private PatientService patientService;
    
    public void refreshTable(ArrayList<Appointment> appointmentArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (Appointment appointment : appointmentArrayList) {
                tableModel.addRow(new String[]{String.valueOf(appointment.getId()), String.valueOf(appointment.getOrdinalNumbers()), patientService.getNameById(appointment.getPatientId()), employeeService.getNameById(appointment.getDoctorId())});
            }
    }
}
