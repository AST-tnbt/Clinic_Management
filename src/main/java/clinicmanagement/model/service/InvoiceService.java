package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.Invoice;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

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

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL LayTatHoaDon()}";
        CallableStatement pst = con.prepareCall(sqlQuery);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Invoice invoice = new Invoice(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getDate(4).toLocalDate(),
                    rs.getBigDecimal(5)
            );
            listInvoice.add(invoice);
        }
    }

//    public void addEmployee(String name, String position, String dateOfBirth, String sex, String address, String phoneNum, String username, String password) throws SQLException {
//        LocalDate realDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        this.listEmployee.add(new Employee(listEmployee.size()+1, name, position, realDateOfBirth, sex, address, phoneNum, username, password));
//        Connection con = databaseContext.getConnection();
//        String sqlQuery = "{CALL sp_ThemNhanVien(?, ?, ?, ?, ?, ?, ?, ?)}";
//        CallableStatement stm;
//        stm = con.prepareCall(sqlQuery);
//        stm.setString(1, name);
//        stm.setString(2, position);
//        stm.setDate(3, Date.valueOf(realDateOfBirth));
//        stm.setString(4, sex);
//        stm.setString(5, address);
//        stm.setString(6, phoneNum);
//        stm.setString(7, username);
//        stm.setString(8, password);
//        stm.execute();
//        con.close();
//    }

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
