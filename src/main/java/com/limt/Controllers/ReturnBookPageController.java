package com.limt.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReturnBookPageController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private TextField bookAuthorField;

    @FXML
    private TextField bookCategoryField;

    @FXML
    private TextField bookIDField;

    @FXML
    private TextField bookISBNField;

    @FXML
    private TextField bookImagePathField;

    @FXML
    private TextField bookPublisherField;

    @FXML
    private TextField bookTitleField;

    @FXML
    private Button clearAllField;

    @FXML
    private DatePicker issueDate;

    @FXML
    private Label msgLabel;

    @FXML
    private Button returnBookBtn;

    @FXML
    private DatePicker returnDate;

    @FXML
    private Button searchIssueID;

    @FXML
    private TextField searchIssueIDField;

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
    private TextField studentPhoneNumberField;

    @FXML
    private TextField studentSchoolField;

    private Boolean issueIDSearchStatus;

    @FXML
    void HandleClearAllField(ActionEvent event) {
        issueIDSearchStatus = false;
        bookIDField.clear();
        bookISBNField.clear();
        bookTitleField.clear();
        bookAuthorField.clear();
        bookCategoryField.clear();
        bookPublisherField.clear();
        bookImagePathField.clear();
        studentIDField.clear();
        studentNameField.clear();
        studentSchoolField.clear();
        studentEmailField.clear();
        studentPhoneNumberField.clear();
        studentAddressLineField.clear();
        studentBirthdayField.setValue(null);
        issueDate.setValue(null);
    }

    void HandleClearMsgLabel() {
        msgLabel.setText("");
    }

    void HandleSetBehaviourAllField(Boolean status) {
        bookIDField.setDisable(status);
        bookISBNField.setDisable(status);
        bookTitleField.setDisable(status);
        bookAuthorField.setDisable(status);
        bookCategoryField.setDisable(status);
        bookPublisherField.setDisable(status);
        bookImagePathField.setDisable(status);
        studentIDField.setDisable(status);
        studentNameField.setDisable(status);
        studentSchoolField.setDisable(status);
        studentEmailField.setDisable(status);
        studentPhoneNumberField.setDisable(status);
        studentAddressLineField.setDisable(status);
        studentBirthdayField.setDisable(status);
        issueDate.setDisable(status);
    }

    void HandleSetDefaultDateIssue() {
        if(issueIDSearchStatus){
            returnDate.setValue(LocalDate.now());
        }
    }

    @FXML
    void HandleSearchIssueID(ActionEvent event) {

    }

    @FXML
    void HandleReturnBook(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        issueIDSearchStatus = false;
        HandleClearAllField(null);
        HandleClearMsgLabel();
        searchIssueIDField.setText(null);
        HandleSetBehaviourAllField(issueIDSearchStatus);
    }
}
