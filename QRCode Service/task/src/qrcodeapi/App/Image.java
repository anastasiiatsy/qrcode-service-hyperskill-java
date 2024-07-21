package qrcodeapi.App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Image {

    public boolean hasCorrectSize(int size) {
        return size >= 150 && size <= 350;
    }

    public boolean hasCorrectType(String mediaType) {
        return mediaType.equals("png") || mediaType.equals("jpeg") || mediaType.equals("gif");
    }

    public boolean hasValidContents(String contents) {
        return !contents.isBlank() || !contents.trim().isEmpty();
    }

    public boolean hasValidCorrectionLevel(String correction) {
        return correction.matches("[LMQH]");
    }
//    public BufferedImage createImage(int size) {
//        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
//        Graphics2D graphics2D = image.createGraphics();
//        graphics2D.setColor(Color.WHITE);
//        graphics2D.fillRect(0, 0, size, size);
//        return image;
//    }
}