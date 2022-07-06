package se.harpo.cipher;

import static se.harpo.algorithm.Strings.removeDuplicatesCharacters;

/**
 * An Atbash (Atbaš) substitution cipher is a cipher where each character in a plain text alphabet is replaced by a
 * character in a cipher alphabet. The cipher alphabet is a reverse of the plain text alphabet. A plain text alphabet
 * of ABCDE will generate EDCBA as a cipher alphabet. This cipher was originally used to encrypt the Hebrew alphabet.
 * The name derives from the first, last, second, and second to last Hebrew letters (Aleph–Taw–Bet–Shin).
 */
public class AtbashCipher extends SimpleSubstitutionCipher {
    /**
     * Create an Atbash substitution cipher.
     * @param plainAlphabet plain text alphabet
     */
    public AtbashCipher(String plainAlphabet) {
        super(plainAlphabet, generateCipherAlphabet(plainAlphabet));
    }

    /**
     * Generates an Atbash substitution alphabet (a reverse of the plain text alphabet).
     * @param plainAlphabet plain text alphabet
     * @return Atbash cipher alphabet
     */
    public static String generateCipherAlphabet(String plainAlphabet) {
        plainAlphabet = removeDuplicatesCharacters(plainAlphabet);
        StringBuilder reverse = new StringBuilder();
        for (char character : plainAlphabet.toCharArray()) {
            reverse.insert(0, character);
        }
        return reverse.toString();
    }
}
