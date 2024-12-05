package com.limt.Lib;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QRTest {

    @Test
    void testGenerateQRCode() {
        String text = "Hello, QR Code!";
        int width = 200;
        int height = 200;

        WritableImage qrCodeImage = QR.generateQRCode(text, width, height);
        assertNotNull(qrCodeImage, "QR Code image should not be null");
        assertEquals(width, (int) qrCodeImage.getWidth(), "Width of QR Code image should match the input width");
        assertEquals(height, (int) qrCodeImage.getHeight(), "Height of QR Code image should match the input height");
        boolean hasBlackPixel = false;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (qrCodeImage.getPixelReader().getColor(x, y).equals(Color.BLACK)) {
                    hasBlackPixel = true;
                    break;
                }
            }
            if (hasBlackPixel) break;
        }
        assertTrue(hasBlackPixel, "QR Code image should have at least one black pixel");
    }
}

