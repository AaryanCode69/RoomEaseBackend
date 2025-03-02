package com.example.roomeasebackend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class firebaseconfig {
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        InputStream credentialStream;

        // First try to load from Render's secret location
        File renderSecretFile = new File("/etc/secrets/serviceAccountKey.json");
        if (renderSecretFile.exists()) {
            credentialStream = new FileInputStream(renderSecretFile);
        } else {
            // Fallback to classpath resource for local development
            ClassPathResource resource = new ClassPathResource("serviceAccountKey.json");
            credentialStream = resource.getInputStream();
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(credentialStream))
                .build();

        return FirebaseApp.initializeApp(options);
    }
}