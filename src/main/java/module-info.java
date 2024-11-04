module com.limt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.limt to javafx.fxml;
    exports com.limt;
    exports com.limt.Controllers.Admin;
    exports com.limt.Controllers.Client;
    exports com.limt.Controllers.Login;
    exports com.limt.Models;
    exports com.limt.Views;
    exports com.limt.dbms;
//    exports com.limt.Constants;
}
