package com.limt.Controllers;

import com.limt.Lib.Utils;
import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ForgotPasswordPageController implements Initializable {

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
        String sql = "SELECT * FROM User WHERE Email = ?";

        Connection connect = DatabaseManager.connect();

        try {
            assert connect != null;
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                error_msg.setText("Email exists in the database.");
                otp_field.setDisable(false);
                send_otp_btn.setDisable(false);
                verify_otp_btn.setDisable(false);
            } else {
                error_msg.setText("Email does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        String otp = otp_field.getText();
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        String email = "tuandapda2@gmail.com";
        String password_app = "******";    //  Your email password here
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password_app);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_field.getText().trim()));
            message.setSubject("Verify Code");
            message.setText(hide_label.getText().trim());
            Transport.send(message);
        } catch (MessagingException e) {
           e.printStackTrace();
        }
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
    void HandleSubmit(ActionEvent event) {
        String email = email_field.getText();
        String newPassword = new_password_field.getText();
        String sql = "UPDATE User SET Password = ? WHERE Email = ?";

        Connection connect = DatabaseManager.connect();

        try {
            assert connect != null;
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                error_msg.setText("Password updated successfully.");
            } else {
                error_msg.setText("Failed to update password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
