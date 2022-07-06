package se.harpo.cipher.enigma.reflector;

import se.harpo.cipher.substitution.SimpleSubstitutionCipher;

public class CustomReflector extends StandardReflector {
    public CustomReflector(String name, SimpleSubstitutionCipher cipher) {
        super(name, cipher);
    }

    public CustomReflector(String name, String cipherAlphabet) {
        super(name, new SimpleSubstitutionCipher("ABCDEFGHIJKLMNOPQRSTUVWXY", cipherAlphabet));
    }

    public CustomReflector(String name, String plainAlphabet, String cipheralphabet) {
        super(name, new SimpleSubstitutionCipher(plainAlphabet, cipheralphabet));
    }
}
