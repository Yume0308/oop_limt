package com.limt.Controllers;

import com.limt.Models.Book;
import com.limt.Models.IssueBook;
import com.limt.Models.ReturnBook;
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

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StatisticsPageController implements Initializable {

    @FXML
    private Tab BookListPane;

    @FXML
    private CheckBox IssueBookListCheckAll;

    @FXML
    private Tab StudentListPane;

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
    private TableColumn<?, ?> returnBookListReturnDateCol;

    @FXML
    private TextField returnBookListSearchField;

    @FXML
    private TableColumn<?, ?> returnBookListStudentIDCol;

    @FXML
    private TableColumn<?, ?> returnBookListStudentNameCol;

    @FXML
    private TableView<?> returnBookListTableView;

    @FXML
    private TableColumn<?, ?> studentListAddressLineCol;

    @FXML
    private TableColumn<?, ?> studentListBirthdayCol;

    @FXML
    private CheckBox studentListCheckAll;

    @FXML
    private ChoiceBox<?> studentListCheckBox;

    @FXML
    private TableColumn<?, ?> studentListCheckCol;

    @FXML
    private Button studentListDeleteSelectedItem;

    @FXML
    private TableColumn<?, ?> studentListEmailCol;

    @FXML
    private Button studentListFindBtn;

    @FXML
    private TableColumn<?, ?> studentListIDCol;

    @FXML
    private TableColumn<?, ?> studentListNameCol;

    @FXML
    private TableColumn<?, ?> studentListPhoneNumberCol;

    @FXML
    private TableColumn<?, ?> studentListSchoolCol;

    @FXML
    private TextField studentListSearchField;

    @FXML
    private TableView<?> studentListTableView;

    @FXML
    private TabPane tabPane;

    @FXML
    void HandleDeleteSelectedBook(ActionEvent event) {

    }

    @FXML
    void HandleDeleteSelectedIssueBook(ActionEvent event) {

    }

    @FXML
    void HandleDeleteSelectedReturnBook(ActionEvent event) {

    }

    @FXML
    void HandleDeleteSelectedStudent(ActionEvent event) {

    }

    @FXML
    void HandleFindBook(ActionEvent event) {

    }

    @FXML
    void HandleFindIssueBook(ActionEvent event) {

    }

    @FXML
    void HandleFindReturnBook(ActionEvent event) {

    }

    @FXML
    void HandleFindStudent(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookListChoiceBox.setValue("HA");
    }
}
