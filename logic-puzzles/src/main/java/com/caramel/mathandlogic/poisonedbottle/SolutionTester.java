package com.caramel.mathandlogic.poisonedbottle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrycja.lisowska on 10.10.2017.
 * <p>
 * <p>
 * Steps for improvement of performance:
 * space: remove int fields from Bottle; later - change Bottle to enum
 */
public class SolutionTester {

    public static final int BOTTLE_COUNT = Integer.MAX_VALUE - 8;   // max size of an array that JVM can handle
    public static final int STRIPS_COUNT = Integer.SIZE;            // this needs Integer.SIZE strips, for storing 32-bit number

    public static final int POISONED_BOTTLE_INDEX = Integer.MAX_VALUE - 25;

    public static void main(String[] args) {
        long timeCheck = System.currentTimeMillis();
        List<Bottle> bottles = initializeBottles();
        List<TestStrip> strips = initializeTestStrips();
        System.out.println("Initializing: " + (System.currentTimeMillis() - timeCheck));

        timeCheck = System.currentTimeMillis();

        PoisonedBottlesProblemSolver solver = new PoisonedBottlesProblemSolver();
        int poisonedBottle = solver.findPoisonedBottle(bottles, strips);

        System.out.println("Solving: " + (System.currentTimeMillis() - timeCheck));
        System.out.println("Actual / expected: " + poisonedBottle + " / " + POISONED_BOTTLE_INDEX);
    }

    private static List<TestStrip> initializeTestStrips() {
        List<TestStrip> strips = new ArrayList<>();
        for (int i = 0; i < STRIPS_COUNT; i++) {
            strips.add(new TestStrip(i));
        }
        return strips;
    }

    private static List<Bottle> initializeBottles() {
        List<Bottle> bottles = new ArrayList<>(BOTTLE_COUNT);
        for (int i = 0; i < BOTTLE_COUNT; i++) {

            if (i == POISONED_BOTTLE_INDEX) {
                bottles.add(Bottle.POISONED);
            } else {
                bottles.add(Bottle.NORMAL);
            }

        }
        return bottles;
    }

}
