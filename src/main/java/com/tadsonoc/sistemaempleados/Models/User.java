package com.tadsonoc.sistemaempleados.Models;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tadsonoc.sistemaempleados.Controllers.APIClient;
import com.tadsonoc.sistemaempleados.Controllers.Alerts;
import javafx.scene.control.Alert;

/**
 * @author katto
 */
public class User {

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

    public User() {
    }

    public User(String email, String password) {
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

    public boolean Login() {

        JsonArray jsonArray = new APIClient().fetch("users/" + getEmail() + "-" + getPassword());
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

        if (!(jsonObject.has("error")) && !(jsonObject.has("message"))) {
            User authUser = new User(
                    jsonObject.get("id").getAsInt(),
                    jsonObject.get("name").getAsString(),
                    jsonObject.get("address").getAsString(),
                    jsonObject.get("birthday").getAsString(),
                    jsonObject.get("phoneNumber").getAsLong(),
                    getEmail(),
                    jsonObject.get("position").getAsString(),
                    jsonObject.get("salary").getAsLong(),
                    getPassword(),
                    jsonObject.get("department").getAsInt(),
                    jsonObject.get("isAdmin").getAsBoolean()
            );
            ActualSession.getInstance().setUser(authUser);
            return true;
        }

        return false;
    }

    /**
     * Logs out the actual user of the app destroying the {@link ActualSession}
     *
     * @return true if the user is logged out the app
     */
    public boolean LogOut() {
        ActualSession.getInstance().destroyInstance();
        Alerts.showAlert(Alert.AlertType.CONFIRMATION, "Aviso", "Se ha cerrado la sesión con exito");
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", password='" + password + '\'' +
                ", department=" + department +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
