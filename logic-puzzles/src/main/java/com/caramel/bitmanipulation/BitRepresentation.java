package com.caramel.bitmanipulation;

/**
 * Created by patrycja.lisowska on 09.10.2017.
 */
public class BitRepresentation {

    public static void main(String[] args) {
        printMinAndMaxIntegersAsBinary();
        printBinaryStringsExamples();
    }

    private static void printMinAndMaxIntegersAsBinary() {
        System.out.println("Max int: " + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("Min int: " + Integer.toBinaryString(Integer.MIN_VALUE));
    }

    private static void printBinaryStringsExamples() {
        for (int i = -50; i < 51; i++) {
            System.out.println(""+i + ": "+Integer.toBinaryString(i));
        }
    }

}
