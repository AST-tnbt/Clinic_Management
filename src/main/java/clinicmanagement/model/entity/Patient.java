package clinicmanagement.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Patient {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String sex;
    private String address;
    private String phoneNum;
    private BigDecimal totalCost;
    private int roomId;
    private int doctorId;

    public Patient(int id, String name, LocalDate dateOfBirth, String sex, String address, String phoneNum, BigDecimal totalCost, int roomId, int doctorId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.phoneNum = phoneNum;
        this.totalCost = totalCost;
        this.roomId = roomId;
        this.doctorId = doctorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
