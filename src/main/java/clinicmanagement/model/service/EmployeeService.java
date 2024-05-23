package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.Callable;

@Singleton
public class EmployeeService {
    @Inject @Named(EntityName.EMPLOYEE_MODEL)
    private ArrayList<Employee> listEmployee;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL sp_LayTatCaNhanVien()}";
        CallableStatement pst = con.prepareCall(sqlQuery);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4).toLocalDate(),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
            );
            listEmployee.add(employee);
        }
        con.close();
    }

    public void addEmployee(String name, String position, String dateOfBirth, String sex, String address, String phoneNum, String username, String password) throws SQLException {
        LocalDate realDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int nextId = 0;
        for (Employee em : listEmployee) {
            nextId = Math.max(nextId, em.getId());
        }
        this.listEmployee.add(new Employee(nextId + 1, name, position, realDateOfBirth, sex, address, phoneNum, username, password));
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL sp_ThemNhanVien(?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement stm;
        stm = con.prepareCall(sqlQuery);
        stm.setString(1, name);
        stm.setString(2, position);
        stm.setDate(3, Date.valueOf(realDateOfBirth));
        stm.setString(4, sex);
        stm.setString(5, address);
        stm.setString(6, phoneNum);
        stm.setString(7, username);
        stm.setString(8, password);
        stm.execute();
        con.close();
    }

    public void deleteById(ArrayList<Integer> listId) throws SQLException {
        for (int tmpId : listId) {
            for (int i = 0; i < listEmployee.size(); i++) {
                if (listEmployee.get(i).getId() == tmpId) {
                    listEmployee.remove(i);
                    break;
                }
            }
            Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL sp_XoaNhanVien(?)}";
            CallableStatement stm;
            stm = con.prepareCall(sqlQuery);
            stm.setInt(1, tmpId );
            stm.execute();
            con.close();
        }
    }

    public String getAccount(String username, String password) {
        for (Employee employee : listEmployee) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return employee.getPosition();
            }
        }
        return "Sai thông tin đăng nhập";
    }

    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    public String getUserNameById(int id) {
        for (Employee emp : listEmployee) {
            if (emp.getId() == id) {
                return emp.getUsername();
            }
        }
        return "";
    }

    public String getPasswordById(int id) {
        for (Employee emp : listEmployee) {
            if (emp.getId() == id) {
                return emp.getPassword();
            }
        }
        return "";
    }

    public void modifyEmployee(int id, String name, String phone, String position, String dateOfBirth, String sex, String username, String password, String address) throws SQLException {
        LocalDate realDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for (Employee emp : listEmployee) {
            if (emp.getId() == id) {
                emp.setName(name);
                emp.setPhoneNum(phone);
                emp.setPosition(position);
                emp.setSex(sex);
                emp.setDateOfBirth(realDateOfBirth);
                emp.setUsername(username);
                emp.setPassword(password);
                emp.setAddress(address);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL sp_SuaNhanVien(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement pst;
        pst = con.prepareCall(sqlQuery);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, position);
        pst.setDate(4, Date.valueOf(realDateOfBirth));
        pst.setString(5, sex);
        pst.setString(6, address);
        pst.setString(7, phone);
        pst.setString(8, username);
        pst.setString(9, password);
        pst.executeUpdate();
        con.close();
    }

    public void removeAllObject() {
        this.listEmployee.removeAll(listEmployee);
    }

    public String getNameById(int doctorId) {
        for (Employee employee : listEmployee) {
            if (employee.getId() == doctorId) return employee.getName();
        }
        return "";
    }

    public int getIdByUsername(String username) {
        for (Employee emp : listEmployee) {
            if (emp.getUsername().equals(username)) return emp.getId();
        }
        return -1;
    }
}
