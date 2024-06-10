package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class InvoiceService {
    @Inject @Named(EntityName.INVOICE)
    private ArrayList<Invoice> listInvoice;
    @Inject
    private DatabaseContext databaseContext;
    @Inject
    private PrescriptionDetailService prescriptionDetailService;
    @Inject
    private MedicineService medicineService;
    @Inject
    private PatientService patientService;
    @Inject
    private MedicalRecordService medicalRecordService;


    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL LayTatCaHoaDon()}";
        CallableStatement pst = con.prepareCall(sqlQuery);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Invoice invoice = new Invoice(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDate(3).toLocalDate(),
                    rs.getBigDecimal(4)
            );
            listInvoice.add(invoice);
        }
    }

    public void addInvoice(int medicalRecordId, String dateExport) throws SQLException {
        LocalDate realDateExport = LocalDate.parse(dateExport, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int nextId = 0;
        for (Invoice invoice : listInvoice) {
            nextId = Math.max(nextId, invoice.getId());
        }
        BigDecimal total = BigDecimal.valueOf(0);
        for (PrescriptionDetail prescriptionDetail : prescriptionDetailService.getListPrescriptionDetail()) {
            if (prescriptionDetail.getPrescriptionId() == medicalRecordService.getPrescriptionIdById(medicalRecordId))
                total = total.add(medicineService.getPriceById(prescriptionDetail.getMedicineId()).multiply(BigDecimal.valueOf(prescriptionDetail.getAmount())));
        }
        for (Patient patient : patientService.getListPatient()) {
            if (patient.getId() == medicalRecordService.getPatientIdById(medicalRecordId)) {
                patient.setTotalCost(patient.getTotalCost().add(total));
            }
        }
        this.listInvoice.add(new Invoice(nextId + 1, medicalRecordId, realDateExport, total));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL ThemHoaDon(?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setInt(1, medicalRecordId);
        stm.setDate(2, Date.valueOf(realDateExport));
        stm.execute();
        con.close();
    }

    public void deleteById(ArrayList<Integer> listId) throws SQLException {
        for (int tmpId : listId) {
            for (int i = 0; i < listInvoice.size(); i++) {
                if (listInvoice.get(i).getId() == tmpId) {
                    listInvoice.remove(i);
                    break;
                }
            }
            Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL XoaHoaDon(?)}";
            CallableStatement stm;
            stm = con.prepareCall(sqlQuery);
            stm.setInt(1, tmpId );
            stm.execute();
            con.close();
        }
    }

    public ArrayList<Invoice> getListInvoice() {
        return listInvoice;
    }

    public void removeAllObject() {
        this.listInvoice.removeAll(listInvoice);
    }

    public void deleteByPrescriptionId(int medicalRecordId) throws SQLException {
        ArrayList<Invoice> list = new ArrayList<>();
        for (Invoice invoice : listInvoice) {
            if (invoice.getMedicalRecord() == medicalRecordId) {
                list.add(invoice);
                Connection con = databaseContext.getConnection();
                String sqlQuery = "{CALL XoaHoaDon(?)}";
                CallableStatement stm;
                stm = con.prepareCall(sqlQuery);
                stm.setInt(1, invoice.getId() );
                stm.execute();
                con.close();
            }
        }
        listInvoice.removeAll(list);
    }

    public void deleteByMedicalRecordId(int medicalRecordId) throws SQLException {
        for (Invoice invoice : listInvoice) {
            if (invoice.getMedicalRecord()==medicalRecordId) {
                Connection con = databaseContext.getConnection();
                String sqlQuery = "{CALL XoaHoaDon(?)}";
                CallableStatement stm;
                stm = con.prepareCall(sqlQuery);
                stm.setInt(1, invoice.getId() );
                stm.execute();
                con.close();

                listInvoice.remove(invoice);
                break;
            }
        }
    }
}
