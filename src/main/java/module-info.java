module com.example.waggle {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.net.http;
    requires gson;
    requires java.sql;


//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;
//    requires com.almasb.fxgl.all;

    opens com.example.waggle to javafx.fxml;
    exports com.example.waggle;
    exports com.example.waggle.Views;
    exports com.example.waggle.Controllers;
    exports com.example.waggle.Models;
    exports com.example.waggle.Controllers.Menu;
    exports com.example.waggle.Controllers.Menu.Animal;
    opens com.example.waggle.Controllers to gson;
    exports com.example.waggle.Controllers.Menu.Volunteer;
    exports com.example.waggle.Controllers.Menu.Fund;
}