package se.harpo.cipher.enigma.rotor;

import se.harpo.cipher.SimpleSubstitutionCipher;

public class CustomRotor extends StandardRotor {
    public CustomRotor(String name, SimpleSubstitutionCipher cipher, char... notches) {
        super(name, cipher, notches);
    }

    public CustomRotor(String name, String cipherAlphabet, char... notches) {
        super(name, new SimpleSubstitutionCipher("ABCDEFGHIJKLMNOPQRSTUVWXY", cipherAlphabet), notches);
    }

    public CustomRotor(String name, String plainAlphabet, String cipherAlphabet, char... notches) {
        super(name, new SimpleSubstitutionCipher(plainAlphabet, cipherAlphabet), notches);
    }
}
