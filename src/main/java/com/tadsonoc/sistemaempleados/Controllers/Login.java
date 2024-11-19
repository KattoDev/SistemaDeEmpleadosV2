package com.tadsonoc.sistemaempleados.Controllers;

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
        if (!("admin").equals(user_field.getText()) && !("admin").equals(password_field.getText())) {
            Alerts.showAlert(Alert.AlertType.INFORMATION, "Titulo de la alerta", "cuerpo de la alerta");
        }
    }
}
