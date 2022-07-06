package se.harpo.cipher.enigma;

import org.junit.jupiter.api.Test;
import se.harpo.cipher.enigma.reflector.CustomReflector;
import se.harpo.cipher.enigma.rotor.CustomRotor;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnigmaMachineTest {
    @Test
    void shouldEncrypt() {
        var enigma = new EnigmaMachine(new CustomReflector("Test Reflector", "EJMZALYXVBWFCRQUONTSPIKHGD"),
                new CustomRotor("I",  "EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'),
                new CustomRotor("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
                new CustomRotor("III",  "BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'));

        assertEquals('G', enigma.input('A'));
    }
}