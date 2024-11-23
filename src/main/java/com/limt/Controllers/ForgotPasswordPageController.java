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
//        String from = "******@gmail.com";
//        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true");
//        String username = "******@gmail.com";
//        String password = "******";    //  Your email password here
//        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//            message.setSubject("Verify Code");
//            message.setText(code);
//            Transport.send(message);
//            ms.setSuccess(true);
//        } catch (MessagingException e) {
//           e.printStackTrace();
//        }
    }

    @FXML
    void HandleVerifyOTP(ActionEvent event) {

    }

    @FXML
    void HandleSubmit(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
