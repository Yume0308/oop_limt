package com.limt.Controllers;

import com.limt.Lib.Utils;
import com.limt.Models.Book;
import com.limt.Models.IssueBook;
import com.limt.Models.ReturnBook;
import com.limt.Models.Student;
import com.limt.dbms.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class StatisticsPageController implements Initializable {
    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Tab bookListPane;

    @FXML
    private CheckBox IssueBookListCheckAll;

    @FXML
    private Tab studentListPane;

    @FXML
    private TableColumn<Book, String> bookListAuthorCol;

    @FXML
    private TableColumn<Book, String> bookListCategoryCol;

    @FXML
    private CheckBox bookListCheckAll;

    @FXML
    private TableColumn<Book, CheckBox> bookListCheckCol;

    @FXML
    private ChoiceBox<String> bookListChoiceBox;

    @FXML
    private Button bookListDeleteSelectedItem;

    @FXML
    private Button bookListFindBtn;

    @FXML
    private TableColumn<Book, String> bookListIDCol;

    @FXML
    private TableColumn<Book, String> bookListISBNCol;

    @FXML
    private TableColumn<Book, String> bookListImagePathCol;

    @FXML
    private TableColumn<Book, String> bookListPublisherCol;

    @FXML
    private TableColumn<Book, Integer> bookListQuantityCol;

    @FXML
    private TextField bookListSearchField;

    @FXML
    private TableView<Book> bookListTableView;

    @FXML
    private TableColumn<Book, String> bookListTitleCol;

    @FXML
    private TableColumn<IssueBook, String> issueBookListBookIDCol;

    @FXML
    private TableColumn<IssueBook, String> issueBookListBookISBNCol;

    @FXML
    private TableColumn<IssueBook, String> issueBookListBookTitleCol;

    @FXML
    private TableColumn<IssueBook, CheckBox> issueBookListCheckCol;

    @FXML
    private ChoiceBox<String> issueBookListChoiceBox;

    @FXML
    private Button issueBookListDeleteSelectedItem;

    @FXML
    private Button issueBookListFindBtn;

    @FXML
    private TableColumn<IssueBook, Date> issueBookListIssueDateCol;

    @FXML
    private TableColumn<IssueBook, Integer> issueBookListIssueIDCol;

    @FXML
    private Tab issueBookListPane;

    @FXML
    private TextField issueBookListSearchField;

    @FXML
    private TableColumn<IssueBook, Integer> issueBookListStudentIDCol;

    @FXML
    private TableColumn<IssueBook, Integer> issueBookListStudentNameCol;

    @FXML
    private TableView<IssueBook> issueBookListTableView;

    @FXML
    private TableColumn<ReturnBook, String> returnBookListBookIDCol;

    @FXML
    private TableColumn<ReturnBook, String> returnBookListBookISBNCol;

    @FXML
    private TableColumn<ReturnBook, String> returnBookListBookTitleCol;

    @FXML
    private CheckBox returnBookListCheckAll;

    @FXML
    private ChoiceBox<String> returnBookListChoiceBox;

    @FXML
    private Button returnBookListDeleteSelectedItem;

    @FXML
    private Button returnBookListFindBtn;

    @FXML
    private TableColumn<ReturnBook, Date> returnBookListIssueDateCol;

    @FXML
    private TableColumn<ReturnBook, Integer> returnBookListIssueIDCol;

    @FXML
    private Tab returnBookListPane;

    @FXML
    private TableColumn<ReturnBook, Date> returnBookListReturnDateCol;

    @FXML
    private TableColumn<ReturnBook, Integer> returnBookListDaysCol;

    @FXML
    private TextField returnBookListSearchField;

    @FXML
    private TableColumn<ReturnBook, String> returnBookListStudentIDCol;

    @FXML
    private TableColumn<ReturnBook, String> returnBookListStudentNameCol;

    @FXML
    private TableView<ReturnBook> returnBookListTableView;

    @FXML
    private TableColumn<Student, String> studentListAddressLineCol;

    @FXML
    private TableColumn<String, Date> studentListBirthdayCol;

    @FXML
    private CheckBox studentListCheckAll;

    @FXML
    private ChoiceBox<String> studentListChoiceBox;

    @FXML
    private TableColumn<Student, CheckBox> studentListCheckCol;

    @FXML
    private TableColumn<ReturnBook, CheckBox> returnBookListCheckCol;

    @FXML
    private Button studentListDeleteSelectedItem;

    @FXML
    private Button bookListShowQRBtn;

    @FXML
    private TableColumn<Student, String> studentListEmailCol;

    @FXML
    private Button studentListFindBtn;

    @FXML
    private TableColumn<Student, String> studentListIDCol;

    @FXML
    private TableColumn<Student, String> studentListNameCol;

    @FXML
    private TableColumn<Student, String> studentListPhoneNumberCol;

    @FXML
    private TableColumn<Student, String> studentListSchoolCol;

    @FXML
    private TextField studentListSearchField;

    @FXML
    private TableView<Student> studentListTableView;

    @FXML
    private TabPane tabPane;

    void InitAllBookListColumn() {
        bookListCheckCol.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        bookListIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        bookListISBNCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        bookListTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        bookListAuthorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        bookListCategoryCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
        bookListPublisherCol.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        bookListQuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        bookListImagePathCol.setCellValueFactory(new PropertyValueFactory<>("ImagePath"));
    }

    void InitAllStudentListColumn() {
        studentListCheckCol.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        studentListIDCol.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        studentListNameCol.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        studentListSchoolCol.setCellValueFactory(new PropertyValueFactory<>("School"));
        studentListEmailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        studentListPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        studentListAddressLineCol.setCellValueFactory(new PropertyValueFactory<>("AddressLine"));
        studentListBirthdayCol.setCellValueFactory(new PropertyValueFactory<>("Birthday"));
    }

    void InitAllIssueBookListColumn() {
        issueBookListCheckCol.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        issueBookListIssueIDCol.setCellValueFactory(new PropertyValueFactory<>("IssueID"));
        issueBookListBookIDCol.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        issueBookListBookISBNCol.setCellValueFactory(new PropertyValueFactory<>("BookISBN"));
        issueBookListBookTitleCol.setCellValueFactory(new PropertyValueFactory<>("BookTitle"));
        issueBookListStudentIDCol.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        issueBookListStudentNameCol.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        issueBookListIssueDateCol.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));
    }

    void InitAllReturnBookListColumn() {
        returnBookListCheckCol.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        returnBookListIssueIDCol.setCellValueFactory(new PropertyValueFactory<>("IssueID"));
        returnBookListBookIDCol.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        returnBookListBookISBNCol.setCellValueFactory(new PropertyValueFactory<>("BookISBN"));
        returnBookListBookTitleCol.setCellValueFactory(new PropertyValueFactory<>("BookTitle"));
        returnBookListStudentIDCol.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        returnBookListStudentNameCol.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        returnBookListIssueDateCol.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));
        returnBookListReturnDateCol.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        returnBookListDaysCol.setCellValueFactory(new PropertyValueFactory<>("Days"));
    }

    @FXML
    void HandleSelectAllBook(ActionEvent event) {
        boolean selectAll = bookListCheckAll.isSelected();
        for (Book book : bookListTableView.getItems()) {
            book.getCheckBox().setSelected(selectAll);
        }
    }

    @FXML
    void HandleSelectAllIssueBook(ActionEvent event) {
        boolean selectAll = IssueBookListCheckAll.isSelected();
        for (IssueBook issueBook : issueBookListTableView.getItems()) {
            issueBook.getCheckBox().setSelected(selectAll);
        }
    }

    @FXML
    void HandleSelectAllReturnBook(ActionEvent event) {
        boolean selectAll = returnBookListCheckAll.isSelected();
        for (ReturnBook returnBook : returnBookListTableView.getItems()) {
            returnBook.getCheckBox().setSelected(selectAll);
        }
    }

    @FXML
    void HandleSelectAllStudent(ActionEvent event) {
        boolean selectAll = studentListCheckAll.isSelected();
        for (Student student : studentListTableView.getItems()) {
            student.getCheckBox().setSelected(selectAll);
        }
    }

    @FXML
    void HandleDeleteSelectedBook(ActionEvent event) {
        ObservableList<Book> selectedBooks = FXCollections.observableArrayList();
        for (Book book : bookListTableView.getItems()) {
            if (book.getCheckBox().isSelected()) {
                selectedBooks.add(book);
            }
        }
        bookListTableView.getItems().removeAll(selectedBooks);
    }

    @FXML
    void HandleDeleteSelectedIssueBook(ActionEvent event) {
        ObservableList<IssueBook> selectedIssueBooks = FXCollections.observableArrayList();
        for (IssueBook issueBook : issueBookListTableView.getItems()) {
            if (issueBook.getCheckBox().isSelected()) {
                selectedIssueBooks.add(issueBook);
            }
        }
        issueBookListTableView.getItems().removeAll(selectedIssueBooks);
    }

    @FXML
    void HandleDeleteSelectedReturnBook(ActionEvent event) {
        ObservableList<ReturnBook> selectedReturnBooks = FXCollections.observableArrayList();
        for (ReturnBook returnBook : returnBookListTableView.getItems()) {
            if (returnBook.getCheckBox().isSelected()) {
                selectedReturnBooks.add(returnBook);
            }
        }
        returnBookListTableView.getItems().removeAll(selectedReturnBooks);
    }

    @FXML
    void HandleDeleteSelectedStudent(ActionEvent event) {
        ObservableList<Student> selectedStudents = FXCollections.observableArrayList();
        for (Student student : studentListTableView.getItems()) {
            if (student.getCheckBox().isSelected()) {
                selectedStudents.add(student);
            }
        }
        studentListTableView.getItems().removeAll(selectedStudents);
    }

    ObservableList<Book> bookList = FXCollections.observableArrayList();
    @FXML
    void HandleFindBook(ActionEvent event) {
        bookListTableView.getItems().clear();
        String queryFindBook = "SELECT * FROM Book WHERE ? = ?";
        bookList = FXCollections.observableArrayList();
        String filter = bookListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindBook);
            switch (filter)
            {
                case "All":
                    LoadAllBookListData();
                    return;
                case "ID":
                    queryFindBook = "SELECT * FROM Book WHERE ID = ?";
                    preparedStatement.setInt(1, Integer.parseInt(bookListSearchField.getText().trim()));
                    break;
                case "ISBN":
                    queryFindBook = "SELECT * FROM Book WHERE ISBN = ?";
                    preparedStatement.setString(1, bookListSearchField.getText().trim());
                    break;
                case "Title":
                    queryFindBook = "SELECT * FROM Book WHERE Title = ?";
                    preparedStatement.setString(1, bookListSearchField.getText().trim());
                    break;
                case "Author":
                    queryFindBook = "SELECT * FROM Book WHERE Author = ?";
                    preparedStatement.setString(1, bookListSearchField.getText().trim());
                    break;
                case "Category":
                    queryFindBook = "SELECT * FROM Book WHERE Category = ?";
                    preparedStatement.setString(1, bookListSearchField.getText().trim());
                    break;
                case "Publisher":
                    queryFindBook = "SELECT * FROM Book WHERE Publisher = ?";
                    preparedStatement.setString(1, bookListSearchField.getText().trim());
                    break;
                case "Quantity":
                    queryFindBook = "SELECT * FROM Book WHERE Quantity = ?";
                    preparedStatement.setInt(1, Integer.parseInt(bookListSearchField.getText().trim()));
                    break;
                case "ImagePath":
                    queryFindBook = "SELECT * FROM Book WHERE ImagePath = ?";
                    preparedStatement.setString(1, bookListSearchField.getText().trim());
                    break;
            }
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                bookList.clear();
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getInt("ID"), resultSet.getString("ISBN"), resultSet.getString("Title"), resultSet.getString("Author"), resultSet.getString("Category"), resultSet.getString("Publisher"), resultSet.getInt("Quantity"), resultSet.getString("ImagePath"));
                    bookList.add(book);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bookListTableView.getItems().addAll(bookList);
        System.out.println(queryFindBook);
    }

    ObservableList<IssueBook> issueBookList = FXCollections.observableArrayList();
    @FXML
    void HandleFindIssueBook(ActionEvent event) {
        issueBookListTableView.getItems().clear();
        String queryFindIssueBook = "SELECT * FROM IssueBook WHERE ? = ?";
        issueBookList.clear();
        String filter = issueBookListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            switch (filter)
            {
                case "All":
                    LoadAllIssueBookListData();
                    return;
                case "IssueID":
                    queryFindIssueBook = "SELECT * FROM IssueBook WHERE IssueID = ?";
                    preparedStatement.setInt(1, Integer.parseInt(issueBookListSearchField.getText().trim()));
                    break;
                case "BookID":
                    queryFindIssueBook = "SELECT * FROM IssueBook WHERE BookID = ?";
                    preparedStatement.setInt(1, Integer.parseInt(issueBookListSearchField.getText().trim()));
                    break;
                case "BookISBN":
                    queryFindIssueBook = "SELECT * FROM IssueBook WHERE BookISBN = ?";
                    preparedStatement.setString(1, issueBookListSearchField.getText().trim());
                    break;
                case "BookTitle":
                    queryFindIssueBook = "SELECT * FROM IssueBook WHERE BookTitle = ?";
                    preparedStatement.setString(1, issueBookListSearchField.getText().trim());
                    break;
                case "StudentID":
                    queryFindIssueBook = "SELECT * FROM IssueBook WHERE StudentID = ?";
                    preparedStatement.setString(1, issueBookListSearchField.getText().trim());
                    break;
                case "StudentName":
                    queryFindIssueBook = "SELECT * FROM IssueBook WHERE StudentName = ?";
                    preparedStatement.setString(1, issueBookListSearchField.getText().trim());
                    break;
                case "IssueDate":
                    queryFindIssueBook = "SELECT * FROM IssueBook WHERE IssueDate = ?";
                    preparedStatement.setDate(1, java.sql.Date.valueOf((issueBookListSearchField.getText().trim())));
                    break;
            }
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                issueBookList.clear();
                while (resultSet.next()) {
                    IssueBook issueBook = new IssueBook(
                        resultSet.getInt("IssueID"),
                        resultSet.getInt("BookID"),
                        resultSet.getString("BookISBN"),
                        resultSet.getString("BookTitle"),
                        resultSet.getInt("StudentID"),
                        resultSet.getString("StudentName"),
                        resultSet.getDate("IssueDate")
                    );
                    issueBookList.add(issueBook);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        issueBookListTableView.getItems().addAll(issueBookList);
    }

    ObservableList<ReturnBook> returnBookList = FXCollections.observableArrayList();
    @FXML
    void HandleFindReturnBook(ActionEvent event) {
        returnBookListTableView.getItems().clear();
        String queryFindReturnBook = "SELECT * FROM ReturnBook WHERE ? = ?";
        returnBookList.clear();
        String filter = returnBookListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindReturnBook);
            switch (filter)
            {
                case "All":
                    LoadAllReturnBookListData();
                    return;
                case "IssueID":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE IssueID = ?";
                    preparedStatement.setInt(1, Integer.parseInt(returnBookListSearchField.getText().trim()));
                    break;
                case "BookID":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE BookID = ?";
                    preparedStatement.setInt(1, Integer.parseInt(returnBookListSearchField.getText().trim()));
                    break;
                case "BookISBN":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE BookISBN = ?";
                    preparedStatement.setString(1,(returnBookListSearchField.getText().trim()));
                    break;
                case "BookTitle":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE BookTitle = ?";
                    preparedStatement.setString(1,(returnBookListSearchField.getText().trim()));
                    break;
                case "StudentID":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE StudentID = ?";
                    preparedStatement.setInt(1, Integer.parseInt(returnBookListSearchField.getText().trim()));
                    break;
                case "StudentName":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE StudentName = ?";
                    preparedStatement.setString(1,(returnBookListSearchField.getText().trim()));
                    break;
                case "IssueDate":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE IssueDate = ?";
                    preparedStatement.setDate(1, java.sql.Date.valueOf((returnBookListSearchField.getText().trim())));
                    break;
                case "ReturnDate":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE ReturnDate = ?";
                    preparedStatement.setDate(1, java.sql.Date.valueOf((returnBookListSearchField.getText().trim())));
                    break;
                case "Days":
                    queryFindReturnBook = "SELECT * FROM ReturnBook WHERE Days = ?";
                    preparedStatement.setInt(1, Integer.parseInt(returnBookListSearchField.getText().trim()));
                    break;
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                returnBookList.clear();
                while (resultSet.next()) {
                    ReturnBook returnBook = new ReturnBook(
                        resultSet.getInt("IssueID"),
                        resultSet.getInt("BookID"),
                        resultSet.getString("BookISBN"),
                        resultSet.getString("BookTitle"),
                        resultSet.getInt("StudentID"),
                        resultSet.getString("StudentName"),
                        resultSet.getDate("IssueDate"),
                        resultSet.getDate("ReturnDate"),
                        resultSet.getInt("Days")
                    );
                    returnBookList.add(returnBook);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        returnBookListTableView.getItems().addAll(returnBookList);
    }

    String queryFindStudent = "SELECT * FROM Student WHERE ? = ?";
    ObservableList<Student> studentList = FXCollections.observableArrayList();
    @FXML
    void HandleFindStudent(ActionEvent event) {
        studentListTableView.getItems().clear();
        String queryFindStudent = "SELECT * FROM Student WHERE ? = ?";
        String filter = studentListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindStudent);
            switch (filter)
            {
                case "All":
                    LoadAllStudentListData();
                    return;
                case "StudentID":
                    queryFindStudent = "SELECT * FROM Student WHERE StudentID = ?";
                    preparedStatement.setInt(1, Integer.parseInt(studentListSearchField.getText().trim()));
                    break;
                case "StudentName":
                    queryFindStudent = "SELECT * FROM Student WHERE StudentName = ?";
                    preparedStatement.setString(1, studentListSearchField.getText().trim());
                    break;
                case "School":
                    queryFindStudent = "SELECT * FROM Student WHERE School = ?";
                    preparedStatement.setString(1, studentListSearchField.getText().trim());
                    break;
                case "Email":
                    queryFindStudent = "SELECT * FROM Student WHERE Email = ?";
                    preparedStatement.setString(1, studentListSearchField.getText().trim());
                    break;
                case "PhoneNumber":
                    queryFindStudent = "SELECT * FROM Student WHERE PhoneNumber = ?";
                    preparedStatement.setString(1, studentListSearchField.getText().trim());
                    break;
                case "AddressLine":
                    queryFindStudent = "SELECT * FROM Student WHERE AddressLine = ?";
                    preparedStatement.setString(1, studentListSearchField.getText().trim());
                    break;
                case "Birthday":
                    queryFindStudent = "SELECT * FROM Student WHERE Birthday = ?";
                    preparedStatement.setDate(1, java.sql.Date.valueOf(studentListSearchField.getText().trim()));
                    break;
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                studentList.clear();
                while (resultSet.next()) {
                    Student student = new Student(
                        resultSet.getInt("StudentID"),
                        resultSet.getString("StudentName"),
                        resultSet.getString("School"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("AddressLine"),
                        resultSet.getDate("Birthday")
                    );
                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentListTableView.getItems().addAll(studentList);
    }

    void LoadAllBookListData() {
        String queryFindBook = "SELECT * FROM Book";
        bookList.clear();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindBook);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getInt("ID"), resultSet.getString("ISBN"), resultSet.getString("Title"), resultSet.getString("Author"), resultSet.getString("Category"), resultSet.getString("Publisher"), resultSet.getInt("Quantity"), resultSet.getString("ImagePath"));
                    bookList.add(book);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bookListTableView.getItems().addAll(bookList);
    }

    void LoadAllIssueBookListData() {
        issueBookListTableView.getItems().clear();
        String queryFindIssueBook = "SELECT * FROM IssueBook";
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindIssueBook);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                issueBookList.clear();
                while (resultSet.next()) {
                    IssueBook issueBook = new IssueBook(
                        resultSet.getInt("IssueID"),
                        resultSet.getInt("BookID"),
                        resultSet.getString("BookISBN"),
                        resultSet.getString("BookTitle"),
                        resultSet.getInt("StudentID"),
                        resultSet.getString("StudentName"),
                        resultSet.getDate("IssueDate")
                    );
                    issueBookList.add(issueBook);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        issueBookListTableView.getItems().addAll(issueBookList);
    }

    void LoadAllReturnBookListData() {
        returnBookListTableView.getItems().clear();
        String queryFindReturnBook = "SELECT * FROM ReturnBook";
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindReturnBook);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returnBookList.clear();
                while (resultSet.next()) {
                    ReturnBook returnBook = new ReturnBook(
                        resultSet.getInt("IssueID"),
                        resultSet.getInt("BookID"),
                        resultSet.getString("BookISBN"),
                        resultSet.getString("BookTitle"),
                        resultSet.getInt("StudentID"),
                        resultSet.getString("StudentName"),
                        resultSet.getDate("IssueDate"),
                        resultSet.getDate("ReturnDate"),
                        resultSet.getInt("Days")
                        );
                    returnBookList.add(returnBook);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        returnBookListTableView.getItems().addAll(returnBookList);
    }

    void LoadAllStudentListData() {
        studentListTableView.getItems().clear();
        String queryFindStudent = "SELECT * FROM Student";
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindStudent);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                while (resultSet.next()) {
                    Student student = new Student(resultSet.getInt("StudentID"), resultSet.getString("StudentName"), resultSet.getString("School"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"), resultSet.getString("AddressLine"), resultSet.getDate("Birthday"));
                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        studentListTableView.getItems().addAll(studentList);
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

    public static Integer ID;
    @FXML
    public void HandleShowQrBook() throws IOException {
        Book selectedBook = bookListTableView.getSelectionModel().getSelectedItem();
        if(selectedBook != null) {
            Integer BookID = selectedBook.getID();
            ID = BookID;
            String queryFindBook = "SELECT * FROM Book WHERE ID = " + BookID;
            Connection connection = DatabaseManager.connect();
            assert connection != null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = connection.prepareStatement(queryFindBook);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    byte[] imageBytes = resultSet.getBytes("Qr");
                    ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                    Image image = new Image(bais);
                    System.out.println(image);
                    Utils.HandleAddPage("/fxml/ShowQRPage.fxml");
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void HandleShowQrStudent() throws IOException {
        Student selectedStudent = studentListTableView.getSelectionModel().getSelectedItem();
        if(selectedStudent != null) {
            Integer studentID = selectedStudent.getStudentID();
            ID = studentID;
            String queryFindBook = "SELECT * FROM Student WHERE StudentID = " + studentID;
            Connection connection = DatabaseManager.connect();
            assert connection != null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = connection.prepareStatement(queryFindBook);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    byte[] imageBytes = resultSet.getBytes("Qr");
                    ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                    Image image = new Image(bais);
                    System.out.println(image);
                    Utils.HandleAddPage("/fxml/ShowQRPage.fxml");
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String []filterSearch;

        InitAllBookListColumn();
        filterSearch = null;
        filterSearch = new String[]{"All", "ID", "ISBN", "Title", "Author", "Category", "Publisher", "Quantity", "ImagePath"};
        bookListChoiceBox.getItems().addAll(filterSearch);
        bookListChoiceBox.setValue(filterSearch[0]);

        InitAllIssueBookListColumn();
        filterSearch = null;
        filterSearch = new String[]{"All", "IssueID", "BookID", "BookISBN", "BookTitle", "StudentID", "StudentName", "IssueDate"};
        issueBookListChoiceBox.getItems().addAll(filterSearch);
        issueBookListChoiceBox.setValue(filterSearch[0]);

        InitAllReturnBookListColumn();
        filterSearch = null;
        filterSearch = new String[]{"All", "IssueID", "BookID", "BookISBN", "BookTitle", "StudentID", "StudentName", "IssueDate", "ReturnDate", "Days"};
        returnBookListChoiceBox.getItems().addAll(filterSearch);
        returnBookListChoiceBox.setValue(filterSearch[0]);

        InitAllStudentListColumn();
        filterSearch = null;
        filterSearch = new String[]{"All", "ID", "Name", "School", "Email", "PhoneNumber", "AddressLine", "Birthday"};
        studentListChoiceBox.getItems().addAll(filterSearch);
        studentListChoiceBox.setValue(filterSearch[0]);

        LoadAllBookListData();
        LoadAllIssueBookListData();
        LoadAllReturnBookListData();
        LoadAllStudentListData();
    }


}
