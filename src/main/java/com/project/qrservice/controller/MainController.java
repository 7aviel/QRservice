package com.project.qrservice.controller;

import com.project.qrservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.util.Objects;

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
    public ResponseEntity<?> qrCode(Integer size,
                                    String type,
                                    String correction,
                                    @RequestParam String content) {
        BufferedImage image;
        MediaType mediaType;
        if(content.isEmpty()){
            throw new IllegalArgumentException("Content cannot be empty or null");
        }
        image = this.imageService.getImage(Objects.requireNonNullElse(size, 250), content, correction);
        mediaType = this.imageService.getMediaType(Objects.requireNonNullElse(type, "png"));
        return ResponseEntity.ok().contentType(mediaType).body(image);
    }

}
