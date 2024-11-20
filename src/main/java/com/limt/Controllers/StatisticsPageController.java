package com.limt.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatisticsPageController {

    @FXML
    private TabPane TabPane;

    @FXML
    private TableColumn<?, ?> bookAuthorCol;

    @FXML
    private TableColumn<?, ?> bookCategoryCol;

    @FXML
    private TableColumn<?, ?> bookIDCol;

    @FXML
    private TableColumn<?, ?> bookISBNCol;

    @FXML
    private TableColumn<?, ?> bookImagePathCol;

    @FXML
    private TableView<?> bookListTableView;

    @FXML
    private TableColumn<?, ?> bookPublisherCol;

    @FXML
    private TableColumn<?, ?> bookQuantityCol;

    @FXML
    private TableColumn<?, ?> bookTitleCol;

    @FXML
    private Button goBackbtn;

    @FXML
    private TableColumn<?, ?> issueBookBookIDCol;

    @FXML
    private TableColumn<?, ?> issueBookBookISBNCol;

    @FXML
    private TableColumn<?, ?> issueBookBookTitleCol;

    @FXML
    private TableColumn<?, ?> issueBookIssueDateCol;

    @FXML
    private TableView<?> issueBookListTableView;

    @FXML
    private TableColumn<?, ?> issueBookStudentIDCol;

    @FXML
    private TableColumn<?, ?> issueBookStudentNameCol;

    @FXML
    private TableColumn<?, ?> issueBookiIssueIDCol;

    @FXML
    private TableColumn<?, ?> returnBookBookIDCol;

    @FXML
    private TableColumn<?, ?> returnBookBookISBNCol;

    @FXML
    private TableColumn<?, ?> returnBookBookTitleCol;

    @FXML
    private TableColumn<?, ?> returnBookDaysCol;

    @FXML
    private TableColumn<?, ?> returnBookIssueDateCol;

    @FXML
    private TableColumn<?, ?> returnBookIssueIDCol;

    @FXML
    private TableView<?> returnBookListTableView;

    @FXML
    private TableColumn<?, ?> returnBookReturnDateCol;

    @FXML
    private TableColumn<?, ?> returnBookStudentIDCol;

    @FXML
    private TableColumn<?, ?> returnBookStudentNameCol;

    @FXML
    private TableColumn<?, ?> studentAddressLineCol;

    @FXML
    private TableColumn<?, ?> studentBirthdayCol;

    @FXML
    private TableColumn<?, ?> studentEmailCol;

    @FXML
    private TableColumn<?, ?> studentIDCol;

    @FXML
    private TableView<?> studentListTableView;

    @FXML
    private TableColumn<?, ?> studentNameCol;

    @FXML
    private TableColumn<?, ?> studentPhoneNumberCol;

    @FXML
    private TableColumn<?, ?> studentSchoolCol;

}
