package com.limt.Controllers;

import com.limt.Lib.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardPageController implements Initializable {

    @FXML
    private Button addBookBtn;

    @FXML
    private Button addStudentBtn;

    @FXML
    private Label description;

    @FXML
    private Button issueBookBtn;

    @FXML
    private ImageView logo;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button returnBookBtn;

    @FXML
    private Button settingBtn;

    @FXML
    private Button statisticsBtn;

    @FXML
    private Button analysisBtn;

    @FXML
    private Label title;


    public static Integer CurrentUserID;

    @FXML
    void HandleAddBookBtn(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/AddBookPage.fxml");
    }

    @FXML
    void HandleAddStudentBtn(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/AddStudentPage.fxml");
    }

    @FXML
    void HandleIssueBookBtn(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/IssueBookPage.fxml");
    }

    @FXML
    void HandleReturnBookBtn(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/ReturnBookPage.fxml");
    }

    @FXML
    void HandleStatisticsBtn(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/StatisticsPage.fxml");
    }

    @FXML
    void HandleSettingBtn(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/SettingPage.fxml");
    }

    @FXML
    void HandleAnalysisBtn(ActionEvent event) throws IOException {
        Utils.HandleAddPage("/fxml/AnalysisPage.fxml");
    }

    @FXML
    void HandleLogoutBtn(ActionEvent event) throws IOException {
        ((Stage) logoutBtn.getScene().getWindow()).close();
        Utils.HandleAddPage("/fxml/LoginPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CurrentUserID = LoginPageController.getUserID();
        System.out.println(CurrentUserID);
    }
}
