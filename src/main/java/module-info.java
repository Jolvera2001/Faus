module dev.jolvera.faus {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens dev.jolvera.faus to javafx.fxml;
    exports dev.jolvera.faus;
}