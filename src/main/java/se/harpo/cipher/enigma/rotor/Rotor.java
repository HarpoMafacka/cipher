package se.harpo.cipher.enigma.rotor;

/**
 * A rotor is a wheel with 26 pins (one for each letter in the english alphabet) that can rotate. The rotor has internal
 * wiring that connects each input pin with one of the 26 output pins, making it a simple substitution cipher.
 */
public interface Rotor {
    /**
     * Get the name of the rotor
     * @return name
     */
    String getName();

    /**
     * Get the label on the position of the rotor
     * @return label
     */
    char getPosition();

    /**
     * Encrypt a character
     * @param character character to encrypt
     * @return encrypted character
     */
    char encrypt(char character);

    /**
     * Decrypt a character
     * @param character character to decrypt
     * @return decrypted character
     */
    char decrypt(char character);

    /**
     * Rotate the rotor one step
     * @return true if the position has a notch
     */
    boolean rotate();
}
