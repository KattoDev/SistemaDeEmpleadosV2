package com.tadsonoc.sistemaempleados.Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class Dashboard {
    @FXML
    // TODO Find a way to inject the requested module here
    private Pane container;

    public void goToProfile(MouseEvent mouseEvent) throws IOException {
        ModuleProfile moduleProfile = DashboardModules.loadModule(container, "/com/tadsonoc/sistemaempleados/Views/Modules/profile.fxml");
        moduleProfile.initializeModule();
    }
}
