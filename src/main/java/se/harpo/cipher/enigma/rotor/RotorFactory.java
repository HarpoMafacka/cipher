package se.harpo.cipher.enigma.rotor;

import java.util.List;

public class RotorFactory {
    private static List<Rotor> rotors = List.of(
            new CustomRotor("I",  "EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'),
            new CustomRotor("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
            new CustomRotor("III",  "BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'),
            new CustomRotor("IV",  "ESOVPZJAYQUIRHXLNFTGKDCMWB", 'J'),
            new CustomRotor("V",  "VZBRGITYUPSDNHLXAWMJQOFECK", 'Z'),
            new CustomRotor("VI", "JPGVOUMFYQBENHZRDKASXLICTW", 'Z', 'M'),
            new CustomRotor("VII", "NZJHGRCXMYSWBOUFAIVLPEKQDT", 'Z', 'M'),
            new CustomRotor("VIII", "FKQHTLXOCBJSPDZRAMEWNIUYGV", 'Z', 'M')
    );

    public static List<Rotor> getEnigmaIRotors() {
        return rotors.subList(0, 3);
    }
}
