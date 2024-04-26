package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FirebaseService {
    private final String BUCKET = "capstone-project-5362d.appspot.com";

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
//        String destFileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));     // to set random strinh for destination file name
//        String home = System.getProperty("user.home");
//        String destFilePath = home+"\\Downloads\\" + fileName;                                    // to set destination file path

        ////////////////////////////////   Download  ////////////////////////////////////////////////////////////////////////
        //Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"));
        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("capstone-project-5362d.appspot.com", filePath + fileName));
        //blob.downloadTo(Paths.get(destFilePath));
        //return "Check download file";
        return blob.getContent();
    }

    // firebase file token
    //https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/Image%2FProgram%2Ftaxi.jpeg
    // ?alt=media&token=7b3d38a4-9c35-437a-acb7-71db8dc976d4
    //https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/Image%2FUniversities%2Fharvard-university-logo.png
    // ?alt=media&token=62f3002f-087c-4219-b268-3da8f44fdf00
    //https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/form%2Fc%C3%A1c%20%C4%91%C6%A1n%20m%E1%BA%ABu%20xin%20%C4%91i%20du%20h%E1%BB%8Dc.rar?alt=media&token=0251db7b-331e-4907-8940-d145f522877d
    //https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/Image%2FProfileStudent%2Fquan-tri-kinh-doanh.jpg?alt=media&token=9604f2b4-1dcb-4f0d-afcd-73ce92abd3d8
    // firebase file location
    //gs://capstone-project-5362d.appspot.com/Image/Program/taxi.jpeg
    public byte[] downloadLink(String url) throws IOException {
        String bucket = BUCKET + "/o/";
        String filePath = URLDecoder.decode(url.substring(
                url.lastIndexOf(bucket) + bucket.length()
                , url.lastIndexOf("?")));
        String fileName = filePath.substring(filePath.lastIndexOf("/"));

        //String home = System.getProperty("user.home");
        //String destFilePath = home+"\\Downloads\\" + fileName;
        //destFilePath result
        ///root\Downloads\test.txt

        ////////////////////////////////   Download  ////////////////////////////////////////////////////////////////////////
        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("capstone-project-5362d.appspot.com", filePath));
        //blob.downloadTo(Paths.get(destFilePath));
        //File file=new File("test");
//        File tempFile = new File(destFilePath);
//        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
//            fos.write(blob.getContent());
//            fos.close();
//        }
//        return tempFile;
        return blob.getContent();
    }

    public String getFileNameFromUrl(String url) {
        String bucket = BUCKET + "/o/";
        String filePath = URLDecoder.decode(url.substring(
                url.lastIndexOf(bucket) + bucket.length()
                , url.lastIndexOf("?")));
        String fileName = filePath.substring(filePath.lastIndexOf("/"));
        return fileName;

    }

    public String downloadLinkD(String url) throws IOException {
        String bucket = BUCKET + "/o/";
        String filePath = URLDecoder.decode(url.substring(
                url.lastIndexOf(bucket) + bucket.length()
                , url.lastIndexOf("?")));
        String fileName = filePath.substring(filePath.lastIndexOf("/"));

        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("capstone-project-5362d.appspot.com", filePath));
        return blob.getName();
    }

    public String downloadString(String fileName) throws IOException {

        // Find the index of the last occurrence of the directory separator "/"
        int lastSeparatorIndex = fileName.lastIndexOf("/");

        // Use substring to extract the filename
        String fileString = fileName.substring(lastSeparatorIndex + 1);
        System.out.println("Filename: " + fileString);
        String destFilePath = "C:/Users/Admin/Downloads/" + fileString;                                    // to set destination file path
        ////////////////////////////////   Download  ////////////////////////////////////////////////////////////////////////
        InputStream inputStream = FirebaseService.class.getClassLoader().getResourceAsStream("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("capstone-project-5362d.appspot.com", fileName));
        blob.downloadTo(Paths.get(destFilePath));
        return "Check download file";
    }
}
