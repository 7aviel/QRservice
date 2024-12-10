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
    public ResponseEntity<HttpStatus> getHealth(){
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> qrCode(@RequestParam int size, String type){
        BufferedImage image = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        if (size < 350 && size > 150) {
            g.fillRect(0, 0, size, size);
        } else if(type.equals("png")){

        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(image);
    }

}
