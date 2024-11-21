package com.tadsonoc.sistemaempleados.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class DashboardModules {

    public static <T> T loadModule(Pane container, String resource) throws IOException {
        container.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(DashboardModules.class.getResource(resource));
        // Pane module = FXMLLoader.load(Objects.requireNonNull(Dashboard.class.getResource(resource)));
        Pane module = loader.load();
        container.setOpacity(1);
        container.getChildren().add(module);
        return loader.getController();
    }
}
