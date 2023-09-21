package com.dozn.socketecho.crypt;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class AES128Test {

    @Test
    public void aes128Test() {
        String key = "keykeykeykeykeykey";
        AES128 aes = new AES128(key);

        String txt = "Hello World";
        String encrypt = aes.encrypt(txt);
        String decrypt = aes.decrypt(encrypt);

        log.info("txt -> {}", txt);
        log.info("encrypt -> {}", encrypt);
        log.info("decrypt -> {}", decrypt);

        Assertions.assertThat(decrypt).isEqualTo(txt);
    }

}