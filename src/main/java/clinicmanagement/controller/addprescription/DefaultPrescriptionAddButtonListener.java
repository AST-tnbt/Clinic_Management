package clinicmanagement.controller.addprescription;

import clinicmanagement.constant.AddMedicalRecordName;
import clinicmanagement.model.service.MedicineService;
import clinicmanagement.model.service.PrescriptionDetailService;
import clinicmanagement.model.service.PrescriptionService;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.AddPrescriptionManagement_Admin;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class DefaultPrescriptionAddButtonListener implements PrescriptionAddButtonListener {
    @Inject @Named(AddMedicalRecordName.P_MEDICINELIST)
    private ComboBoxModel p_medicine;
    @Inject @Named(AddMedicalRecordName.P_AMOUNT)
    private Document p_amount;
    @Inject @Named(AddMedicalRecordName.P_PRESCRIPTION)
    private Document p_prescription;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private MedicineService medicineService;
    @Inject
    PrescriptionService prescriptionService;
    @Inject
    AddPrescriptionManagement_Admin prescriptionManagementAdmin;

    class Worker extends SwingWorker<Boolean, Integer> {
        String in_medicine = p_medicine.getSelectedItem().toString();
        String in_amount = DocumentUtil.getText(p_amount);
        @Override
        protected Boolean doInBackground() {
            if (in_amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui Lòng nhập đầy đủ thông tin");
                return false;
            }
            try {
                prescriptionDetailService.addPrescriptionDetail(medicineService.getIdByName(in_medicine), prescriptionService.getLastId(), Integer.parseInt(in_amount));
                medicineService.decreaseAmountById(medicineService.getIdByName(in_medicine), Integer.parseInt(in_amount));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(e);
            }
            return true;
        }
        @Override
        protected void done() {
            try {
                if(get()) {
                    p_prescription.insertString(p_prescription.getLength(), in_medicine + " : " + in_amount + "\n", null);
                }
            } catch (InterruptedException | ExecutionException | BadLocationException e) {
                throw new RuntimeException(e);
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            new Worker().execute();
    }
}
