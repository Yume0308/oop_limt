package com.limt.Lib;

import com.limt.dbms.DatabaseManager;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;

public class Utils {
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
        Stage stage = new Stage(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%^&+=";
        Random random = new Random();
        StringBuilder password;
        do {
            password = new StringBuilder();
            for (int i = 0; i < 12; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
            }
        }
        while (!checkPassword(password.toString()));
        return password.toString();
    }

    public static boolean checkPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }

    public static boolean checkEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        String regex = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
        return phoneNumber.matches(regex);
    }

    public static boolean checkBookISBN(String ISBN) {
        String regex = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$";
        return ISBN.matches(regex);
    }

    public static String generatedOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    public static boolean CheckAccountIsExits(String username) {
        String sql = "SELECT * FROM user WHERE Username = ?";

        Connection connect = DatabaseManager.connect();

        try {
            assert connect != null;
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean CheckEmailIsExits(String email) {
        String sql = "SELECT * FROM user WHERE Email = ?";

        Connection connect = DatabaseManager.connect();

        try {
            assert connect != null;
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
