package com.limt.Controllers;

import com.limt.Models.Book;
import com.limt.Models.IssueBook;
import com.limt.Models.ReturnBook;
import com.limt.Models.Student;
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

import java.net.URL;
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
    private TableColumn<Book, Integer> bookListRemainingCol;

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
        bookListRemainingCol.setCellValueFactory(new PropertyValueFactory<>("Remaining"));
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

    @FXML
    void HandleFindBook(ActionEvent event) {
        String searchField = bookListSearchField.getText().toLowerCase();
        String filter = bookListChoiceBox.getValue();
        ObservableList<Book> filteredList = FXCollections.observableArrayList();

        for (Book book : bookListTableView.getItems()) {
            switch (filter) {
                case "ID":
                    if (book.getID().toLowerCase().contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
                case "ISBN":
                    if (book.getISBN().toLowerCase().contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
                case "Title":
                    if (book.getTitle().toLowerCase().contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
                case "Author":
                    if (book.getAuthor().toLowerCase().contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
                case "Category":
                    if (book.getCategory().toLowerCase().contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
                case "Publisher":
                    if (book.getPublisher().toLowerCase().contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
                case "Quantity":
                    if (String.valueOf(book.getQuantity()).contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
                case "Remaining":
                    if (String.valueOf(book.getRemaining()).contains(searchField)) {
                        filteredList.add(book);
                    }
                    break;
            }
        }

        bookListTableView.setItems(filteredList);
    }

    @FXML
    void HandleFindIssueBook(ActionEvent event) {
        String searchField = issueBookListSearchField.getText().toLowerCase();
        String filter = issueBookListChoiceBox.getValue();
        ObservableList<IssueBook> filteredList = FXCollections.observableArrayList();

        for (IssueBook issueBook : issueBookListTableView.getItems()) {
            switch (filter) {
                case "IssueID":
                    if (String.valueOf(issueBook.getIssueID()).contains(searchField)) {
                        filteredList.add(issueBook);
                    }
                    break;
                case "BookID":
                    if (issueBook.getBookID().toLowerCase().contains(searchField)) {
                        filteredList.add(issueBook);
                    }
                    break;
                case "BookISBN":
                    if (issueBook.getBookISBN().toLowerCase().contains(searchField)) {
                        filteredList.add(issueBook);
                    }
                    break;
                case "BookTitle":
                    if (issueBook.getBookTitle().toLowerCase().contains(searchField)) {
                        filteredList.add(issueBook);
                    }
                    break;
                case "StudentID":
                    if (String.valueOf(issueBook.getStudentID()).contains(searchField)) {
                        filteredList.add(issueBook);
                    }
                    break;
                case "StudentName":
                    if (issueBook.getStudentName().toLowerCase().contains(searchField)) {
                        filteredList.add(issueBook);
                    }
                    break;
                case "IssueDate":
                    if (issueBook.getIssueDate().toString().toLowerCase().contains(searchField)) {
                        filteredList.add(issueBook);
                    }
                    break;
            }
        }

        issueBookListTableView.setItems(filteredList);
    }

    @FXML
    void HandleFindReturnBook(ActionEvent event) {
        String searchField = returnBookListSearchField.getText().toLowerCase();
        String filter = returnBookListChoiceBox.getValue();
        ObservableList<ReturnBook> filteredList = FXCollections.observableArrayList();

        for (ReturnBook returnBook : returnBookListTableView.getItems()) {
            switch (filter) {
            case "IssueID":
                if (String.valueOf(returnBook.getIssueID()).contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "BookID":
                if (returnBook.getBookID().toLowerCase().contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "BookISBN":
                if (returnBook.getBookISBN().toLowerCase().contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "BookTitle":
                if (returnBook.getBookTitle().toLowerCase().contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "StudentID":
                if (String.valueOf(returnBook.getStudentID()).contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "StudentName":
                if (returnBook.getStudentName().toLowerCase().contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "IssueDate":
                if (returnBook.getIssueDate().toString().toLowerCase().contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "ReturnDate":
                if (returnBook.getReturnDate().toString().toLowerCase().contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            case "Days":
                if (String.valueOf(returnBook.getDays()).contains(searchField)) {
                filteredList.add(returnBook);
                }
                break;
            }
        }

        returnBookListTableView.setItems(filteredList);
    }

    @FXML
    void HandleFindStudent(ActionEvent event) {
        String searchField = studentListSearchField.getText().toLowerCase();
        String filter = studentListChoiceBox.getValue();
        ObservableList<Student> filteredList = FXCollections.observableArrayList();

        for (Student student : studentListTableView.getItems()) {
            switch (filter) {
                case "ID":
                    if (student.getStudentID().toLowerCase().contains(searchField)) {
                        filteredList.add(student);
                    }
                    break;
                case "Name":
                    if (student.getStudentName().toLowerCase().contains(searchField)) {
                        filteredList.add(student);
                    }
                    break;
                case "School":
                    if (student.getSchool().toLowerCase().contains(searchField)) {
                        filteredList.add(student);
                    }
                    break;
                case "Email":
                    if (student.getEmail().toLowerCase().contains(searchField)) {
                        filteredList.add(student);
                    }
                    break;
                case "PhoneNumber":
                    if (student.getPhoneNumber().toLowerCase().contains(searchField)) {
                        filteredList.add(student);
                    }
                    break;
                case "AddressLine":
                    if (student.getAddressLine().toLowerCase().contains(searchField)) {
                        filteredList.add(student);
                    }
                    break;
                case "Birthday":
                    if (student.getBirthday().toString().toLowerCase().contains(searchField)) {
                        filteredList.add(student);
                    }
                    break;
            }
        }

        studentListTableView.setItems(filteredList);
    }

    void LoadBookListData() {
        bookListTableView.getItems().clear();
        ObservableList<Book> bookList;

        // query data

        bookListTableView.setItems(bookList);
    }

    void LoadIssueBookListData() {
        issueBookListTableView.getItems().clear();
        ObservableList<IssueBook> issueBookList;

        // query data
        issueBookListTableView.setItems(issueBookList);
    }

    void LoadReturnBookListData() {
        returnBookListTableView.getItems().clear();
        ObservableList<ReturnBook> returnBookList;

        // query data
        returnBookListTableView.setItems(returnBookList);
    }

    void LoadStudentListData() {
        studentListTableView.getItems().clear();
        ObservableList<Student> studentList;

        // query data
        studentListTableView.setItems(studentList);
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

        LoadBookListData();
    }
}
