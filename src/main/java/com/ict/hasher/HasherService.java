package main.java.com.ict.hasher;

import java.util.Arrays;

/**
 * The HasherService class provides a hashing mechanism using a character pattern.
 * It processes input strings and converts them into hashed representations.
 */
public class HasherService {
    private final char[] pattern;

    /**
     * Constructs a HasherService with a given pattern.
     *
     * @param pattern The character sequence used for hashing.
     */
    public HasherService(String pattern) {
        this.pattern = Arrays.copyOf(pattern.toCharArray(), pattern.length());
        for (int i = 0; i < pattern.length(); i++) {
            this.pattern[i] = validate(this.pattern[i]);
        }
    }

    /**
     * Hashes the input string based on the pattern.
     *
     * @param input The input string to be hashed.
     * @return The hashed representation of the input string.
     */
    public String hash(String input) {
        StringBuilder hashed = new StringBuilder();

        for (char c : input.toCharArray()) {
            int tens = c / Const.TEN;
            int mod = c % Const.TEN;

            for (int i = 0; i < tens; i++) {
                char patternChar = pattern[i % pattern.length];
                hashed.append(validate((char) (patternChar - Const.ASCII_DIFF)));
            }
            for (int i = 0; i < mod; i++) {
                hashed.append(pattern[i % pattern.length]);
            }
        }

        return cut(hashed);
    }

    /**
     * Ensures the given character falls within the valid ASCII range.
     *
     * @param c The character to validate.
     * @return The adjusted character within the valid range.
     */
    private char validate(char c) {
        final int min = 33;  // Lowest valid ASCII printable character
        final int max = 126; // Highest valid ASCII printable character
        return (char) ((c < min) ? (max - (min - c)) : ((c > max) ? (min + (c - max)) : c));
    }

    /**
     * Cuts or extends the hashed output to match the defined maximum length.
     *
     * @param s The hashed StringBuilder object.
     * @return The final hashed string with a fixed length.
     */
    private String cut(StringBuilder s) {
        final int maxLen = Const.MAX_HASH_LENGTH;

        if (s.length() < maxLen) {
            return s.toString().repeat((maxLen / s.length()) + 1).substring(0, maxLen);
        }

        while (s.length() > maxLen) {
            int step = Math.max(2, s.length() / maxLen);
            for (int i = step - 1; i < s.length() && s.length() > maxLen; i += step) {
                s.deleteCharAt(i);
            }
        }

        return s.toString();
    }
}
