package se.harpo.cipher.enigma.reflector;

import se.harpo.cipher.SimpleSubstitutionCipher;

public abstract class StandardReflector implements Reflector {
    private final String name;
    private final SimpleSubstitutionCipher cipher;

    public StandardReflector(String name, SimpleSubstitutionCipher cipher) {
        this.name = name;
        this.cipher = cipher;
    }

    @Override
    public String getName() {
        return;
    }

    @Override
    public char encrypt(char character) {
        return cipher.encrypt(character);
    }
}