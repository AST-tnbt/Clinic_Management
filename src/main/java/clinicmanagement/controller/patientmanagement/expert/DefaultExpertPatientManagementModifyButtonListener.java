package clinicmanagement.controller.patientmanagement.expert;

import clinicmanagement.constant.admin.ModifyPatientName;
import clinicmanagement.constant.admin.PatientManagementName;
import clinicmanagement.constant.expert.ExpertModifyPatientName;
import clinicmanagement.constant.expert.ExpertPatientManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.expert.ModifyPatient_Expert;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultExpertPatientManagementModifyButtonListener extends MouseAdapter implements ExpertPatientManagementModifyButtonListener {
    @Inject
    ModifyPatient_Expert modifyPatientExpert;
    @Inject @Named(ExpertPatientManagementName.PATIENT_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(ExpertPatientManagementName.PATIENT_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(ExpertModifyPatientName.P_ID)
    private Document patient_ID;
    @Inject @Named(ExpertModifyPatientName.P_NAME)
    private Document patient_Name;
    @Inject @Named(ExpertModifyPatientName.P_SEX)
    private ComboBoxModel patient_Sex;
    @Inject @Named(ExpertModifyPatientName.P_ADDRESS)
    private Document patient_Address;
    @Inject @Named(ExpertModifyPatientName.P_DAYOFBIRTH)
    private Document patient_DayOfBirth;
    @Inject @Named(ExpertModifyPatientName.P_PHONENUMBER)
    private Document patient_PhoneNumber;
    @Inject
    private PatientService patientService;

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
                DocumentUtil.removeText(this.patient_ID);
                DocumentUtil.removeText(this.patient_Name);
                DocumentUtil.removeText(this.patient_DayOfBirth);
                DocumentUtil.removeText(this.patient_PhoneNumber);
                DocumentUtil.removeText(this.patient_Address);

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
