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
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReturnBookPageController implements Initializable {
    @FXML
    private Button close;

    @FXML
    private Button minimize;

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

    private Integer iID;

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

    void HandleSetDefaultDateReturn() {
        if(issueIDSearchStatus){
            returnDate.setValue(LocalDate.now());
        }
    }

    @FXML
    void HandleSearchIssueID(ActionEvent event) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection conn = DatabaseManager.connect();
        assert conn != null;

        String query = "select * from ReturnBook where issueid = " + searchIssueIDField.getText();
        try {
            issueIDSearchStatus = true;
            HandleSetBehaviourAllField(issueIDSearchStatus);
            iID = Integer.parseInt(searchIssueIDField.getText());
            msgLabel.setText("Issue ID is Exits");

            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            String query1 = "select * from book where ID = " + rs.getString("BookID");
            String query2 = "select * from student where StudentID = " + rs.getString("StudentID");
            issueDate.setValue(rs.getDate("IssueDate").toLocalDate());

            pst = conn.prepareStatement(query1);
            rs = pst.executeQuery();
            bookIDField.setText(String.valueOf(rs.getInt("ID")));
            bookISBNField.setText(rs.getString("ISBN"));
            bookTitleField.setText(rs.getString("Title"));
            bookAuthorField.setText(rs.getString("Author"));
            bookCategoryField.setText(rs.getString("Category"));
            bookPublisherField.setText(String.valueOf(rs.getInt("Publisher")));
            bookImagePathField.setText(rs.getString("ImagePath"));

            pst = conn.prepareStatement(query2);
            rs = pst.executeQuery();
            studentIDField.setText(String.valueOf(rs.getInt("StudentID")));
            studentNameField.setText(rs.getString("StudentName"));
            studentSchoolField.setText(rs.getString("School"));
            studentEmailField.setText(rs.getString("Email"));
            studentPhoneNumberField.setText(rs.getString("PhoneNumber"));
            studentAddressLineField.setText(rs.getString("AddressLine"));
            studentBirthdayField.setValue(rs.getDate("Birthday").toLocalDate());

            HandleSetDefaultDateReturn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HandleReturnBook(ActionEvent event) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection conn = DatabaseManager.connect();
        conn.setAutoCommit(false);
        assert conn != null;

        String query = "INSERT INTO returnbook (IssueID, BookID, BookTitle, StudentID, StudentName, IssueDate, ReturnDate, Days) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            msgLabel.setText("Successfully Returned Book");

            pst = conn.prepareStatement(query);
            pst.setInt(1, iID);
            pst.setInt(2, Integer.parseInt(bookIDField.getText()));
            pst.setString(3, bookTitleField.getText());
            pst.setInt(4, Integer.parseInt(studentIDField.getText()));
            pst.setString(5, studentNameField.getText());
            pst.setDate(6, Date.valueOf(issueDate.getValue()));
            pst.setDate(7, Date.valueOf(returnDate.getValue()));
            pst.setInt(8, Integer.parseInt(String.valueOf(java.time.temporal.ChronoUnit.DAYS.between(issueDate.getValue(), returnDate.getValue()) + 1)));
            pst.execute();
        } catch (SQLException e)
        {
            e.printStackTrace();
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
        issueIDSearchStatus = false;
        HandleClearAllField(null);
        HandleClearMsgLabel();
        searchIssueIDField.setText(null);
        HandleSetBehaviourAllField(issueIDSearchStatus);
    }
}
