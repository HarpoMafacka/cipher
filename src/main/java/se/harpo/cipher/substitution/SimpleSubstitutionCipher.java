package se.harpo.cipher.substitution;

import se.harpo.cipher.Cipher;

import static se.harpo.algorithm.Strings.*;

/**
 * A simple substitution cipher is a monoalphabetic cipher where each character in a plain text alphabet is replaced by
 * a letter in a cipher alphabet from the same set of characters. The characters in the cipher alphabet may be shifted,
 * reversed or scrambled.
 */
public class SimpleSubstitutionCipher implements Cipher, MonoalphabeticSubstitutionCipher {
    private String plainAlphabet;
    private String cipherAlphabet;

    /**
     * Create a simple substitution cipher where each character in a plain text alphabet is replaced by a character in a
     * cipher alphabet.
     * @param plainAlphabet the plain text alphabet
     * @param cipherAlphabet the cipher alphabet.
     *                       Duplicate characters will be removed.
     *                       Any characters beyond the plain text alphabet will be ignored.
     *                       If the cipher alphabet is shorter than the plain text alphabet, remaining letters will not
     *                       be encrypted.
     */
    public SimpleSubstitutionCipher(String plainAlphabet, String cipherAlphabet) {
        this.plainAlphabet = removeDuplicatesCharacters(plainAlphabet.toUpperCase());
        this.cipherAlphabet = removeDuplicatesCharacters(cipherAlphabet.toUpperCase());
    }

    /**
     * Generate a cipher alphabet from a plain text alphabet using a keyword.
     * All duplicate characters in the plain text alphabet and the keyword will be removed.
     * The first character in the keyword will replace the first letter in the plain text alphabet, and so on,
     * until the last letter of the keyword is used. The remaining letters in the plain text alphabet will then be used
     * to pad the cipher alphabet until it is of the same length as the plain text alphabet.
     * A plain text alphabet of ABCDEFGHIJKLMNOPQRSTUVWXYZ and the keyword ZEBRAS will generate the following cipher
     * alphabet: ZEBRASCDFGHIJKLMNOPQTUVWXY.
     * @param plainAlphabet plain text alphabet
     * @param keyword a keyword used to generate the cipher alphabet
     * @return a cipher alphabet
     */
    public static String generateCipherAlphabet(String plainAlphabet, String keyword) {
        plainAlphabet = removeDuplicatesCharacters(plainAlphabet.toUpperCase());
        keyword = removeDuplicatesCharacters(keyword);
        keyword = conformCharacters(plainAlphabet, keyword);
        String cipherAlphabet = removeDuplicatesCharacters(keyword.toUpperCase());
        String remainingCharacters = plainAlphabet;
        for (char keywordCharacter : cipherAlphabet.toCharArray()) {
            remainingCharacters = removeAllCharacters(remainingCharacters, keywordCharacter);
        }
        return (cipherAlphabet.toUpperCase() + remainingCharacters.toUpperCase())
                .substring(0, plainAlphabet.length());
    }

    @Override
    public String getPlainAlphabet() {
        return plainAlphabet;
    }

    @Override
    public String getCipherAlphabet() {
        return cipherAlphabet;
    }

    /**
     * Encrypt a character if it is present in the plain text alphabet.
     * @param character character to encrypt
     * @return an encrypted character from the cipher alphabet.
     * If the plain text alphabet does not contain the character, the character itself is returned.
     */
    @Override
    public char encrypt(char character) {
        int index = plainAlphabet.indexOf(Character.toUpperCase(character));
        return index == -1 || index >= cipherAlphabet.length() ? character : cipherAlphabet.charAt(index);
    }

    /**
     * Encrypt a message using the cipher.
     * @param message the message to encrypt
     * @return the encrypted message
     */
    @Override
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char character : message.toCharArray()) {
            encryptedMessage.append(encrypt(character));
        }
        return encryptedMessage.toString();
    }

    /**
     * Create a new cipher that is the exact inverse of this cipher.
     * If this cipher replaces A with J, then the inverted cipher will replace J with A.
     * The inverse of a cipher can be used to decrypt an encrypted message.
     * @return an inverse of this cipher
     */
    @Override
    public SimpleSubstitutionCipher invert() {
        return new SimpleSubstitutionCipher(cipherAlphabet, plainAlphabet);
    }
}
