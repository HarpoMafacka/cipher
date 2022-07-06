package se.harpo.algorithm;

public class Wrap {
    /**
     * Wraps a value inside a specified range.
     * Works for values above and below the range.
     * Works for negative values.
     * @param start the start of the range (inclusive)
     * @param end the end of the range (exclusive)
     * @param value the value to wrap
     * @return a value in the range
     */
    public static int wrapInsideRange(int start, int end, int value) {
        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }
        int addend = value < start ? end : start;
        int modulus = (value - start) % (end - start);
        return modulus == 0 && addend != start ? modulus : addend + modulus;
    }
}
