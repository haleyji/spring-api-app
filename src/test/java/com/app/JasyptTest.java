package com.app;

import com.app.global.config.JasyptConfig;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {

    @Test
    public void test() {
        String password = "dfjsldfiewnxck342@dkfje!dkj";
        String content = "17de24d4dd9fe64395b77b18fcd55883";

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);//머신 코어 수랑 동일하게
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");

        String contentEnc = encryptor.encrypt(content);
        String decContentEnc = encryptor.decrypt(contentEnc);

        System.out.println("content => " + contentEnc);
        System.out.println("decrypted content => " + decContentEnc);

    }
}
