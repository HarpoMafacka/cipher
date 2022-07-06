package se.harpo.cipher.enigma.reflector;

import java.util.List;

public class ReflectorFactory {
    private static final List<Reflector> reflectors = List.of(
            new CustomReflector("Reflector A", "EJMZALYXVBWFCRQUONTSPIKHGD"),
            new CustomReflector("Reflector B", "YRUHQSLDPXNGOKMIEBFZCWVJAT"),
            new CustomReflector("Reflector C", "FVPJIAOYEDRZXWGCTKUQSBNMHL")
    );

    public static List<Reflector> getReflectors() {
        return reflectors;
    }
}