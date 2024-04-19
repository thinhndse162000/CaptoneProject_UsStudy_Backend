package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.FirebaseNoutification;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class FirebaseConfig {
    private static final String MESSAGING_SCOPE = "https://www.googleapis.com/auth/drive";
    private static final String[] SCOPES = {MESSAGING_SCOPE};

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("capstone-project-5362d-firebase-adminsdk-1wk99-96f3adbcca.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "Capstone-project");
        return FirebaseMessaging.getInstance(app);

    }

//    @Bean
//    public String getAccessToken() throws IOException {
//        GoogleCredentials googleCredentials = GoogleCredentials
//                .fromStream(new ClassPathResource("capstone-project-5362d-firebase-adminsdk-1wk99-5ff5e913bb.json").getInputStream())
//                .createScoped(Arrays.asList(SCOPES));
//        googleCredentials.refresh();
//        System.out.println("Access Token" + " " + googleCredentials.getAccessToken().getTokenValue());
//        return googleCredentials.getAccessToken().getTokenValue().toString();
//    }
}
