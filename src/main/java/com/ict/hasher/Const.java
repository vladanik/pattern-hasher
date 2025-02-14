package com.ict.hasher;

/**
 * Const holds constant values used throughout the hashing process.
 */
final class Const {

    /** The divisor used in the hashing algorithm. */
    public static final int TEN = 10;

    /** The ASCII difference applied for character transformation. */
    public static final int ASCII_DIFF = 32;

    /** The maximum allowed length of a hashed string. */
    public static final int MAX_HASH_LENGTH = 255;

    // Private constructor to prevent instantiation
    private Const() {
        throw new UnsupportedOperationException("main.java.com.ict.hasher.Const class cannot be instantiated.");
    }
}

