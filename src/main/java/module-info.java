module kirgaard.addressparser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens kirgaard.addressparser to javafx.fxml;
    opens kirgaard.addressparser.Model to javafx.fxml;
    opens kirgaard.addressparser.Controller to javafx.fxml;

    exports kirgaard.addressparser;
    exports kirgaard.addressparser.Model;
    exports kirgaard.addressparser.Controller;
}