package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v3/firebase")
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
    public String downloadFile(@RequestParam("file") String fileName) throws IOException {
        return service.download(fileName);
    }
}
