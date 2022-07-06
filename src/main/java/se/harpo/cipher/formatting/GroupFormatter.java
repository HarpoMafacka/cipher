package se.harpo.cipher.formatting;

import se.harpo.algorithm.Strings;
import se.harpo.cipher.Alphabets;

public class GroupFormatter implements MessageFormatter {
    private static final int COLUMNS = 4;
    private final int groupSize;

    public GroupFormatter() {
        this.groupSize =5;
    }

    public GroupFormatter(int groupSize) {
        this.groupSize = groupSize;
    }
    @Override
    public String format(String input) {
        var message = prepareInput(input);
        return group(message);
    }

    private String prepareInput(String input) {
        var conformedInput = Strings.conformCharacters(Alphabets.ENGLISH_ALPHABET, input.toUpperCase());
        StringBuilder message = new StringBuilder(conformedInput);
        int padding = groupSize - (message.length() % groupSize);
        message.append("A".repeat(padding));
        return message.toString();
    }

    private String group(String message) {
        StringBuilder formattedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i = i + groupSize) {
            formattedMessage.append(message, i, i + groupSize);
            formattedMessage.append(" ");
            if (i % (groupSize * COLUMNS) == 3 * groupSize) {
                formattedMessage.append('\n');
            }
        }
        return formattedMessage.toString();
    }
}
