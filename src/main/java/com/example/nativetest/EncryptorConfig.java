package com.example.nativetest;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EncryptorConfig {

    @Bean
    public StandardPBEStringEncryptor jasyptStringEncryptor(Environment environment) {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(environment.getProperty("jasypt_encryptor_password"));
        return (encryptor);
    }

}
