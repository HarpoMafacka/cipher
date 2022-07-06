package se.harpo.cipher.enigma.reflector;

import se.harpo.cipher.substitution.SimpleSubstitutionCipher;

/**
 * An abstract standard implementation of an Enigma reflector.
 */
public abstract class StandardReflector implements Reflector {
    private final String name;
    private final SimpleSubstitutionCipher cipher;

    public StandardReflector(String name, SimpleSubstitutionCipher cipher) {
        this.name = name;
        this.cipher = cipher;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char encrypt(char character) {
        return cipher.encrypt(character);
    }
}
