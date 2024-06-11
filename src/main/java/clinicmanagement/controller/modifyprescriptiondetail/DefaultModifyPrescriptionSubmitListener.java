package clinicmanagement.controller.modifyprescriptiondetail;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import clinicmanagement.constant.admin.ModifyMedicalRecordName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.*;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyPrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultModifyPrescriptionSubmitListener implements ModifyPrescriptionSubmitListener {
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION)
    private Document m_prescription;
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Inject @Named(ModifyMedicalRecordName.P_AMOUNT)
    private Document amount;
    @Inject
    private ModifyPrescriptionManagement_Admin prescriptionManagementAdmin;
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
            if (DocumentUtil.getText(m_prescription).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng kê toa");
                DocumentUtil.removeText(amount);
                DocumentUtil.removeText(m_prescription);
                return;
            }
            DocumentUtil.removeText(prescription);
            prescription.insertString(0, DocumentUtil.getText(m_prescription), null);
            DocumentUtil.removeText(amount);
            DocumentUtil.removeText(m_prescription);
            prescriptionManagementAdmin.setVisible(false);
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
