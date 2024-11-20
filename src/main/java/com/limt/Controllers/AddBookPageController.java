package com.limt.Controllers;

import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddBookPageController {

    @FXML
    private Button addBookBtn;

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
    private Label msgLabel;

    @FXML
    void HandleAddBookBtn(ActionEvent event) {
        try {
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;
            Connection connection = DatabaseManager.connect();
            assert connection != null;
            connection.setAutoCommit(false);

            String BookID = bookIDField.getText();
            String BookISBN = bookISBNField.getText();
            String BookTitle = bookTitleField.getText();
            String BookAuthor = bookAuthorField.getText();
            String BookCategory = bookCategoryField.getText();
            String BookPublisher = bookPublisherField.getText();
            int BookQuantity = Integer.parseInt(bookQuantityField.getText());
            String BookImagePath = bookImagePathField.getText();

            String query = "INSERT INTO Book VALUES(? ,? , ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, BookID);
            preparedStatement.setString(2, BookISBN);
            preparedStatement.setString(3, BookTitle);
            preparedStatement.setString(4, BookAuthor);
            preparedStatement.setString(5, BookCategory);
            preparedStatement.setString(6, BookPublisher);
            preparedStatement.setInt(7, BookQuantity);
            preparedStatement.setInt(8, BookQuantity);
            preparedStatement.setString(9, BookImagePath);

            preparedStatement.execute();
            connection.commit();
            msgLabel.setText("Successfully Added Book");
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    @FXML
    void HandleBackToDashboard(ActionEvent event) {

    }

    @FXML
    void HandleClearAllField(ActionEvent event) {

    }

}
