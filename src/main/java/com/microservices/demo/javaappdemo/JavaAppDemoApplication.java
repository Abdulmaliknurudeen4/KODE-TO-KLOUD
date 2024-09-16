package com.microservices.demo.javaappdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class JavaAppDemoApplication implements CommandLineRunner {

    @Autowired
    private NoteRepository noteRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaAppDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate 50 random notes
       /* Random random = new Random();
        IntStream.range(0, 50).forEach(i -> {
            Note note = new Note();
            note.setTitle("Note Title " + (i + 1));
            note.setContent("This is the content of note " + (i + 1) + ". Random number: " + random.nextInt(100));
            note.setCreatedAt(LocalDateTime.now());
            note.setUpdatedAt(LocalDateTime.now());
            noteRepository.save(note);
        });

        System.out.println("50 random notes have been generated.");*/
    }
}