module com.tadsonoc.sistemaempleados {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tadsonoc.sistemaempleados to javafx.fxml;
    exports com.tadsonoc.sistemaempleados;
}