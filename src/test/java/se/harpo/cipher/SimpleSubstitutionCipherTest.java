package se.harpo.cipher;

import org.junit.jupiter.api.Test;
import se.harpo.cipher.substitution.SimpleSubstitutionCipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleSubstitutionCipherTest {
    @Test
    void shouldEncryptUpperCaseLetters() {
        var plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var cipherAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        var cipher = new SimpleSubstitutionCipher(plainAlphabet, cipherAlphabet);

        for (int i = 0; i < plainAlphabet.length(); i++) {
            assertEquals(cipherAlphabet.charAt(i), cipher.encrypt(plainAlphabet.charAt(i)));
        }
    }

    @Test
    void shouldEncryptLowerCaseLetters() {
        var plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var cipherAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        var text = "abcdefghijklmnopqrstuvwxyz";
        var cipher = new SimpleSubstitutionCipher(plainAlphabet, cipherAlphabet);

        for (int i = 0; i < plainAlphabet.length(); i++) {
            assertEquals(cipherAlphabet.charAt(i), cipher.encrypt(text.charAt(i)));
        }
    }

    @Test
    void shouldEncryptMessage() {
        var plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var cipherAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        var cipher = new SimpleSubstitutionCipher(plainAlphabet, cipherAlphabet);

        var encryptedMessage = cipher.encrypt("THIS IS A TEST!");

        assertEquals("PQVS VS E PLSP!", encryptedMessage);
    }

    @Test
    void shouldRemoveDuplicates() {
        var plainAlphabet = "ABBC";
        var cipherAlphabet = "RRRRRST";
        var cipher = new SimpleSubstitutionCipher(plainAlphabet, cipherAlphabet);

        assertEquals('R', cipher.encrypt('A'));
        assertEquals('S', cipher.encrypt('B'));
        assertEquals('T', cipher.encrypt('C'));
    }

    @Test
    void tooShortCipherAlphabet() {
        var plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var cipherAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRC";
        var cipher = new SimpleSubstitutionCipher(plainAlphabet, cipherAlphabet);

        assertEquals('C', cipher.encrypt('Y'));
        assertEquals('Z', cipher.encrypt('Z'));
    }

    @Test
    void invertedCipher() {
        var plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var cipherAlphabet = "EKMFLGDQVZNTOWYHXUSPAIBRC";
        var cipher = new SimpleSubstitutionCipher(plainAlphabet, cipherAlphabet).invert();

        for (int i = 0; i < cipherAlphabet.length(); i++) {
            assertEquals(plainAlphabet.charAt(i), cipher.encrypt(cipherAlphabet.charAt(i)));
        }
    }

    @Test
    void generateWithKeyword() {
        var cipherAlphabet = SimpleSubstitutionCipher.generateCipherAlphabet(
                "ABCDEF", "FAB");
        assertEquals("FABCDE", cipherAlphabet);
    }

    @Test
    void generateWithDuplicatesInKeyword() {
        var cipherAlphabet = SimpleSubstitutionCipher.generateCipherAlphabet(
                "ABCDEF", "FAABBB");
        assertEquals("FABCDE", cipherAlphabet);
    }

    @Test
    void generateWithLongKeyword() {
        var cipherAlphabet = SimpleSubstitutionCipher.generateCipherAlphabet(
                "DIFRTYEPS", "SPIDERMONKEY");
        assertEquals("SPIDERYFT", cipherAlphabet);
    }
}