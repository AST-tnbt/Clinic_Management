/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medicalrecordmanagement.doctor.worker;

import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.doctor.DoctorMedicalRecordManagementName;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.MedicalRecord;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author tin-ast
 */
public class DoctorShowMedicalRecordWorker {
    @Inject @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_TABLE)
    private TableModelWrapper tableModelWrapper;
    
    public void refreshTable(ArrayList<MedicalRecord> medicalRecordArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (MedicalRecord medicalRecord : medicalRecordArrayList) {
                tableModel.addRow(new String[]{String.valueOf(medicalRecord.getId()), String.valueOf(medicalRecord.getAppointmentDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))), medicalRecord.getStatus()});
            }
    }
}
