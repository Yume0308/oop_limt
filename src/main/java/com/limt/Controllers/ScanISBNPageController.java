package com.limt.Controllers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.LuminanceSource;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import javax.xml.transform.Result;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ScanISBNPageController implements Initializable {
    @FXML
    private Button close;

    @FXML
    private Button minimize;

    private static final Logger log = LoggerFactory.getLogger(ScanISBNPageController.class);
    @FXML
    ImageView imageView;

    Webcam webcam;
    WebcamPanel panel;
    public static String ISBN;
    void StartWebcam() {
        ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
            }
        });

        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);

        executor.execute(() -> {
            while (true) {
            BufferedImage image = webcam.getImage();
            if (image != null) {
                Platform.runLater(() -> imageView.setImage(SwingFXUtils.toFXImage(image, null)));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
    }

    void StopWebcam() {
        if (webcam != null) {
            webcam.close();
        imageView.setImage(null);
        }
    }

    @FXML
    public void ScanISBNBook() {
        if(imageView == null) {
            StartWebcam();
        }
        ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });

        executor.execute(() -> {
            while (true) {
                BufferedImage image = webcam.getImage();
                if (image != null) {
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    try {
                        com.google.zxing.Result result = new MultiFormatReader().decode(bitmap);
                        if (result != null) {
                            Platform.runLater(() -> {
                                ISBN = result.getText();
                                System.out.println(ISBN);
                                Stage stage = (Stage) imageView.getScene().getWindow();
                                stage.close();
                            });
                            StopWebcam();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> imageView.setImage(SwingFXUtils.toFXImage(image, null)));
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StartWebcam();
        ScanISBNBook();
    }
}
