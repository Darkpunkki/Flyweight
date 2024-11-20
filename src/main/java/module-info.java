module org.example.flyweight {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.flyweight to javafx.fxml;
    exports org.example.flyweight;
    exports Assignment_1.main;
}