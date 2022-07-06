package se.harpo.cipher;

/**
 * A Caesar cipher is a shift cipher where the key is 3. In other words, where the plain alphabet is shifted 3 steps
 * to create the cipher alphabet. The cipher got its named from Julius Caesar, who used this encryption in his private
 * correspondence.
 */
public class CaesarCipher extends ShiftCipher {
    /**
     * Create a Caesar cipher from the english alphabet (A-Z).
     */
    public CaesarCipher() {
        super(3);
    }

    /**
     * Create a custom Caesar cipher using the provided plain text alphabet.
     * @param plainAlphabet plain text alphabet
     */
    public CaesarCipher(String plainAlphabet) {
        super(plainAlphabet, 3);
    }
}
