package com.limt.Controllers;

import com.limt.Lib.QR;
import com.limt.dbms.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowQRPageController implements Initializable {
    @FXML
    public ImageView qrCode;

    private int ID;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    public void HandleMinimize(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void HandleClose(ActionEvent actionEvent) {
        ((Stage) close.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID = StatisticsPageController.ID;
        try {
            Image qrImage = QR.getQRCodeFromDatabase(ID, DatabaseManager.connect());
            if (qrImage != null) {
                qrCode.setImage(qrImage);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
