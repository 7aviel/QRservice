package com.project.qrservice.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;

@RestController()
@RequestMapping("/api")
public class MainController {

    @GetMapping("/health")
    public ResponseEntity<HttpStatus> getHealth() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    public ResponseEntity<?> qrCode(@RequestParam int size, String type) {
        if (size > 350 || size < 150) {
            return ResponseEntity.badRequest().body("{error: Image size must be between 150 and 350 pixels}");
        }
        BufferedImage image = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, size, size);
        MediaType mediaType;
        switch (type.toLowerCase()) {
            case "png":
                mediaType = MediaType.IMAGE_PNG;
                break;
            case "jpeg":
            case "jpg":
                mediaType = MediaType.IMAGE_JPEG;
                break;
            case "gif":
                mediaType = MediaType.IMAGE_GIF;
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Only PNG, JPEG, and GIF formats are supported");
        }
        return ResponseEntity.ok().contentType(mediaType).body(image);
    }

}
