package com.limt.Controllers;

import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddStudentPageController implements Initializable {

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Button addStudentBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button clearAllField;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField studentAddressLineField;

    @FXML
    private DatePicker studentBirthdayField;

    @FXML
    private TextField studentEmailField;

    @FXML
    private TextField studentIDField;

    @FXML
    private TextField studentNameField;

    @FXML
    private TextField studentPhoneNumberFIeld;

    @FXML
    private TextField studentSchoolField;

    @FXML
    void HandleAddStudent(ActionEvent event) {
        try {
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;
            Connection connection = DatabaseManager.connect();
            connection.setAutoCommit(false);

            assert connection != null;

            Integer StudentID = Integer.parseInt(studentIDField.getText());
            String StudentSchool = studentSchoolField.getText();
            String StudentName = studentNameField.getText();
            String Email = studentEmailField.getText();
            String PhoneNumber = studentPhoneNumberFIeld.getText();
            String StudentAddress = studentAddressLineField.getText();
            LocalDate Birthday = studentBirthdayField.getValue();

            String query = "INSERT INTO Student VALUES(? ,? , ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, DashboardPageController.getCurrentUserID());
            preparedStatement.setInt(2, StudentID);
            preparedStatement.setString(3, StudentName);
            preparedStatement.setString(4, StudentSchool);
            preparedStatement.setString(5, Email);
            preparedStatement.setString(6, PhoneNumber);
            preparedStatement.setString(7, StudentAddress);
            preparedStatement.setDate(8, Date.valueOf(Birthday));

            preparedStatement.execute();
            connection.commit();
            msgLabel.setText("Successfully Added Student");
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    @FXML
    void HandleClearAllField(ActionEvent event) {
        studentIDField.clear();
        studentNameField.clear();
        studentEmailField.clear();
        studentPhoneNumberFIeld.clear();
        studentAddressLineField.clear();
        studentSchoolField.clear();
        studentBirthdayField.setValue(null);
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
        HandleClearAllField(null);
    }
}
