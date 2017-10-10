package com.caramel.mathandlogic.poisonedbottle;

import java.util.ArrayList;
import java.util.List;

public class PoisonedBottlesProblemSolver {

    public int findPoisonedBottle(List<Bottle> bottles, List<TestStrip> strips) {
        runTests(bottles, strips);
        List<Integer> positive = getPositiveOnDay(strips, 7);
        return setBits(positive);
    }

    private void runTests(List<Bottle> bottles, List<TestStrip> strips) {
        for (int i = 0; i < bottles.size(); i++) {
            Bottle bottle = bottles.get(i);
            applyDropsOnProperStrips(strips, bottle, i);
        }
    }

    private void applyDropsOnProperStrips(List<TestStrip> strips, Bottle bottle, int bottleIndex) {
        int bitIndex = 0;
        // mapping binary id representation to test strip indexes
        while (bottleIndex > 0) {
            if (isLowestBitSet(bottleIndex)) {
                strips.get(bitIndex).addDropOnDay(0, bottle);
            }
            bitIndex++;
            bottleIndex = bottleIndex >> 1;
        }
    }

    private boolean isLowestBitSet(int id) {
        return (id & 1) == 1;
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

    private int setBits(List<Integer> positive) {
        int id = 0;
        for (Integer bitIndex : positive) {
            id = id | (1 << bitIndex);
        }
        return id;
    }
}