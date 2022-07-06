package se.harpo.algorithm;

public class Strings {
    /**
     * Removes all duplicate characters from a string.
     * @param duplicates string with duplicate characters
     * @return string with only unique characters
     */
    public static String removeDuplicatesCharacters(String duplicates) {
        StringBuilder unique = new StringBuilder();
        for (char character : duplicates.toCharArray()) {
            if (!unique.toString().contains(String.valueOf(character))) {
                unique.append(character);
            }
        }
        return unique.toString();
    }

    /**
     * Removes all instances of a character from a text
     * @param text a text with oocurances of the character
     * @param character character to remove from the text
     * @return the text with no occurances of the character
     */
    public static String removeAllCharacters(String text, char character) {
        return text.replaceAll(String.valueOf(character), "");
    }

    /**
     * Conforms a text to a reference string, removing all characters not contained in the reference string.
     * @param reference a reference string
     * @param text a text to conform to the reference string
     * @return a text with only characters contained in the reference string
     */
    public static String conformCharacters(String reference, String text) {
        var uniqueCharacters = removeDuplicatesCharacters(reference);
        var conformedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (uniqueCharacters.contains(String.valueOf(character))) {
                conformedText.append(character);
            }
        }
        return conformedText.toString();
    }
}
