package com.limt.Controllers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.limt.Models.Book;
import com.limt.Models.Student;
import com.limt.dbms.DatabaseManager;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;

public class ScanQRPageController implements Initializable {
    @FXML
    private Button close;

    @FXML
    private Button minimize;

    private static final Logger log = LoggerFactory.getLogger(ScanISBNPageController.class);
    @FXML
    ImageView imageView;

    Webcam webcam;
    WebcamPanel panel;
    private String qr;
    private Consumer<Book> onBookScannedCallback;
    private Consumer<Student> onStudentScannedCallback;

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
    public void ScanQrBook() {
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
                                qr = result.getText();
                                ResultSet rs = null;
                                PreparedStatement pst = null;
                                Connection conn = DatabaseManager.connect();
                                assert conn != null;

                                String []res = qr.split(",");
                                if(res[0].equals("Book")){
                                    String query = "select * from Book where ID = ?";
                                    try {
                                        pst = conn.prepareStatement(query);
                                        pst.setInt(1, Integer.parseInt(res[1]));
                                        rs = pst.executeQuery();
                                        if (rs.next()) {
                                            Book book = new Book(
                                                rs.getInt("ID"),
                                                rs.getString("ISBN"),
                                                rs.getString("Title"),
                                                rs.getString("Author"),
                                                rs.getString("Category"),
                                                rs.getString("Publisher"),
                                                rs.getInt("Quantity"),
                                                rs.getString("ImagePath")
                                            );

                                            Platform.runLater(() -> {
                                                if (onBookScannedCallback != null) {
                                                    onBookScannedCallback.accept(book);
                                                }
                                                StopWebcam();
                                                Stage stage = (Stage) imageView.getScene().getWindow();
                                                stage.close();
                                            });
                                            rs.close();
                                            pst.close();
                                        }
                                    } catch(SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else if(res[0].equals("Student")) {
                                    String query = "select * from Student where StudentID = ?";
                                    try {
                                        pst = conn.prepareStatement(query);
                                        pst.setInt(1, Integer.parseInt(res[1]));
                                        rs = pst.executeQuery();
                                        if (rs.next()) {
                                            Student student = new Student(
                                                rs.getInt("StudentID"),
                                                rs.getString("StudentName"),
                                                rs.getString("School"),
                                                rs.getString("Email"),
                                                rs.getString("PhoneNumber"),
                                                rs.getString("AddressLine"),
                                                rs.getDate("Birthday")
                                            );

                                            Platform.runLater(() -> {
                                                if (onStudentScannedCallback != null) {
                                                    onStudentScannedCallback.accept(student);
                                                }
                                                StopWebcam();
                                                Stage stage = (Stage) imageView.getScene().getWindow();
                                                stage.close();
                                            });
                                            rs.close();
                                            pst.close();
                                        }
                                    } catch(SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
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
        ScanQrBook();
    }

    public void startCamera(ActionEvent actionEvent) {
    }

    public void stopCamera(ActionEvent actionEvent) {
    }

    public void setOnBookScannedCallback(Consumer<Book> callback) {
        this.onBookScannedCallback = callback;
    }

    public void setOnStudentScannedCallback(Consumer<Student> callback) {
        this.onStudentScannedCallback = callback;
    }
}
