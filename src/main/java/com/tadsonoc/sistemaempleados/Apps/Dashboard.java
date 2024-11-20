package com.tadsonoc.sistemaempleados.Apps;

import com.tadsonoc.sistemaempleados.Models.WindowSize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Dashboard extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Dashboard.class.getResource(
                        "/com/tadsonoc/sistemaempleados/Views/dashboard-view.fxml"));
        Scene scene = new Scene(
                fxmlLoader.load(),
                WindowSize.getDashboard()[0],
                WindowSize.getDashboard()[1]);
        stage.setTitle("Sistema De Empleados - Dashboard");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
