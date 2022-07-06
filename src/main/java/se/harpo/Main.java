package se.harpo;

import se.harpo.cipher.enigma.EnigmaMachine;
import se.harpo.cipher.formatting.GroupFormatter;
import se.harpo.cipher.enigma.reflector.CustomReflector;
import se.harpo.cipher.enigma.rotor.CustomRotor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) {
        var enigma = new EnigmaMachine(new CustomReflector("Test Reflector", "EJMZALYXVBWFCRQUONTSPIKHGD"),
                new CustomRotor("I",  "EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'),
                new CustomRotor("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
                new CustomRotor("III",  "BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'));
        var messageFormatter = new GroupFormatter();

        System.out.println("In front of you is an Enigma encoding machine.");
        System.out.println("Input a message containing a-z or A-Z followed by an enter to encrypt your message.");
        System.out.println("input EXIT to close the lid of the machine.");
        System.out.println(enigma.toString());

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String message = "";;
        while (!message.equalsIgnoreCase("EXIT")) {
            try {
                message = reader.readLine();
            } catch (Exception e) {}
            System.out.println(enigma.input(message, messageFormatter));
            System.out.println(enigma);
        }
    }
}