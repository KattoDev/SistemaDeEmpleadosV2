package com.tadsonoc.sistemaempleados.Apps;

import com.tadsonoc.sistemaempleados.Models.WindowSize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Login.class.getResource(
                        "/com/tadsonoc/sistemaempleados/Views/login-view.fxml"));
        Scene scene = new Scene(
                fxmlLoader.load(),
                WindowSize.getLogin()[0],
                WindowSize.getLogin()[1]);
        stage.setTitle("Sistema De Empleados - Login");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
