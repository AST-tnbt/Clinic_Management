package clinicmanagement.model.entity;

public class Employee {
    private int id;
    private String name;
    private String phoneNum;
    private String position;
    private String dateOfBirth;
    private String sex;
    private String username;
    private String password;
    private String address;

    public Employee(int id, String name, String position, String dateOfBirth, String sex, String address, String phoneNum, String username, String password) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPosition() {
        return position;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
