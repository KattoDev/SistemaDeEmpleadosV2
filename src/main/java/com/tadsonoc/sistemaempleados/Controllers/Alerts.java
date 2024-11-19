package com.tadsonoc.sistemaempleados.Controllers;

import javafx.scene.control.Alert;

public class Alerts {

    /**
     * Creates an alert that shows and wait user interaction
     * @param alertType the alert type
     * @param title the alert title
     * @param body the alert body
     */
    public static void showAlert(Alert.AlertType alertType, String title, String body) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(body);
        alert.showAndWait();
    }
}
