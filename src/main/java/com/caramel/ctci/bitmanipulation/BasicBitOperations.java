package com.caramel.ctci.bitmanipulation;

/**
 * Created by patrycja.lisowska on 08.10.2017.
 */
public class BasicBitOperations {


    public static boolean getBit(int num, int i) {
        // 1 << i  ->  000...001000000
        return ((num & (1 << i)) != 0);
    }


}
