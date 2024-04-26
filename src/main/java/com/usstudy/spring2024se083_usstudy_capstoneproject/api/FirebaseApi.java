package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.FirebaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/v3/firebase")
@Tag(name = "Firebase-API")
public class FirebaseApi {

    private final FirebaseService service;

    @Autowired
    public FirebaseApi(FirebaseService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        return service.upload(multipartFile);
    }

    @PostMapping("/pdf")
    public String uploadPdf(@RequestParam("file") MultipartFile multipartFile) {
        return service.uploadPdf(multipartFile);
    }

//    @PostMapping("/download")
//    @Operation(summary = "Return a file in Firebase (test with Postman)",
//            description = "Return a file, may return a Byte[] if file contentType is not common")
//    public ResponseEntity<?> downloadFile(@RequestParam("file") String fileName,
//                               @RequestParam("file-path") String filePath
//            // , @RequestParam("destination-folder") String destFilePath
//    ) throws IOException {
//        try {
//            byte[] result=service.download(fileName,filePath);
//            File tempFile = new File("tempFile");
//            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
//                fos.write(result);
//            }
//            Tika tika=new Tika();
//            String contentType=tika.detect(tempFile);
//            if (contentType != null) {
//                MediaType mediaType = MediaType.valueOf(contentType);
//                return ResponseEntity.ok()
//                        .contentType(mediaType)
//                        .body(result);
//            } else {
//                return ResponseEntity.ok()
//                        .body(result);
//            }
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    //    @PostMapping("/file")
//    public String downloadFileUrl(@RequestParam("file") String fileName,
//                                  @RequestParam("file-url") String url){
//        try {
//            return service.downloadLink(fileName,url);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    @GetMapping("/file")
    @Operation(summary = "Get file in Firebase using url (test with Postman)"
            , description = "Return a file, may return a Byte[] if file contentType is not common")
    public ResponseEntity<?> downloadFileUrl(@RequestParam("url") String url) {
        try {
            byte[] result = service.downloadLink(url);
            File tempFile = new File("tempFile");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(result);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=" + service.getFileNameFromUrl(url));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//            Tika tika=new Tika();
//            String contentType=tika.detect(tempFile);
//            if (contentType != null) {
//                MediaType mediaType = MediaType.valueOf(contentType);
//                HttpHeaders headers = new HttpHeaders();
//                headers.add(HttpHeaders.CONTENT_DISPOSITION,
//                        "attachment; filename=" + service.getFileNameFromUrl(url));
//                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                return ResponseEntity.ok()
//                        .headers(headers)
//                        //.contentType(mediaType)
//                        .body(result);
//            } else {
//                return ResponseEntity.ok()
//                        .body(result);
//            }
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //    @GetMapping("/test")
//    public ResponseEntity<?> test(@RequestParam("file") String fileName){
//        String home = System.getProperty("user.home");
//        String destFilePath = home+"\\Downloads\\" + fileName;
//        return ResponseEntity.ok(destFilePath);
//    }
    @GetMapping("/get")
    public String getNameFile(@RequestParam("url") String url) throws IOException {
        return service.downloadLinkD(url);
    }

    @GetMapping("/down")
    public String download(@RequestParam("url") String url) throws IOException {
        return service.downloadString(url);
    }
}
