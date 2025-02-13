package main.java.com.ict.hasher;

/**
 * Hasher provides utility methods for hashing strings
 * and verifying equality of hashed values.
 */
public class Hasher {

    /**
     * Generates a hash for the given input string using the specified pattern.
     *
     * @param input   The input string to hash.
     * @param pattern The pattern used for hashing.
     * @return The hashed representation of the input string.
     */
    public static String hash(String input, String pattern) {
        return new HasherService(pattern).hash(input);
    }

    /**
     * Checks if a given hashed value matches the hash of the input string.
     *
     * @param hash    The expected hashed value.
     * @param input   The input string to hash and compare.
     * @param pattern The pattern used for hashing.
     * @return True if the hash of the input matches the given hash, false otherwise.
     */
    public static boolean equals(String hash, String input, String pattern) {
        return hash.equals(hash(input, pattern));
    }
}

