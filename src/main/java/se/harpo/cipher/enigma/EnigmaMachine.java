package se.harpo.cipher.enigma;

import se.harpo.cipher.enigma.reflector.Reflector;
import se.harpo.cipher.enigma.rotor.Rotor;

public class EnigmaMachine {
    private Reflector reflector;
    private Rotor[] rotors;

    public EnigmaMachine(Reflector reflector, Rotor... rotors) {
        this.reflector = reflector;
        this.rotors = rotors;
    }

    /**
     * Input a character into the Enigma by pressing one of the keys.
     * The key press will rotate the rotors and then complete a circuit that will light up a light bulb with a letter
     * on it. The lit up bulb represents the encrypted character
     * @param key the character of the key pressed
     * @return the character of the light buld that lights up
     */
    public char input(char key) {
        rotate();
        char encrypted = encrypt(key);
        char reflected = reflect(encrypted);
        return decrypt(reflected);
    }

    /**
     * Encrypt a message.
     * @param message the message to encrypt
     * @return encrypted message
     */
    public String input(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char character : message.toCharArray()) {
            encryptedMessage.append(input(character));
        }
        return encryptedMessage.toString();
    }

    private void rotate() {
        for (Rotor rotor : rotors) {
            if (!rotor.rotate()) {
                break;
            }
        }
    }

    private char encrypt(char character) {
        for (int i = 0; i < rotors.length; i++) {
            character = rotors[i].encrypt(character);
        }
        return character;
    }

    private char reflect(char character) {
        return reflector.encrypt(character);
    }

    private char decrypt(char character) {
        for (int i = rotors.length - 1; i >= 0; i--) {
            character = rotors[i].decrypt(character);
        }
        return character;
    }

    @Override
    public String toString() {
        StringBuilder settings = new StringBuilder("Rotor positions: ");
        for (Rotor rotor : rotors) {
            settings.append(rotor.getPosition());
        }
        return settings.toString();
    }
}
