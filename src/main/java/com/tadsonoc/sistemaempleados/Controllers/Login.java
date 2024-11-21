package com.tadsonoc.sistemaempleados.Controllers;

import com.tadsonoc.sistemaempleados.Apps.Dashboard;
import com.tadsonoc.sistemaempleados.Models.User;
import com.tadsonoc.sistemaempleados.Models.WindowSize;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class Login {
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField password_field;

    public void LoginButtonClick(MouseEvent mevt) throws IOException, URISyntaxException {
        if (!user_field.getText().isEmpty() && !password_field.getText().isEmpty()) {

            User user = new User(user_field.getText(), password_field.getText());

            if (!user.Login()) {
                Alerts.showAlert(
                        Alert.AlertType.ERROR,
                        null,
                        "Usuario o contraseña incorrectos");
            } else {
                Stage stage = (Stage) ((javafx.scene.Node) mevt.getSource()).getScene().getWindow();
                stage.close();
                // Lanzar el Dashboard
                try {
                    Dashboard dashboard = new Dashboard();
                    Stage dashboardStage = new Stage();
                    dashboard.start(dashboardStage);
                } catch (NullPointerException e) {
                    e.getCause();
                }
            }

        } else {
            Alerts.showAlert(
                    Alert.AlertType.WARNING,
                    null,
                    "Por favor rellene todos los campos");
        }
    }
}
