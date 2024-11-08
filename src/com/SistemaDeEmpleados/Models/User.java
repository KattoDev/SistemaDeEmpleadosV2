package com.SistemaDeEmpleados.Models;

import com.SistemaDeEmpleados.Controllers.Auth;
import javax.swing.JOptionPane;

/**
 * @author katto
 */
public class User {

    // <editor-fold defaultstate="collapsed" desc="attributes">
    private int id;
    private String name;
    private String address;
    private String birthday;
    private Long phoneNumber;
    private String email;
    private String position;
    private Long salary;
    private String password;
    private int department;
    private Boolean isAdmin;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructors">
    public User() {
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    
    public User(
            int id, String name, String address, String birthday,
            Long phoneNumber, String email, String position, Long salary,
            String password, int department, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
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
        JOptionPane.showMessageDialog(
                null, "Se ha cerrado la sesión con exito.", "Aviso",
                JOptionPane.OK_OPTION);
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + ", name=" + name + ", address=" + address +
                ", birthday=" + birthday + ", phoneNumber=" + phoneNumber +
                ", email=" + email + ", position=" + position +
                ", salary=" + salary + ", password=" + password +
                ", department=" + department + ", isAdmin=" + isAdmin + '}';
    }
    // </editor-fold>
}
