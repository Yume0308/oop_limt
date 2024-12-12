package com.limt.Controllers;

import com.limt.Lib.Utils;
import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class IssueBookPageController implements Initializable {
    @FXML
    private TextField bookIDField;

    @FXML
    private TextField bookISBNField;

    @FXML
    private TextField bookTitleField;

    @FXML
    private TextField bookAuthorField;

    @FXML
    private TextField bookPublisherField;

    @FXML
    private TextField bookCategoryField;

    @FXML
    private TextField bookQuantityField;

    @FXML
    private TextField bookImagePathField;

    @FXML
    private Button clearBookField;

    @FXML
    private Button clearStudentFIeld;

    @FXML
    private Button close;

    @FXML
    private Button issueBookBtn;

    @FXML
    private DatePicker issueDate;

    @FXML
    private Button minimize;

    @FXML
    private Label msgLabel;

    @FXML
    private Button scanBookBtn;

    @FXML
    private Button searchBookBtn;

    @FXML
    private Button searchBookBtn1;

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

    private Boolean bookSearchStatus;
    private Boolean studentSearchStatus;

    void HandleClearMsgLabel() {
        msgLabel.setText("");
    }

    @FXML
    void HandleClearAllBookField(ActionEvent event) {
        if(bookSearchStatus){
           bookSearchStatus=false;
        }
        bookIDField.clear();
        bookISBNField.clear();
        bookTitleField.clear();
        bookAuthorField.clear();
        bookCategoryField.clear();
        bookPublisherField.clear();
        bookImagePathField.clear();
        HandleSetBehaviourAllBookField(bookSearchStatus);
    }

    @FXML
    void HandleClearAllStudentField(ActionEvent event) {
        if(studentSearchStatus) {
            studentSearchStatus=false;
        }
        studentIDField.clear();
        studentNameField.clear();
        studentSchoolField.clear();
        studentEmailField.clear();
        studentPhoneNumberField.clear();
        studentAddressLineField.clear();
        studentBirthdayField.setValue(null);
        HandleSetBehaviourAllStudentField(studentSearchStatus);
    }

    void HandleSetBehaviourAllBookField(Boolean status) {
        bookIDField.setDisable(status);
        bookISBNField.setDisable(status);
        bookTitleField.setDisable(status);
        bookAuthorField.setDisable(status);
        bookCategoryField.setDisable(status);
        bookPublisherField.setDisable(status);
        bookQuantityField.setDisable(status);
        bookImagePathField.setDisable(status);
    }

    void HandleSetBehaviourAllStudentField(Boolean status) {
        studentIDField.setDisable(status);
        studentNameField.setDisable(status);
        studentSchoolField.setDisable(status);
        studentEmailField.setDisable(status);
        studentPhoneNumberField.setDisable(status);
        studentAddressLineField.setDisable(status);
        studentBirthdayField.setDisable(status);
    }

    void HandleSetDefaultDateIssue() {
        if(bookSearchStatus && studentSearchStatus){
            issueDate.setValue(LocalDate.now());
        }
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
                bookSearchStatus = true;
                HandleSetBehaviourAllBookField(bookSearchStatus);
                msgLabel.setText("Book Available");
                searchBookBtn.setDisable(false);

                bookAuthorField.setText(rs.getString("Author"));
                bookCategoryField.setText(rs.getString("Category"));
                bookIDField.setText(String.valueOf(rs.getInt("ID")));
                bookISBNField.setText(rs.getString("ISBN"));
                bookImagePathField.setText(rs.getString("ImagePath"));
                bookPublisherField.setText(rs.getString("Publisher"));
                bookQuantityField.setText(rs.getString("Quantity"));
                bookTitleField.setText(rs.getString("Title"));

                HandleSetDefaultDateIssue();
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
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection conn = DatabaseManager.connect();
        assert conn != null;

        String StudentID = searchStudentID.getText();
        String query = "select * from Student where StudentID = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, StudentID);
            rs = pst.executeQuery();
            if (rs.next()) {
                studentSearchStatus = true;
                HandleSetBehaviourAllStudentField(studentSearchStatus);
                msgLabel.setText("Student Available");

                studentIDField.setText(String.valueOf(rs.getInt("StudentID")));
                studentNameField.setText(rs.getString("StudentName"));
                studentSchoolField.setText(rs.getString("School"));
                studentEmailField.setText(rs.getString("Email"));
                studentPhoneNumberField.setText(rs.getString("PhoneNumber"));
                studentAddressLineField.setText(rs.getString("AddressLine"));
                studentBirthdayField.setValue(rs.getDate("Birthday").toLocalDate());

                HandleSetDefaultDateIssue();
                rs.close();
                pst.close();
            }
            else {
                msgLabel.setText("Student Not Available");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HandleIssueBook(ActionEvent event) throws SQLException {
        ResultSet rs = null, rs1 = null, rs2 = null, rs3 = null;
        PreparedStatement pst = null, pst1 = null, pst2 = null, pst3 = null;
        Connection conn = DatabaseManager.connect();
        conn.setAutoCommit(false);
        assert conn != null;

        String bId = searchBookID.getText();
        String sId = searchStudentID.getText();

        String query1 = "select * from book where ID = " + bId + "";
        String query2 = "select * from student where StudentID = " + sId + "";
        String query = "INSERT INTO Issuebook (BookID, BookISBN, BookTitle, StudentID, StudentName, IssuedDate) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            pst1 = conn.prepareStatement(query1);
            rs1 = pst1.executeQuery();

            pst2 = conn.prepareStatement(query2);
            rs2 = pst2.executeQuery();

            if(rs1.next() && rs2.next()) {
                try {
                    pst = conn.prepareStatement(query);

                    pst.setInt(1, Integer.parseInt(bookIDField.getText()));
                    pst.setString(2, bookISBNField.getText());
                    pst.setString(3, bookTitleField.getText());
                    pst.setInt(4, Integer.parseInt(studentIDField.getText()));
                    pst.setString(5, studentNameField.getText());
                    pst.setDate(6, Date.valueOf(issueDate.getValue()));

                    pst.execute();
                    conn.commit();
                    msgLabel.setText("Successfully Issued");
                } catch  (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void HandleMinimize(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void HandleScanQrBook(ActionEvent event) throws IOException {
        openScanner();
    }

    @FXML
    public void HandleClose(ActionEvent actionEvent) {
        ((Stage) close.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookSearchStatus = false;
        studentSearchStatus = false;
        HandleClearAllBookField(null);
        HandleClearAllStudentField(null);
        HandleClearMsgLabel();
        searchBookID.setText(null);
        searchStudentID.setText(null);
    }

    public void openScanner() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ScanQRPage.fxml"));
        Parent root = loader.load();
        ScanQRPageController scanController = loader.getController();

        scanController.setOnBookScannedCallback(book -> {
            bookIDField.setText(String.valueOf(book.getID()));
            bookISBNField.setText(book.getISBN());
            bookTitleField.setText(book.getTitle());
            bookAuthorField.setText(book.getAuthor());
            bookPublisherField.setText(book.getPublisher());
            bookCategoryField.setText(book.getCategory());
            bookQuantityField.setText(String.valueOf(book.getQuantity()));
            bookImagePathField.setText(book.getImagePath());
        });

        scanController.setOnStudentScannedCallback(student -> {
            studentIDField.setText(String.valueOf(student.getStudentID()));
            studentNameField.setText(student.getStudentName());
            studentSchoolField.setText(student.getSchool());
            studentEmailField.setText(student.getEmail());
            studentPhoneNumberField.setText(student.getPhoneNumber());
            studentAddressLineField.setText(student.getAddressLine());
        });

        // Show scanner window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
