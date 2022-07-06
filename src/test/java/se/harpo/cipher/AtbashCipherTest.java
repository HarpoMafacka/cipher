package se.harpo.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtbashCipherTest {
    @Test
    void shouldCipher() {
        var cipher = new AtbashCipher("ABCD");

        assertEquals('D', cipher.encrypt('A'));
        assertEquals('C', cipher.encrypt('B'));
        assertEquals('B', cipher.encrypt('C'));
        assertEquals('A', cipher.encrypt('D'));
    }

    @Test
    void generateCipherAlphabet() {
        assertEquals("SUNIL", AtbashCipher.generateCipherAlphabet("LINUS"));
    }
}