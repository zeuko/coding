package com.caramel.mathandlogic;

/**
 * Created by patrycja.lisowska on 08.10.2017.
 */
public class EratosthenesSieve {

    public static boolean[] compute(int max) {
        boolean[] flags = new boolean[max + 1];

        for (int i = 2; i < max + 1; i++) {
            flags[i] = true;
        }

        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOffMultiples(flags, prime);
            prime = getNextPrime(flags, prime);
        }


        return flags;
    }

    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;

        while (next < flags.length && !flags[next]) {
            next++;
        }

        return next;
    }

    private static void crossOffMultiples(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }


    public static void main(String[] args) {
        boolean[] compute = EratosthenesSieve.compute(10000);

        for (int i = 0; i < compute.length; i++) {
            boolean isPrime = compute[i];
            if (isPrime) {
                System.out.println(i);
            }
        }

    }

}
