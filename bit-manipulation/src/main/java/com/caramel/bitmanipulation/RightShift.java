package com.caramel.bitmanipulation;

/**
 * Created by patrycja.lisowska on 09.10.2017.
 */
public class RightShift {


    public static void main(String[] args) {
        int exampleInt = 128;

        System.out.println(
                "Logical shift        >>>     pushes 0s in most significant bits\n" +
                "Arithmetical shift   >>      pushes sign bit in most significant bits"
        );

        System.out.println(exampleInt + ":\t" + Integer.toBinaryString(exampleInt)+" >>> 4 = " + Integer.toBinaryString(exampleInt >>> 4)+ ", decimal: " + (exampleInt >>> 4));
        System.out.println(exampleInt + ":\t" + Integer.toBinaryString(exampleInt)+"  >> 4 = " + Integer.toBinaryString(exampleInt >> 4) + ", decimal: " + (exampleInt >> 4));

        System.out.println(-exampleInt + ":\t" + Integer.toBinaryString(-exampleInt)+" >>> 4 = " + Integer.toBinaryString(-exampleInt >>> 4)+ ", decimal: " + (-exampleInt >>> 4));
        System.out.println(-exampleInt + ":\t" + Integer.toBinaryString(-exampleInt)+"  >> 4 = " + Integer.toBinaryString(-exampleInt >> 4) + ", decimal: " + (-exampleInt >> 4));

        System.out.println(exampleInt + ":\t" + Integer.toBinaryString(exampleInt)+" >>> 6 = " + Integer.toBinaryString(exampleInt >>> 6));
        System.out.println(exampleInt + ":\t" + Integer.toBinaryString(exampleInt)+"  >> 6 = " + Integer.toBinaryString(exampleInt >> 6));

        System.out.println(-exampleInt + ":\t" + Integer.toBinaryString(-exampleInt)+" >>> 6 = " + Integer.toBinaryString(-exampleInt >>> 6));
        System.out.println(-exampleInt + ":\t" + Integer.toBinaryString(-exampleInt)+"  >> 6 = " + Integer.toBinaryString(-exampleInt >> 6));

    }
}
