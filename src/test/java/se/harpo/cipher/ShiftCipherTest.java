package se.harpo.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftCipherTest {
    @Test
    public void standardCipher() {
        var cipher = new ShiftCipher( 10);

        assertEquals('K', cipher.encrypt('A'));
        assertEquals('E', cipher.encrypt('U'));
    }

    @Test
    public void leftShift() {
        var cipher = new ShiftCipher( -1);

        assertEquals('Z', cipher.encrypt('A'));
    }

    @Test
    public void customCipher() {
        var cipher = new ShiftCipher( "ABC", 1);

        assertEquals('B', cipher.encrypt('A'));
        assertEquals('C', cipher.encrypt('B'));
        assertEquals('A', cipher.encrypt('C'));
    }
}