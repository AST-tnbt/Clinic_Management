/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.medicalrecordmanagement;

import clinicmanagement.constant.MedicalRecordName;
import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.model.factory.ModifyMedicalRecordFactory;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyMedicalRecord_Admin;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tin-ast
 */
public class DefaultMedicalRecordManagementModifyButtonListener extends MouseAdapter implements MedicalRecordManagementModifyButtonListener {
    @Inject
    private ModifyMedicalRecord_Admin modifyMedicalRecordAdmin;
    @Inject @Named(MedicalRecordName.P_NAME)
    private Document name;
    @Inject @Named(MedicalRecordName.P_DATEOFBIRTH)
    private Document dateOfBirth;
    @Inject @Named(MedicalRecordName.P_SEX)
    private ComboBoxModel sex;
    @Inject @Named(ModifyMedicalRecordName.P_NAME)
    private Document inputName;
    @Inject @Named(ModifyMedicalRecordName.P_DATEOFBIRTH)
    private Document inputDateOfBirth;
    @Inject @Named(ModifyMedicalRecordName.P_SEX)
    private ComboBoxModel inputSex;
    @Inject @Named(ModifyMedicalRecordName.P_PRESCRIPTION)
    private Document prescription;
    @Inject @Named(ModifyMedicalRecordName.P_AMOUNT)
    private Document inputAmount;
    @Inject @Named(ModifyMedicalRecordName.P_DIAGNOSIS)
    private Document inputDiagnosis;
    @Inject @Named(ModifyMedicalRecordName.P_ROOM)
    private Document inputRoom;

    @Override
    public void mouseClicked(MouseEvent e) {
        modifyMedicalRecordAdmin.setVisible(true);
        try {
            this.inputName.remove(0, this.inputName.getLength());
            this.inputDateOfBirth.remove(0, this.inputDateOfBirth.getLength());
            this.inputAmount.remove(0, this.inputDateOfBirth.getLength());
            this.prescription.remove(0, this.inputDateOfBirth.getLength());
            this.inputDiagnosis.remove(0, this.inputDateOfBirth.getLength());
            this.inputRoom.remove(0, this.inputDateOfBirth.getLength());

            this.inputName.insertString(0, DocumentUtil.getText(name), null);
            this.inputDateOfBirth.insertString(0, DocumentUtil.getText(dateOfBirth), null);
            this.inputSex.setSelectedItem(sex.getSelectedItem());
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
