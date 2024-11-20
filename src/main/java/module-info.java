module com.tadsonoc.sistemaempleados {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    exports com.tadsonoc.sistemaempleados.Controllers;
    opens com.tadsonoc.sistemaempleados.Controllers to javafx.fxml;
    exports com.tadsonoc.sistemaempleados.Apps;
    opens com.tadsonoc.sistemaempleados.Apps to javafx.fxml;
}