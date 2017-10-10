package com.caramel.bitmanipulation;

/**
 * Created by patrycja.lisowska on 08.10.2017.
 */
public class BasicBitOperations {

    public static boolean getBit(int num, int i) {
        if (i > Integer.SIZE - 1) {
            throw new RuntimeException("Integer is " + Integer.SIZE + " bits long, cannot get bit " + i);
        }
        // 1 << i  ->  000...001000000
        return ((num & (1 << i)) != 0);
    }

    public static int setBit(int num, int i) {
        if (i > Integer.SIZE - 1) {
            throw new RuntimeException("Integer is " + Integer.SIZE + " bits long, cannot set bit " + i);
        }
        int mask = 1 << i;
        return num | mask;
    }

    public static int clearBit(int num, int i) {
        if (i > Integer.SIZE - 1) {
            throw new RuntimeException("Integer is " + Integer.SIZE + " bits long, cannot clear bit " + i);
        }
        int mask = ~(1 << i); // 1111.....1110111111
        return num & mask;
    }
}
