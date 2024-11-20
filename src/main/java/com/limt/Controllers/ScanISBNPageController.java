//package com.limt.Controllers;
//
//import com.github.sarxos.webcam.Webcam;
//import com.github.sarxos.webcam.WebcamPanel;
//import com.github.sarxos.webcam.WebcamResolution;
//import eu.hansolo.toolboxfx.geom.Dimension;
//import javafx.application.Platform;
//import javafx.embed.swing.SwingFXUtils;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.StackPane;
//import javafx.scene.media.MediaView;
//import org.jetbrains.annotations.NotNull;
//
//import java.awt.image.BufferedImage;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadFactory;
//
//
//public class ScanISBNPageController implements Initializable {
//
//    @FXML
//    ImageView videoView;
//
//    Mat javaCVMat = new Mat();
//
//    /**
//     * create buffer only once saves much time!
//     */
//    WritablePixelFormat<ByteBuffer> formatByte = PixelFormat.getByteBgraPreInstance();
//
//    OpenCVFrameConverter<Mat> javaCVConv = new OpenCVFrameConverter.ToMat();
//
//    /**
//     * controls if application closes
//     */
//    SimpleBooleanProperty cameraActiveProperty = new SimpleBooleanProperty(true);
//
//    OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(0);
//
//    ByteBuffer buffer;
//
//    protected void updateView(Frame frame) {
//        int w = frame.imageWidth;
//        int h = frame.imageHeight;
//
//        Mat mat = javaCVConv.convert(frame);
//        opencv_imgproc.cvtColor(mat, javaCVMat, COLOR_BGR2BGRA);
//        if (buffer == null) {
//            buffer = javaCVMat.createBuffer();
//        }
//
//        PixelBuffer<ByteBuffer> pb = new PixelBuffer<ByteBuffer>(w, h, buffer, formatByte);
//        final WritableImage wi = new WritableImage(pb);
//        Platform.runLater(() -> videoView.setImage(wi));
//
//    }
//
//
//    public void setCameraActive(Boolean isActive) {
//        cameraActiveProperty.set(isActive);
//    }
//
//    public Boolean getCameraActive() {
//        return cameraActiveProperty.get();
//    }
//
//    public void shutdown() {
//        setCameraActive(false);
//    }
//
//    void setVideoView(Frame mat) {
//        updateView(mat);
//    }
//
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            frameGrabber.start();
//        } catch (FrameGrabber.Exception e) {
//            e.printStackTrace();
//        }
//        new Thread(() -> {
//            while (getCameraActive()) {
//                try {
//                    Frame frame = frameGrabber.grab();
//                    setVideoView(frame);
//                } catch (FrameGrabber.Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                frameGrabber.release();
//            } catch (FrameGrabber.Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }
//}
