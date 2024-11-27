package com.limt.Controllers;

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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
        studentListIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        studentListNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
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
        String queryFindBook = "SELECT * FROM book WHERE ? = ?";
        bookList.clear();
        String filter = bookListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindBook);
            preparedStatement.setString(1, filter);
            preparedStatement.setString(2, bookListSearchField.getText().trim());
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                while (resultSet.next()) {
                    bookList.clear();
                    while (resultSet.next()) {
                        Book book = new Book(resultSet.getInt("ID"), resultSet.getString("ISBN"), resultSet.getString("Title"), resultSet.getString("Author"), resultSet.getString("Category"), resultSet.getString("Publisher"), resultSet.getInt("Quantity"), resultSet.getString("ImagePath"));
                        bookList.add(book);
                    }
                }
            } else {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    String queryFindIssueBook = "SELECT * FROM IssueBook WHERE ? = ?";
    ObservableList<IssueBook> issueBookList = FXCollections.observableArrayList();
    @FXML
    void HandleFindIssueBook(ActionEvent event) {
        issueBookList.clear();
        String filter = issueBookListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindIssueBook);
            preparedStatement.setString(1, filter);
            preparedStatement.setString(2, issueBookListSearchField.getText().trim());
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
            } else {

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    String queryFindReturnBook = "SELECT * FROM ReturnBook WHERE ? = ?";
    ObservableList<ReturnBook> returnBookList = FXCollections.observableArrayList();
    @FXML
    void HandleFindReturnBook(ActionEvent event) {
        returnBookList.clear();
        String filter = returnBookListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindReturnBook);
            preparedStatement.setString(1, filter);
            preparedStatement.setString(2, returnBookListSearchField.getText().trim());
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
    }

    String queryFindStudent = "SELECT * FROM Student WHERE ? = ?";
    ObservableList<Student> studentList = FXCollections.observableArrayList();
    @FXML
    void HandleFindStudent(ActionEvent event) {
        String filter = studentListChoiceBox.getValue();
        Connection connection = DatabaseManager.connect();
        assert connection != null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryFindStudent);
            preparedStatement.setString(1, filter);
            preparedStatement.setString(2, studentListSearchField.getText().trim());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                studentList.clear();
                while (resultSet.next()) {
                    Student student = new Student(
                        resultSet.getInt("UserID"),
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
    }

    void LoadBookListData() {
        bookListTableView.getItems().clear();

        // query data

//        bookListTableView.setItems(bookList);
    }

    void LoadIssueBookListData() {
        issueBookListTableView.getItems().clear();

        // query data
//        issueBookListTableView.setItems(issueBookList);
    }

    void LoadReturnBookListData() {
        returnBookListTableView.getItems().clear();

        // query data
//        returnBookListTableView.setItems(returnBookList);
    }

    void LoadStudentListData() {
        studentListTableView.getItems().clear();

        // query data
//        studentListTableView.setItems(studentList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String []filterSearch;

        InitAllBookListColumn();
        filterSearch = null;
        filterSearch = new String[]{"ID", "ISBN", "Title", "Author", "Category", "Publisher", "Quantity", "Remaining"};
        bookListChoiceBox.getItems().addAll(filterSearch);
        bookListChoiceBox.setValue(filterSearch[0]);

        InitAllIssueBookListColumn();
        filterSearch = null;
        filterSearch = new String[]{"IssueID", "BookID", "BookISBN", "BookTitle", "StudentID", "StudentName", "IssueDate"};
        issueBookListChoiceBox.getItems().addAll(filterSearch);
        issueBookListChoiceBox.setValue(filterSearch[0]);

        InitAllReturnBookListColumn();
        filterSearch = null;
        filterSearch = new String[]{"IssueID", "BookID", "BookISBN", "BookTitle", "StudentID", "StudentName", "IssueDate", "ReturnDate", "Days"};
        returnBookListChoiceBox.getItems().addAll(filterSearch);
        returnBookListChoiceBox.setValue(filterSearch[0]);

        InitAllStudentListColumn();
        filterSearch = null;
        filterSearch = new String[]{"ID", "Name", "School", "Email", "PhoneNumber", "AddressLine", "Birthday"};
        studentListChoiceBox.getItems().addAll(filterSearch);
        studentListChoiceBox.setValue(filterSearch[0]);

//        LoadBookListData();
    }
}
