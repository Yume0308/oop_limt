package com.limt.Controllers;

import com.limt.dbms.DatabaseManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
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

    private static Integer UserID;
    public static Integer getUserID() { return UserID; }

    public void loginAccount() {
        String username = username_field.getText();
        String password = password_field.getText();

        String sql = "SELECT * FROM User WHERE Username = ? AND Password = ?";

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
                    SetUser(resultSet);
                    LoadDashboard();
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

    void LoadDashboard() {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/DashboardPage.fxml")));
            ((Stage)login_button.getScene().getWindow()).close();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    void SetUser(ResultSet resultSet) throws SQLException {
        UserID = resultSet.getInt("UserID");
    }
    public void initialize(URL location, ResourceBundle resources) {
        com.limt.Controllers.DashboardPageController.CurrentUserID = UserID;
    }
}
