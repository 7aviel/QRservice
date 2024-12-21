package com.project.qrservice.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Map;

@Service
public class ImageService {

    public BufferedImage getImage(int size, String content, String c){
        if (size > 350 || size < 150) {
            throw new IllegalArgumentException("Image size must be between 150 and 350 pixels");
        }
        QRCodeWriter codeWriter = new QRCodeWriter();

       Map<EncodeHintType,?> hints = Map.of(EncodeHintType.ERROR_CORRECTION, getCorrectionLevel(c));
        try{
            BitMatrix bitMatrix = codeWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        }catch (WriterException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public MediaType getMediaType(String type){
        return switch (type.toLowerCase()) {
            case "png" -> MediaType.IMAGE_PNG;
            case "jpeg", "jpg" -> MediaType.IMAGE_JPEG;
            case "gif" -> MediaType.IMAGE_GIF;
            default -> throw new IllegalArgumentException("Only PNG, JPEG, and GIF image types are supported");
        };
    }

    public ErrorCorrectionLevel getCorrectionLevel(String c){
        if (c == null) c = "L";
        return switch (c.toUpperCase()){
            case "L" -> ErrorCorrectionLevel.L;
            case "M" -> ErrorCorrectionLevel.M;
            case "Q" -> ErrorCorrectionLevel.Q;
            case "H" -> ErrorCorrectionLevel.H;
            default -> throw new IllegalArgumentException("Permitted error correction levels are L, M, Q, H");
        };

    }

}
