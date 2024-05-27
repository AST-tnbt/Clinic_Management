package clinicmanagement.controller.addprescriptionmanagement;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import clinicmanagement.constant.AddMedicalRecordName;
import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddPrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultPrescriptionSubmitListener implements PrescriptionSubmitListener {
    @Inject @Named(AddMedicalRecordName.P_PRESCRIPTION)
    private Document m_prescription;
    @Inject @Named(AddMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Inject @Named(AddMedicalRecordName.P_AMOUNT)
    private Document amount;
    @Inject
    private AddPrescriptionManagement_Admin prescriptionManagementAdmin;
    @Inject
    private InvoiceService invoiceService;
    @Inject
    private MedicalRecordService medicalRecordService;
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private PrescriptionService prescriptionService;
    @Inject
    private PatientService patientService;
    @Inject
    private EmployeeService employeeService;


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            prescription.insertString(0, DocumentUtil.getText(m_prescription), null);
            DocumentUtil.removeText(amount);
            DocumentUtil.removeText(m_prescription);
            prescriptionManagementAdmin.setVisible(false);
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
