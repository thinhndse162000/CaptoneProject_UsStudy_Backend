package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FirebaseService {
    private final String BUCKET="capstone-project-5362d.appspot.com";
    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("capstone-project-5362d.appspot.com", fileName); // Replace with your bucker name
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, fileName);
    }

    private String uploadFilePdf(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("capstone-project-5362d.appspot.com", fileName); // Replace with your bucker name
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/pdf").build();
        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, fileName);
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
//            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.

            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String URL = this.uploadFile(file, fileName);                                   // to get uploaded file link
            file.delete();
            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }

    public String uploadPdf(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
//            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.

            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String URL = this.uploadFilePdf(file, fileName);                                   // to get uploaded file link
            file.delete();
            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }

    public byte[] download(String fileName, String filePath) throws IOException {
        ////////////////////////////////   Download  ////////////////////////////////////////////////////////////////////////
        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("capstone-project-5362d.appspot.com", filePath+fileName));
        return blob.getContent();
    }
    public byte[] downloadLink(String url) throws IOException {
        String bucket=BUCKET+"/o/";
        String filePath= URLDecoder.decode(url.substring(
                url.lastIndexOf(bucket)+bucket.length()
                ,url.lastIndexOf("?")));
        String fileName=filePath.substring(filePath.lastIndexOf("/"));

        ////////////////////////////////   Download  ////////////////////////////////////////////////////////////////////////
        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("capstone-project-5362d.appspot.com", filePath));
        return blob.getContent();
    }
    public String getFileNameFromUrl(String url){
        String bucket=BUCKET+"/o/";
        String filePath= URLDecoder.decode(url.substring(
                url.lastIndexOf(bucket)+bucket.length()
                ,url.lastIndexOf("?")));
        String fileName=filePath.substring(filePath.lastIndexOf("/"));
        return fileName;
    }
}
