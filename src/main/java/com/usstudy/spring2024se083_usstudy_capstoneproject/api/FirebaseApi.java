package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.FirebaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLDecoder;

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

    @PostMapping("/download")
    @Operation(summary = "Download a file from Firebase( Info at description)",
            description = "EX: gs://capstone-project-5362d.appspot.com/Image/Program/taxi.jpeg ,\n" +
                    "file (Ex: myfile.txt, img.jpg,...),\n" +
                    "file-path (Ex: Image/Program/), \n" +
                    //"destination-folder: your download folder path" +
                    "May not work on other OS like linus")
    public String downloadFile(@RequestParam("file") String fileName,
                               @RequestParam("file-path") String filePath
            // , @RequestParam("destination-folder") String destFilePath
    ) throws IOException {
        return service.download(fileName,filePath);
    }
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
    @Operation(summary = "Get a file from Firebase using url", description = "Return a file")
    public ResponseEntity<?> downloadFileUrl(@RequestParam("url") String url,
                                          @RequestParam("destination-folder") String destFilePath){
        try {
            return ResponseEntity.ok(service.downloadLink(url,destFilePath));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
