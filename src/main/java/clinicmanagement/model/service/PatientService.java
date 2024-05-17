package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.Patient;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.*;
import java.util.ArrayList;

@Singleton
public class PatientService {
    @Inject @Named(EntityName.PATIENT_MODEL)
    private ArrayList<Patient> listPatient;
    @Inject
    DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
            String sqlQuery = "{CALL LayTatBenhNhan()}";
            CallableStatement stm = con.prepareCall(sqlQuery);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBigDecimal(7)
                );
                listPatient.add(patient);
            }
        con.close();
    }

//    public void addPatients(String id, String name, String position, String dateOfBirth, String sex, String address, String phoneNum, String username, String password) throws SQLException {
//        this.listEmployee.add(new Employee(id, name, position, dateOfBirth, sex, address, phoneNum, username, password));
//        Connection con = databaseContext.getConnection();
//        String sqlquery = "insert into NHANVIEN (MaNV, HoTen, ChucVu, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, TaiKhoan, MatKhau) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement pst;
//        pst = con.prepareStatement(sqlquery);
//        pst.setString(1, id);
//        pst.setString(2, name);
//        pst.setString(3, position);
//        pst.setString(4, dateOfBirth);
//        pst.setString(5, sex);
//        pst.setString(6, address);
//        pst.setString(7, phoneNum);
//        pst.setString(9, username);
//        pst.setString(10, password);
//        pst.executeUpdate();
//    }

//    public void deleteById(String id, ArrayList<String> listId) throws SQLException {
//        for (String tmpId : listId) {
//            for (int i = 0; i < listEmployee.size(); i++) {
//                if (listEmployee.get(i).getId().equals(tmpId)) {
//                    listEmployee.remove(i);
//                    break;
//                }
//            }
//        }
//        Connection con = databaseContext.getConnection();
//        String sqlQuery = "delete from NHANVIEN where " + id;
//        PreparedStatement pst;
//        pst = con.prepareStatement(sqlQuery);
//        pst.executeUpdate();
//    }

    public ArrayList<Patient> getListPatient() {
        return listPatient;
    }

//    public void modifyEmployee(String id, String name, String phone, String position, String dateOfBirth, String sex, String username, String password, String address) throws SQLException {
//        for (Employee emp : listEmployee) {
//            if (emp.getId().equals(id)) {
//                emp.setName(name);
//                emp.setPhoneNum(phone);
//                emp.setPosition(position);
//                emp.setSex(sex);
//                emp.setDateOfBirth(dateOfBirth);
//                emp.setUsername(username);
//                emp.setPassword(password);
//                emp.setAddress(address);
//                break;
//            }
//        }
//        Connection con = databaseContext.getConnection();
//        String sqlQuery = "update NHANVIEN set HoTen = ?, ChucVu = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, TaiKhoan = ?, MatKhau = ? where MaNv = ?";
//        PreparedStatement pst;
//        pst = con.prepareStatement(sqlQuery);
//        pst.setString(1, name);
//        pst.setString(2, position);
//        pst.setString(3, dateOfBirth);
//        pst.setString(4, sex);
//        pst.setString(5, address);
//        pst.setString(6, phone);
//        pst.setString(7, username);
//        pst.setString(8, password);
//        pst.setString(9, id);
//        pst.executeUpdate();
//    }
    public void removeAllObject() {
        this.listPatient.removeAll(listPatient);
    }
}
