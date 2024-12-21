package com.project.qrservice.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class ImageService {

    public BufferedImage getImage(int size){
        if (size > 350 || size < 150) {
            throw new IllegalArgumentException("Image size must be between 150 and 350 pixels");
        }
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, size, size);
        return image;
    }

    public MediaType getMediaType(String type){
        return switch (type.toLowerCase()) {
            case "png" -> MediaType.IMAGE_PNG;
            case "jpeg", "jpg" -> MediaType.IMAGE_JPEG;
            case "gif" -> MediaType.IMAGE_GIF;
            default -> throw new IllegalArgumentException("Only PNG, JPEG, and GIF image types are supported");
        };
    }

}
