package clinicmanagement.controller.prescriptionmanagement;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.model.service.MedicalRecordService;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.PrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.print.Doc;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 *
 * @author tin-ast
 */
public class DefaultPrescriptionSubmitListener implements PrescriptionSubmitListener {
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION)
    private Document m_prescription;
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    private Document prescription;
    @Inject @Named(ModifyMedicalRecordName.P_AMOUNT)
    private Document amount;
    @Inject
    private PrescriptionManagement_Admin prescriptionManagementAdmin;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            m_prescription.insertString(0, DocumentUtil.getText(prescription), null);
            prescriptionManagementAdmin.setVisible(false);
            DocumentUtil.removeText(amount);
            DocumentUtil.removeText(prescription);
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
