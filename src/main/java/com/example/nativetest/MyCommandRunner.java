package com.example.nativetest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MyCommandRunner implements CommandLineRunner {

    @Value("${mypassword}")
    private String mypassword;

    @Override
    public void run(String... args) {
        System.out.println("Password  value: " + mypassword);
    }
}
