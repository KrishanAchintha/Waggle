module com.example.waggle {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.waggle to javafx.fxml;
    exports com.example.waggle;
    exports com.example.waggle.Views;
    exports com.example.waggle.Controllers;
    exports com.example.waggle.Models;
    exports com.example.waggle.Controllers.Menu;
    exports com.example.waggle.Controllers.Menu.Animal;
}