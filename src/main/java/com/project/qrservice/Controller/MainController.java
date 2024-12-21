package com.project.qrservice.Controller;

import com.project.qrservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final ImageService imageService;

    @Autowired
    public MainController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/health")
    public ResponseEntity<HttpStatus> getHealth() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    public ResponseEntity<?> qrCode(@RequestParam int size, String type) {
        BufferedImage image = this.imageService.getImage(size);
        MediaType mediaType = this.imageService.getMediaType(type);
        return ResponseEntity.ok().contentType(mediaType).body(image);
    }

}
