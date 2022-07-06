package se.harpo.cipher.enigma.reflector;

/**
 * A reflector is a simple substitution cipher used to bounce the signal in the enigma machine back through the rotors
 * to complete the circuit.
 */
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
