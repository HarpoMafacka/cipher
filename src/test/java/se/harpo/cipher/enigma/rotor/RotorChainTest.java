package se.harpo.cipher.enigma.rotor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotorChainTest {
    @Test
    void shouldEncrypt() {
        var rotors = RotorFactory.getEnigmaIRotors();

        char encrypted = rotors.get(0).encrypt('A');
        encrypted = rotors.get(1).encrypt(encrypted);
        encrypted = rotors.get(2).encrypt(encrypted);

        assertEquals('G', encrypted);
    }

    @Test
    void shouldDecrypt() {
        var rotors = RotorFactory.getEnigmaIRotors();

        char encrypted = rotors.get(0).encrypt('A');
        encrypted = rotors.get(1).encrypt(encrypted);
        encrypted = rotors.get(2).encrypt(encrypted);
        var decrypted = encrypted;
        decrypted = rotors.get(2).decrypt(decrypted);
        decrypted = rotors.get(1).decrypt(decrypted);
        decrypted = rotors.get(0).decrypt(decrypted);

        assertEquals('A', decrypted);
    }
}
