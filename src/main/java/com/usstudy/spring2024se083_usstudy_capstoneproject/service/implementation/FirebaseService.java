package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FirebaseService {
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

    public String download(String fileName, String filePath) throws IOException {
//        String destFileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));     // to set random strinh for destination file name
        String home = System.getProperty("user.home");
        String destFilePath = home+"\\Downloads\\" + fileName;                                    // to set destination file path

        ////////////////////////////////   Download  ////////////////////////////////////////////////////////////////////////
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("capstone-project-5362d.appspot.com", filePath+fileName));
        blob.downloadTo(Paths.get(destFilePath));
        return "Check download file";
    }
    // firebase file token
    //https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/Image%2FProgram%2Ftaxi.jpeg
    // ?alt=media&token=7b3d38a4-9c35-437a-acb7-71db8dc976d4
    //https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/Image%2FUniversities%2Fharvard-university-logo.png
    // ?alt=media&token=62f3002f-087c-4219-b268-3da8f44fdf00
    //https://firebasestorage.googleapis.com/v0/b/capstone-project-5362d.appspot.com/o/form%2Fc%C3%A1c%20%C4%91%C6%A1n%20m%E1%BA%ABu%20xin%20%C4%91i%20du%20h%E1%BB%8Dc.rar
    // ?alt=media&token=0251db7b-331e-4907-8940-d145f522877d

    // firebase file location
    //gs://capstone-project-5362d.appspot.com/Image/Program/taxi.jpeg
}
