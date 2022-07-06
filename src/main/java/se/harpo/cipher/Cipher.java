package se.harpo.cipher;

public interface Cipher {
    char encrypt(char character);
    String encrypt(String message);
    Cipher invert();
}