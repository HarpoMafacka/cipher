package se.harpo.cipher.enigma.rotor;

import se.harpo.cipher.substitution.SimpleSubstitutionCipher;

import java.util.ArrayList;
import java.util.List;

import static se.harpo.algorithm.Wrap.wrapInsideRange;

public abstract class StandardRotor implements Rotor {
    private final String name;
    private final SimpleSubstitutionCipher cipher;
    private final SimpleSubstitutionCipher inverse;
    private final List<Character> notches = new ArrayList<>();
    private int rotation = 0;

    public StandardRotor(String name, SimpleSubstitutionCipher cipher, char... notches) {
        this.name = name;
        this.cipher = cipher;
        for (char notch : notches) {
            this.notches.add(Character.toUpperCase(notch));
        }
        this.inverse = cipher.invert();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getPosition() {
        return cipher.getPlainAlphabet().charAt(rotation);
    }

    @Override
    public char encrypt(char character) {
        var newCharacter = translateCharacter(character, cipher.getPlainAlphabet(), rotation);
        return cipher.encrypt(newCharacter);
    }

    @Override
    public char decrypt(char character) {
        var newCharacter = translateCharacter(character, cipher.getCipherAlphabet(), -rotation);
        return inverse.encrypt(newCharacter);
    }

    @Override
    public boolean rotate() {
        boolean hasNotch = notches.contains(cipher.getPlainAlphabet().charAt(rotation));
        rotation = wrapInsideRange(0, cipher.getPlainAlphabet().length(), rotation + 1);
        return hasNotch;
    }

    /**
     * Translate from one character into another in an alphabet using a rotational offset.
     * A translation of A in the english alphabet and a rotation of 2 will yield a C.
     * A Y translates into an A with the same rotation.
     * @param character character to translate
     * @param alphabet the alphabet to use for the translation
     * @param rotation the rotation of the rotor
     * @return a translated character
     */
    protected static char translateCharacter(char character, String alphabet, int rotation) {
        int index = alphabet.indexOf(character);
        if (index == -1) {
            return character;
        }
        index = wrapInsideRange(0, alphabet.length(), index + rotation);
        return alphabet.charAt(index);
    }
}
