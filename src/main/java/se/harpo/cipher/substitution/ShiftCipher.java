package se.harpo.cipher.substitution;

import static se.harpo.algorithm.Wrap.wrapInsideRange;

/**
 * A shift cipher is a simple substitution cipher where each character in a plain text alphabet is replaced with a
 * character some fixed number of positions down the cipher alphabet.
 * With a shift of 3, the letter A in the english alphabet would be replaced by the letter D.
 * With a shift of -5, the letter A in the english alphabet would be replaced by the letter V.
 */
public class ShiftCipher extends SimpleSubstitutionCipher {
    /**
     * Create a shift cipher from the english alphabet (A-Z).
     * @param key the number of positions to shift the cipher alphabet.
     *            Negative numbers shift the cipher alphabet left.
     *            Positive numbers shift the cipher alphabet right.
     *            A key of 0 will not encrypt messages.
     */
    public ShiftCipher(int key) {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", key);
    }

    /**
     * Create a custom shift cipher using a provided plain text alphabet.
     * @param plainAlphabet plain text alphabet
     * @param key the number of positions to shift the cipher alphabet.
     *            Negative numbers shift the cipher alphabet left.
     *            Positive numbers shift the cipher alphabet right.
     *            A key of 0 will not encrypt messages.
     */
    public ShiftCipher(String plainAlphabet, int key) {
        super(plainAlphabet, generateCipherAlphabet(plainAlphabet, key));
    }

    /**
     * Generate a shift cipher alphabet, where all letters of a plain text alphabet is shifted.
     * @param plainAlphabet the plain text alphabet
     * @param key the number of positions to shift the cipher alphabet.
     *            Negative numbers shift the cipher alphabet left.
     *            Positive numbers shift the cipher alphabet right.
     *            A key of 0 will not encrypt messages.
     * @return a cipher alphabet
     */
    public static String generateCipherAlphabet(String plainAlphabet, int key) {
        var shift = wrapInsideRange(0, plainAlphabet.length(), key);
        var cipherAlphabet = new char[plainAlphabet.length()];
        for (int i = 0; i < plainAlphabet.length(); i++) {
            int cipherIndex = wrapInsideRange(0, plainAlphabet.length(), i + shift);
            cipherAlphabet[i] = plainAlphabet.charAt(cipherIndex);
        }
        return new String(cipherAlphabet);
    }
}
