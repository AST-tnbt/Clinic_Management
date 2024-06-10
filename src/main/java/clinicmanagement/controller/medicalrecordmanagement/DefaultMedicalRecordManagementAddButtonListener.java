/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medicalrecordmanagement;

import clinicmanagement.constant.AddMedicalRecordName;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddMedicalRecord_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tin-ast
 */
public class DefaultMedicalRecordManagementAddButtonListener extends MouseAdapter implements MedicalRecordManagementAddButtonListener {
    @Inject
    private AddMedicalRecord_Admin addMedicalRecordAdmin;
    @Inject @Named(AddMedicalRecordName.P_APPOINTMENTDATE)
    private Document inputDate;
    @Inject @Named(AddMedicalRecordName.P_NAME)
    private Document patientName;
    @Inject @Named(AddMedicalRecordName.P_DATEOFBIRTH)
    private Document patientDateOfBirth;
    @Inject @Named(AddMedicalRecordName.P_SEX)
    private ComboBoxModel patientSex;
    @Inject @Named(PatientManagementName.PATIENT_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    private TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject
    private PrescriptionService prescriptionService;

    @Override
    public void mouseClicked(MouseEvent e) {
        DocumentUtil.removeText(inputDate);
        DocumentUtil.removeText(patientName);
        DocumentUtil.removeText(patientDateOfBirth);
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        try {
            patientName.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1), null);
            patientDateOfBirth.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 2), null);
            patientSex.setSelectedItem(tableModelWrapper.getModel().getValueAt(rows[0], 3));
            inputDate.insertString(0, LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), null );
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
        addMedicalRecordAdmin.setVisible(true);
    }
}
