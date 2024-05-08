package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Singleton
public class EmployeeService {
    @Inject @Named(EntityName.EMPLOYEE_MODEL)
    private ArrayList<Employee> listEmployee;
    @Inject
    DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
            String sqlQuery = "select * from NHANVIEN";
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(7),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(6)
                );
                listEmployee.add(employee);
            }

    }

    public void addEmployee(String id, String name, String phone, String position, String dateOfBirth, String sex, String username, String password, String address) throws SQLException {
        this.listEmployee.add(new Employee(id, name, phone, position, dateOfBirth, sex, username, password,  address));
        Connection con = databaseContext.getConnection();
        String sqlquery = "insert into NHANVIEN (MaNV, HoTen, ChucVu, NgaySinh, GioiTinh, DiaChi, SoDT, TaiKhoan, MatKhau) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst;
        pst = con.prepareStatement(sqlquery);
        pst.setString(1, id);
        pst.setString(2, name);
        pst.setString(3, position);
        pst.setString(4, dateOfBirth);
        pst.setString(5, sex);
        pst.setString(6, address);
        pst.setString(7, phone);
        pst.setString(8, username);
        pst.setString(9, password);
        pst.executeUpdate();
    }

    public void deleteById(String id) throws SQLException {
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getId().equals(id)) {
                listEmployee.remove(i);
                break;
            }
        }
        Connection con = databaseContext.getConnection();
        String sqlQuery = "delete from NHANVIEN where " + id;
        PreparedStatement pst;
        pst = con.prepareStatement(sqlQuery);
        pst.executeUpdate();
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
}
