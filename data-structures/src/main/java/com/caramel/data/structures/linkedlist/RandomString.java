package com.caramel.data.structures.linkedlist;

import java.util.Random;

/**
 * Created by patrycja.lisowska on 12.10.2017.
 */
public class RandomString {

    public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITS = "0123456789";

    private static final char[] ALPHANUMERIC_SYMBOLS = (UPPER + LOWER + DIGITS).toCharArray();
    private static final Random RANDOM = new Random();

    private final char[] buf;

    public RandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();
        this.buf = new char[length];
    }

    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = ALPHANUMERIC_SYMBOLS[RANDOM.nextInt(ALPHANUMERIC_SYMBOLS.length)];
        }
        return new String(buf);
    }
}

