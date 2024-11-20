package com.limt.Controllers;

import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueBookPageController {

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
    private TextField bookQuantityField;

    @FXML
    private TextField bookTitleField;

    @FXML
    private Button clearBookField;

    @FXML
    private Button clearStudentFIeld;

    @FXML
    private Button issueBookBtn;

    @FXML
    private DatePicker issueDate;

    @FXML
    private Label msgLabel;

    @FXML
    private Button searchBookBtn;

    @FXML
    private TextField searchBookID;

    @FXML
    private Button searchStudentBtn;

    @FXML
    private TextField searchStudentID;

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


    @FXML
    void HandleClearAllBookField(ActionEvent event) {

    }

    @FXML
    void HandleClearAllStudentField(ActionEvent event) {

    }

    @FXML
    void HandleIssueBook(ActionEvent event) {

    }

    @FXML
    void HandleSearchBook(ActionEvent event) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection conn = DatabaseManager.connect();
        assert conn != null;

        String BookID = searchBookID.getText();
        String query = "select * from Book where ID = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, BookID);
            rs = pst.executeQuery();
            if (rs.next()) {
                msgLabel.setText("Book Available");
                searchBookBtn.setDisable(false);

                bookAuthorField.setText(rs.getString("Author"));
                bookCategoryField.setText(rs.getString("Category"));
                bookIDField.setText(rs.getString("ID"));
                bookISBNField.setText(rs.getString("ISBN"));
                bookImagePathField.setText(rs.getString("ImagePath"));
                bookPublisherField.setText(rs.getString("Publisher"));
                bookQuantityField.setText(rs.getString("Quantity"));
                bookTitleField.setText(rs.getString("Title"));

                System.out.println(bookAuthorField.getText());
                rs.close();
                pst.close();
            }
            else {
                msgLabel.setText("Book Not Available");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HandleSearchStudent(ActionEvent event) {

    }

}
