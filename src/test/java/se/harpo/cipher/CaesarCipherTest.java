package se.harpo.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {
    @Test
    void shouldEncrypt() {
        var cipher = new CaesarCipher();

        assertEquals("OLQXV", cipher.encrypt("LINUS"));
    }

    @Test
    void shouldEncryptCustomAlphabet() {
        var cipher = new CaesarCipher("LINUS");

        assertEquals("USLIN", cipher.encrypt("LINUS"));
    }
}