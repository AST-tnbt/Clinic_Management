/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.feemanagement.clerk.worker;

import clinicmanagement.constant.admin.FeeManagementName;
import clinicmanagement.constant.clerk.ClerkFeeManagementName;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.entity.Invoice;
import clinicmanagement.model.service.MedicalRecordService;
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
public class ClerkShowFeeWorker {
    @Inject @Named(ClerkFeeManagementName.FEE_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject
    private PatientService patientService;
    @Inject
    private MedicalRecordService medicalRecordService;
    
    public void refreshTable(ArrayList<Invoice> invoiceArrayList) {
            DefaultTableModel tableModel = (DefaultTableModel) tableModelWrapper.getModel();
            tableModel.setRowCount(0);
            for (Invoice invoice : invoiceArrayList) {
                tableModel.addRow(new String[]{String.valueOf(invoice.getId()), patientService.getNameById(medicalRecordService.getPatientIdById(invoice.getMedicalRecord())), String.valueOf(invoice.getDateExport().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))), String.valueOf(invoice.getTotal())});
            }
    }
}
