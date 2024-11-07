package com.SistemaDeEmpleados.Models;

import com.SistemaDeEmpleados.Controllers.Auth;

/**
 * @author katto
 */
public class User {

    // <editor-fold defaultstate="collapsed" desc="attributes">
    private int id;
    private String name;
    private String address;
    private String birthDay;
    private Long phoneNumber;
    private String email;
    private String position;
    private Long salary;
    private String password;
    private String department;
    private Boolean isAdmin;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructors">
    public User() {
    }

    public User(int id, String name, String address, String birthDay, Long phoneNumber, String email, String position, Long salary, String password, String department, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.password = password;
        this.department = department;
        this.isAdmin = isAdmin;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getters and setters">
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="methods">
    public boolean authUser() {
        boolean isAuth = new Auth().authUser(this);
        return isAuth;
    }

    public boolean logOut() {
        ActualSession.getInstance().destroyInstance();
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", address=" + address + ", birthDay=" + birthDay + ", phoneNumber=" + phoneNumber + ", email=" + email + ", position=" + position + ", salary=" + salary + ", password=" + password + ", department=" + department + ", isAdmin=" + isAdmin + '}';
    }
    // </editor-fold>
}
