package com.limt.Controllers;

import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class AddStudentPageController {

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
            assert connection != null;
            connection.setAutoCommit(false);

            String StudentID = studentIDField.getText();
            String StudentSchool = studentSchoolField.getText();
            String StudentName = studentNameField.getText();
            String Email = studentEmailField.getText();
            String PhoneNumber = studentPhoneNumberFIeld.getText();
            String StudentAddress = studentAddressLineField.getText();
            LocalDate Birthday = studentBirthdayField.getValue();

            String query = "INSERT INTO Student VALUES(? ,? , ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, StudentID);
            preparedStatement.setString(3, StudentName);
            preparedStatement.setString(4, StudentSchool);
            preparedStatement.setString(5, Email);
            preparedStatement.setString(6, PhoneNumber);
            preparedStatement.setString(7, StudentAddress);
            preparedStatement.setDate(8, Date.valueOf(Birthday));

            preparedStatement.execute();
            connection.commit();
            msgLabel.setText("Successfully Added Book");
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    @FXML
    void HandleClearAllField(ActionEvent event) {

    }

    @FXML
    void backto(ActionEvent event) {

    }

}
