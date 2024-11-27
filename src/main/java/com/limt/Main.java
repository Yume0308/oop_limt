package com.limt;

import com.limt.Lib.PasswordHash;
import com.limt.dbms.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage thisStage) throws Exception {
        String fxmlPath = "/fxml/LoginPage.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
