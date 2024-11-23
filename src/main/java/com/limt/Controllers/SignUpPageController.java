package com.limt.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {

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
    void CreateAccount(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
