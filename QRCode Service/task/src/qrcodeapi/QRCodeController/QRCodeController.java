package qrcodeapi.QRCodeController;

import qrcodeapi.App.ErrorResponse;
import qrcodeapi.App.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.App.QRCodeGenerator;

import java.awt.image.BufferedImage;

@RestController
public class QRCodeController {

    private Image image;
    private QRCodeGenerator codeGenerator;

    @GetMapping("/api/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("200 OK");
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity getQRCode(@RequestParam String contents,
                                    @RequestParam(defaultValue = "250") int size,
                                    @RequestParam(defaultValue = "png") String type,
                                    @RequestParam (defaultValue = "L") String correction) {


        image = new Image();

        if(!image.hasValidContents(contents)) {
            ErrorResponse error = new ErrorResponse("Contents cannot be null or blank");
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }

        if (!image.hasCorrectSize(size)) {
            ErrorResponse error = new ErrorResponse("Image size must be between 150 and 350 pixels");
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }

        if(!image.hasValidCorrectionLevel(correction)) {
            ErrorResponse error = new ErrorResponse("Permitted error correction levels are L, M, Q, H");
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }

        if (!image.hasCorrectType(type)) {
            ErrorResponse error = new ErrorResponse("Only png, jpeg and gif image types are supported");
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }

        codeGenerator = new QRCodeGenerator();
        BufferedImage bufferedImage = codeGenerator.generateQRCode(contents, size, correction);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("image/" + type))
                .body(bufferedImage);
    }

}