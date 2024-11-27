module com.limt {
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
    requires annotations;
    requires org.xerial.sqlitejdbc;
    requires javafx.media;
    requires webcam.capture;
    requires javafx.swing;
    requires java.net.http;
    requires com.google.gson;
    requires mail;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires org.slf4j;

    opens com.limt.Controllers to javafx.fxml;
    exports com.limt;
    exports com.limt.Controllers;
    exports com.limt.Models;
    exports com.limt.dbms;
}
