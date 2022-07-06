package se.harpo.cipher.enigma.reflector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectorTest {
    @Test
    void shouldCipher() {
        var reflector = new CustomReflector("Test reflector", "ABC", "123");
        assertEquals('2', reflector.encrypt('B'));
    }
}
