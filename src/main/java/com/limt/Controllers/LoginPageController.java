package com.limt.Controllers;

import com.limt.Lib.PasswordHash;
import com.limt.Lib.Utils;
import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label error_msg;

    @FXML
    private Button forgot_password_btn;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button sign_up_btn;

    @FXML
    private TextField username_field;


    private static Integer UserID;
    public static Integer getUserID() { return UserID; }

    void LoadDashboard() {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/DashboardPage.fxml")));
            ((Stage)login_btn.getScene().getWindow()).close();
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
        DashboardPageController.setCurrentUserID(UserID);
    }

    boolean CheckHashingPassword(ResultSet resultSet, String password) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        PasswordHash passwordHash = new PasswordHash();
        passwordHash.setSalt(resultSet.getString("Salt"));
        return passwordHash.verifyPassword(password, passwordHash.hashPassword(password));
    }

    @FXML
    public void loginAccount(ActionEvent actionEvent) {
        String username = username_field.getText();
        String password = password_field.getText();

        String sql = "SELECT * FROM user WHERE Username = ?";

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
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next() & CheckHashingPassword(resultSet, password)) {
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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void HandleForgotPasswordScene(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/ForgotPasswordPage.fxml");
    }

    @FXML
    void HandleSignUpScene(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/SignUpPage.fxml");
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

    public void initialize(URL location, ResourceBundle resources) {

    }
}
