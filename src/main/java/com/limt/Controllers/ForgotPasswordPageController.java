package com.limt.Controllers;

import com.limt.Lib.PasswordHash;
import com.limt.Lib.Utils;
import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ForgotPasswordPageController implements Initializable {
    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Button check_email_btn;

    @FXML
    private TextField email_field;

    @FXML
    private Label error_msg;

    @FXML
    private Label hide_label;

    @FXML
    private TextField new_password_field;

    @FXML
    private TextField otp_field;

    @FXML
    private Label otp_msg;

    @FXML
    private Button retrive_password_btn;

    @FXML
    private Button send_otp_btn;

    @FXML
    private Button submit_btn;

    @FXML
    private Button verify_otp_btn;

    @FXML
    void HandleCheckEmailIsExits(ActionEvent event) {
        String email = email_field.getText();
        if(Utils.checkEmail(email) && Utils.CheckEmailIsExits(email)) {
            error_msg.setText("Email exists in the database.");
            otp_field.setDisable(false);
            send_otp_btn.setDisable(false);
            verify_otp_btn.setDisable(false);
        }
        else {
            error_msg.setText("Email does not exist.");
        }
    }

    @FXML
    void HandleRetrivePassword(ActionEvent event) {
        String newPassword = Utils.generateRandomPassword();
        new_password_field.setText(newPassword);
    }

    @FXML
    void HandleSendOTP(ActionEvent event) {
        hide_label.setVisible(true);
        hide_label.setText(Utils.generatedOTP());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Your OTP");
        alert.setHeaderText(null);
        alert.setContentText(hide_label.getText());
        alert.showAndWait();
    }

    @FXML
    void HandleVerifyOTP(ActionEvent event) {
        if(otp_field.getText().trim().equals("")) {
            error_msg.setText("Enter OTP");
            return;
        }
        if(otp_field.getText().trim().equals(hide_label.getText().trim())) {
            error_msg.setText("OTP is true");
            retrive_password_btn.setDisable(false);
            new_password_field.setDisable(false);
        }
    }

    @FXML
    void HandleSubmit(ActionEvent event) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String email = email_field.getText();
        PasswordHash passwordHash = new PasswordHash();
        String newPassword = passwordHash.hashPassword(new_password_field.getText());
        String sql = "UPDATE user SET Salt = ?, PasswordHash = ? WHERE Email = ?";

        Connection connect = DatabaseManager.connect();

        try {
            assert connect != null;
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, passwordHash.getSalt());
            preparedStatement.setString(2, newPassword);
            preparedStatement.setString(3, email);

            int rowsUpdated = preparedStatement.executeUpdate();
            connect.commit();

            if (rowsUpdated > 0) {
                error_msg.setText("Password updated successfully.");
            } else {
                error_msg.setText("Failed to update password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void HandleMinimize(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void HandleClose(ActionEvent actionEvent) {
        ((Stage) close.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
