package com.limt.Controllers;

import com.limt.Lib.PasswordHash;
import com.limt.Lib.Utils;
import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {
    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private DatePicker birthday_field;

    @FXML
    private Button create_account_btn;

    @FXML
    private TextField email_field;

    @FXML
    private Label error_msg;

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField phoneNumber_field;

    @FXML
    private TextField username_field;

    @FXML
    void CreateAccount(ActionEvent event) throws SQLException {

        try {
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;
            Connection connection = DatabaseManager.connect();
            connection.setAutoCommit(false);
            assert connection != null;
            PasswordHash passwordHash = new PasswordHash();

            if(Utils.CheckAccountIsExits(username_field.getText()))
            {
                String query = "INSERT INTO user (Username, Salt, PasswordHash, Name, Email, PhoneNumber, Birthday) VALUES (?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username_field.getText());
                preparedStatement.setString(2, passwordHash.getSalt());
                preparedStatement.setString(3, passwordHash.hashPassword(password_field.getText()));
                preparedStatement.setString(4, name_field.getText());
                preparedStatement.setString(5, email_field.getText());
                preparedStatement.setString(6, phoneNumber_field.getText());
                preparedStatement.setDate(7, Date.valueOf(birthday_field.getValue()));
                preparedStatement.execute();
                error_msg.setText("Create account successful");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
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
