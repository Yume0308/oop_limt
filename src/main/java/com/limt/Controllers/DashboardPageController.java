package com.limt.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardPageController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(CurrentUserID);
    }

    @FXML
    private Button addBookBtn;

    @FXML
    private Button addStudentBtn;

    @FXML
    private Button issueBookBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button returnBookBtn;

    @FXML
    private Button statisticsBtn;

    public static Integer CurrentUserID;

    @FXML
    void HandleAddBookBtn(ActionEvent event) throws IOException {
        HandleAddPage("/fxml/AddBookPage.fxml");
    }

    @FXML
    void HandleAddStudentBtn(ActionEvent event) throws IOException {
        HandleAddPage("/fxml/AddStudentPage.fxml");
    }

    @FXML
    void HandleIssueBookBtn(ActionEvent event) throws IOException {
        HandleAddPage("/fxml/IssueBookPage.fxml");
    }

    @FXML
    void HandleLogoutBtn(ActionEvent event) throws IOException {
        ((Stage) logoutBtn.getScene().getWindow()).close();
        HandleAddPage("/fxml/LoginPage.fxml");
    }

    @FXML
    void HandleReturnBookBtn(ActionEvent event) throws IOException {
        HandleAddPage("/fxml/ReturnBookPage.fxml");
    }

    @FXML
    void HandleStatisticsBtn(ActionEvent event) throws IOException {
        HandleAddPage("/fxml/StatisticsPage.fxml");
    }

    void HandleAddPage(String URL) throws IOException {
        Parent view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(URL)));
        Scene scene = new Scene(view);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
