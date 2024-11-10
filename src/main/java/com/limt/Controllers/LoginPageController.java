package com.limt.Controllers;

import com.limt.dbms.DatabaseManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    @FXML
    private Text error_desc;

    @FXML
    private Hyperlink forgot_password_hyperlink;

    @FXML
    private Button login_button;

    @FXML
    private PasswordField password_field;

    @FXML
    private Hyperlink sign_in_hyperlink;

    @FXML
    private Text text_header;

    @FXML
    private TextField username_field;

    public void loginAccount() {
        String username = username_field.getText();
        String password = password_field.getText();

        String sql = "SELECT * FROM User WHERE userName = ? AND password = ?";

        // database
        Connection connect = DatabaseManager.connect();

        try {
            assert connect != null;
            Alert alert;
            System.out.println(username);
            System.out.println(password);
            if(username.isEmpty() || password.isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter all the blank fields");
                alert.showAndWait();
            }
            else
            {
                PreparedStatement preparedStatement = connect.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Successful");
                    alert.showAndWait();
                }
                else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Failed");
                    alert.showAndWait();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        login_button.setOnAction(event -> {
            loginAccount();
        });
    }
}
