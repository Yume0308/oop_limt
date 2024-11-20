package com.limt.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StatisticsPageController {

    @FXML
    private Tab BookListPane;

    @FXML
    private CheckBox IssueBookListCheckAll;

    @FXML
    private Tab StudentListPane;

    @FXML
    private TabPane TabPane;

    @FXML
    private TableColumn<?, ?> bookListAuthorCol;

    @FXML
    private TableColumn<?, ?> bookListCategoryCol;

    @FXML
    private CheckBox bookListCheckAll;

    @FXML
    private TableColumn<?, ?> bookListCheckCol;

    @FXML
    private Button bookListDeleteSelectedItem;

    @FXML
    private Button bookListFindBtn;

    @FXML
    private TableColumn<?, ?> bookListIDCol;

    @FXML
    private TableColumn<?, ?> bookListISBNCol;

    @FXML
    private TableColumn<?, ?> bookListImagePathCol;

    @FXML
    private TableColumn<?, ?> bookListPublisherCol;

    @FXML
    private TableColumn<?, ?> bookListQuantityCol;

    @FXML
    private TableColumn<?, ?> bookListRemainingCol;

    @FXML
    private TextField bookListSearchField;

    @FXML
    private TableView<?> bookListTableView;

    @FXML
    private TableColumn<?, ?> bookListTitleCol;

    @FXML
    private TableColumn<?, ?> issueBookListBookIDCol;

    @FXML
    private TableColumn<?, ?> issueBookListBookISBNCol;

    @FXML
    private TableColumn<?, ?> issueBookListBookTitleCol;

    @FXML
    private TableColumn<?, ?> issueBookListCheckCol;

    @FXML
    private Button issueBookListDeleteSelectedItem;

    @FXML
    private Button issueBookListFindBtn;

    @FXML
    private TableColumn<?, ?> issueBookListIssueDateCol;

    @FXML
    private TableColumn<?, ?> issueBookListIssueIDCol;

    @FXML
    private Tab issueBookListPane;

    @FXML
    private TextField issueBookListSearchField;

    @FXML
    private TableColumn<?, ?> issueBookListStudentIDCol;

    @FXML
    private TableColumn<?, ?> issueBookListStudentNameCol;

    @FXML
    private TableView<?> issueBookListTableView;

    @FXML
    private TableColumn<?, ?> returnBookListBookIDCol;

    @FXML
    private TableColumn<?, ?> returnBookListBookISBNCol;

    @FXML
    private TableColumn<?, ?> returnBookListBookTitleCol;

    @FXML
    private CheckBox returnBookListCheckAll;

    @FXML
    private Button returnBookListDeleteSelectedItem;

    @FXML
    private Button returnBookListFindBtn;

    @FXML
    private TableColumn<?, ?> returnBookListIssueDateCol;

    @FXML
    private TableColumn<?, ?> returnBookListIssueIDCol;

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

    @FXML
    void HandleSwitchPaneBookList(ActionEvent event) {

    }

    @FXML
    void HandleSwitchPaneIssueBookList(ActionEvent event) {

    }

    @FXML
    void HandleSwitchPaneReturnBookList(ActionEvent event) {

    }

    @FXML
    void HandleSwitchPaneStudentList(ActionEvent event) {

    }

}
