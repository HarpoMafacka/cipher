package se.harpo.cipher.enigma.rotor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotorTest {
    @Test
    void shouldRotate() {
        var rotor = new CustomRotor("Test rotor", "ABCD", "1234");
        rotor.rotate();

        assertEquals('2', rotor.encrypt('A'));
        assertEquals('3', rotor.encrypt('B'));
        assertEquals('4', rotor.encrypt('C'));
        assertEquals('1', rotor.encrypt('D'));
        assertEquals('D', rotor.decrypt('1'));
        assertEquals('A', rotor.decrypt('2'));
        assertEquals('B', rotor.decrypt('3'));
        assertEquals('C', rotor.decrypt('4'));
    }

    @Test
    void shouldWrapAround() {
        var rotor = new CustomRotor("Test rotor", "ABC", "123");
        rotor.rotate();
        assertEquals('2', rotor.encrypt('A'));
        assertEquals('A', rotor.decrypt('2'));
        rotor.rotate();
        assertEquals('3', rotor.encrypt('A'));
        assertEquals('A', rotor.decrypt('3'));
        rotor.rotate();
        assertEquals('1', rotor.encrypt('A'));
        assertEquals('A', rotor.decrypt('1'));
    }

    @Test
    void shouldTellPosition() {
        var rotor = new CustomRotor("Test rotor", "ABC", "123");
        assertEquals('A', rotor.getPosition());
        rotor.rotate();
        assertEquals('B', rotor.getPosition());
        rotor.rotate();
        assertEquals('C', rotor.getPosition());
        rotor.rotate();
        assertEquals('A', rotor.getPosition());
        rotor.rotate();
    }

    @Test
    void notches() {
        var plainAlphabet = "ABC";
        char notch = 'B';
        var rotor = new CustomRotor("Test rotor", "ABC", "123", notch);
        for (int i = 0; i < 20; i++) {
            if (i % plainAlphabet.length() == plainAlphabet.indexOf(notch)) {
                assertEquals(notch, rotor.getPosition());
                assertTrue(rotor.rotate());
            } else {
                assertFalse(rotor.rotate());
            }
        }
    }
}
