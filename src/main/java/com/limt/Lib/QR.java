package com.limt.Lib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QR {
    public static WritableImage generateQRCode(String text, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        WritableImage writableImage = new WritableImage(width, height);

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    writableImage.getPixelWriter().setColor(x, y,
                        bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return writableImage;
    }

    public static byte[] saveQRCode(WritableImage writableImage) throws IOException {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", outputStream);
        byte[] imageBytes = outputStream.toByteArray();
        return imageBytes;
    }

    public static Image getQRCodeFromDatabase(int BookID, Connection conn) {
        try {
            String query = "Select Qr From Book where ID = " + BookID;
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                byte[] imageBytes = resultSet.getBytes("Qr");
                if(imageBytes != null){
                    ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                    return new Image(bais);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
