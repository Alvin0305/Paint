module com.example.paint {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.paint to javafx.fxml;
    exports com.example.paint;
}