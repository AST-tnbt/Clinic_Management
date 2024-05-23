package clinicmanagement.controller.patientmanagement;

import clinicmanagement.constant.ModifyPatientName;
import clinicmanagement.constant.ModifyPatientName_Expert;
import clinicmanagement.constant.PatientManagementName;
import clinicmanagement.constant.PatientManagementName_Expert;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.view.expert.ModifyPatient_Expert;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultPatientManagementModifyButtonListener_Expert extends MouseAdapter implements PatientManagementModifyButtonListener_Expert {
    @Inject
    ModifyPatient_Expert modifyPatientExpert;
    @Inject @Named(PatientManagementName_Expert.PATIENT_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(PatientManagementName_Expert.PATIENT_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(ModifyPatientName_Expert.P_ID)
    private Document patient_ID;
    @Inject @Named(ModifyPatientName_Expert.P_NAME)
    private Document patient_Name;
    @Inject @Named(ModifyPatientName_Expert.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(ModifyPatientName_Expert.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(ModifyPatientName_Expert.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(ModifyPatientName_Expert.P_PHONENUMBER)
    private Document patient_PhoneNumber;

    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để chỉnh sửa.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 bệnh nhân.");
        }
        else {
            modifyPatientExpert.setVisible(true);
            try {
                this.patient_ID.remove(0, this.patient_ID.getLength());
                this.patient_Name.remove(0, this.patient_Name.getLength());
                this.patient_DayOfBirth.remove(0, this.patient_DayOfBirth.getLength());
                this.patient_PhoneNumber.remove(0, this.patient_PhoneNumber.getLength());
                this.patient_Address.remove(0, this.patient_Address.getLength());

                this.patient_ID.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 0), null);
                this.patient_Name.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1), null);
                this.patient_DayOfBirth.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 2), null);
                this.patient_Sex.setSelectedItem(tableModelWrapper.getModel().getValueAt(rows[0], 3));
                this.patient_PhoneNumber.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 4), null);
                this.patient_Address.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 5), null);
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
