package com.tadsonoc.sistemaempleados.Controllers;

import com.tadsonoc.sistemaempleados.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField password_field;

    @FXML
    protected void LoginButtonClick() {

        if (!user_field.getText().isEmpty() && !password_field.getText().isEmpty()) {

            User user = new User(user_field.getText(), user_field.getText());

            if (!user.Login()) {
                Alerts.showAlert(
                        Alert.AlertType.ERROR,
                        null,
                        "Usuario o contraseña incorrectos");
            } else {
                Alerts.showAlert(Alert.AlertType.INFORMATION, null, "auth");
            }

        } else {
            Alerts.showAlert(
                    Alert.AlertType.WARNING,
                    null,
                    "Por favor rellene todos los campos");
        }
    }
}
