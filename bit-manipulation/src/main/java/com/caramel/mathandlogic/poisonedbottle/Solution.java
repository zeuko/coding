package com.caramel.mathandlogic.poisonedbottle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrycja.lisowska on 10.10.2017.
 */
public class Solution {

    public static final int STEP_SIZE = 100_000;
    public static final int BOTTLE_COUNT = 0xfffffff;
    public static final int STRIPS_COUNT = 32;
    public static final int POISONED_BOTTLE_INDEX = 44444;

    public static void main(String[] args) {
        long timeCheck = System.currentTimeMillis();
        List<Bottle> bottles = new ArrayList<>(BOTTLE_COUNT);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BOTTLE_COUNT; i++) {

            if (i == POISONED_BOTTLE_INDEX) {
                bottles.add(Bottle.createPoisoned(i));
            } else {
                bottles.add(Bottle.createNormal(i));
            }

            printIterationDebugInfo(timeCheck, i);
            timeCheck = System.currentTimeMillis();
        }

        List<TestStrip> strips = new ArrayList<>();

        for (int i = 0; i < STRIPS_COUNT; i++) {
            strips.add(new TestStrip(i));
        }

        System.out.println("Initializing: " + (System.currentTimeMillis() - timeCheck));

        timeCheck = System.currentTimeMillis();
        Solution solution = new Solution();
        int poisonedBottle = solution.findPoisonedBottle(bottles, strips);

        System.out.println("Solving: " + (System.currentTimeMillis() - timeCheck));
        System.out.println(poisonedBottle);
    }

    private static void printIterationDebugInfo(long timeCheck, int i) {
        if (i % STEP_SIZE == 0) {
            System.out.println("Iteration time for step " + i / STEP_SIZE + ": " + (System.currentTimeMillis() - timeCheck));
        }
    }

    public int findPoisonedBottle(List<Bottle> bottles, List<TestStrip> strips) {
        runTests(bottles, strips);
        List<Integer> positive = getPositiveOnDay(strips, 7);
        return setBits(positive);
    }

    private void runTests(List<Bottle> bottles, List<TestStrip> strips) {
        for (Bottle bottle : bottles) {
            applyDropsOnProperStrips(strips, bottle);
        }
    }

    private void applyDropsOnProperStrips(List<TestStrip> strips, Bottle bottle) {
        int id = bottle.getId();
        int bitIndex = 0;
        // mapping binary id representation to test strip indexes
        while (id > 0) {
            if (isLowestBitSet(id)) {
                strips.get(bitIndex).addDropOnDay(0, bottle);
            }
            bitIndex++;
            id = id >> 1;
        }
    }

    private boolean isLowestBitSet(int id) {
        return (id & 1) == 1;
    }

    private int setBits(List<Integer> positive) {
        int id = 0;
        for (Integer bitIndex : positive) {
            id = id | (1 << bitIndex);
        }
        return id;
    }

    private List<Integer> getPositiveOnDay(List<TestStrip> strips, int day) {
        List<Integer> positive = new ArrayList<>();

        for (TestStrip strip : strips) {
            int id = strip.getId();
            if (strip.isPositiveOnDay(day)) {
                positive.add(id);
            }
        }

        return positive;
    }

}
