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
    private TextField bookIDField;

    @FXML
    private TextField bookISBNField;

    @FXML
    private TextField bookTitleField;

    @FXML
    private Button clearAllField;

    @FXML
    private Button close;

    @FXML
    private DatePicker issueDate;

    @FXML
    private Button minimize;

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
    private TextField studentIDField;

    @FXML
    private TextField studentNameField;

    private Boolean issueIDSearchStatus;

    private Integer iID;

    @FXML
    void HandleClearAllField(ActionEvent event) {
        issueIDSearchStatus = false;
        bookIDField.clear();
        bookISBNField.clear();
        bookTitleField.clear();
        studentIDField.clear();
        studentNameField.clear();
        issueDate.setValue(null);
    }

    void HandleClearMsgLabel() {
        msgLabel.setText("");
    }

    void HandleSetBehaviourAllField(Boolean status) {
        bookIDField.setDisable(status);
        bookISBNField.setDisable(status);
        bookTitleField.setDisable(status);
        studentIDField.setDisable(status);
        studentNameField.setDisable(status);
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

        String issueID = searchIssueIDField.getText();
        String query = "select * from IssueBook where IssueID = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, issueID);
            rs = pst.executeQuery();
            if (rs.next()) {
                issueIDSearchStatus = true;
                HandleSetBehaviourAllField(issueIDSearchStatus);

                bookIDField.setText(String.valueOf(rs.getInt("BookID")));
                bookISBNField.setText(rs.getString("BookISBN"));
                bookTitleField.setText(rs.getString("BookTitle"));
                studentIDField.setText(String.valueOf(rs.getInt("StudentID")));
                studentNameField.setText(rs.getString("StudentName"));
                issueDate.setValue(rs.getDate("IssuedDate").toLocalDate());
                HandleSetDefaultDateReturn();
                msgLabel.setText("Issue ID is Exits");

                rs.close();
                pst.close();
            }
            else {
                msgLabel.setText("Issue ID Not Found");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HandleReturnBook(ActionEvent event) throws SQLException {
        iID = Integer.valueOf(searchIssueIDField.getText());
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection conn = DatabaseManager.connect();
        conn.setAutoCommit(false);
        assert conn != null;

        String query = "INSERT INTO returnbook (IssueID, BookID, BookISBN, BookTitle, StudentID, StudentName, IssueDate, ReturnDate, Days) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, iID);
            pst.setInt(2, Integer.parseInt(bookIDField.getText()));
            pst.setString(3, bookTitleField.getText());
            pst.setString(4, bookISBNField.getText());
            pst.setInt(5, Integer.parseInt(studentIDField.getText()));
            pst.setString(6, studentNameField.getText());
            pst.setDate(7, Date.valueOf(issueDate.getValue()));
            pst.setDate(8, Date.valueOf(returnDate.getValue()));
            pst.setInt(9, Integer.parseInt(String.valueOf(java.time.temporal.ChronoUnit.DAYS.between(issueDate.getValue(), returnDate.getValue()) + 1)));
            pst.execute();
            conn.commit();

            msgLabel.setText("Successfully Returned Book");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        String query2 = "DELETE FROM IssueBook WHERE IssueID =" + iID;
        try {
            PreparedStatement pst2 = conn.prepareStatement(query2);
            pst2.execute();
            conn.commit();
        }
        catch (SQLException e) {
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
