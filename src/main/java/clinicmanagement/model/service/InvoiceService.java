package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.Invoice;
import clinicmanagement.model.entity.PrescriptionDetail;
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

    public void addInvoice(int prescriptionId, String dateExport) throws SQLException {
        LocalDate realDateExport = LocalDate.parse(dateExport, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int nextId = 0;
        for (Invoice invoice : listInvoice) {
            nextId = Math.max(nextId, invoice.getId());
        }
        BigDecimal total = BigDecimal.valueOf(0);
        for (PrescriptionDetail prescriptionDetail : prescriptionDetailService.getListPrescriptionDetail()) {
            if (prescriptionDetail.getPrescriptionId() == prescriptionId)
                total.add(medicineService.getPriceById(prescriptionDetail.getMedicineId()).multiply(BigDecimal.valueOf(prescriptionDetail.getAmount())));
        }
        this.listInvoice.add(new Invoice(nextId + 1, prescriptionId, realDateExport, total));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL ThemHoaDon(?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setInt(1, prescriptionId);
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

}
