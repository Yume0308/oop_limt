package com.limt.Lib;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Utils {
    @NotNull
    public static Long generateUserID() {
        Random random = new Random();
        long min = 10000000000000000L;
        long max = 99999999999999999L;
        return random.nextLong((max - min) + 1) + min;
    }

    @NotNull
    public static Long generateBookID() {
        Random random = new Random();
        long min = 100000000000000000L;
        long max = 999999999999999999L;
        return random.nextLong((max - min) + 1) + min;
    }

    @Contract
    public static void setFadeTransition(Parent parent) {
        FadeTransition fadeTransition = new FadeTransition(javafx.util.Duration.minutes(1.2), parent);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
    }

    public static void HandleAddPage(String URL) throws IOException {
        Parent view = FXMLLoader.load(Objects.requireNonNull(Utils.class.getResource(URL)));
        Scene scene = new Scene(view);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
