package se.harpo.cipher.enigma.reflector;

public interface Reflector {
    /**
     * Get the name of the reflector
     * @return name
     */
    String getName();
    /**
     * Encrypt a character
     * @param character character to encrypt
     * @return encrypted character
     */
    char encrypt(char character);
}
