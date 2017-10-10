package com.caramel.mathandlogic.poisonedbottle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by patrycja.lisowska on 10.10.2017.
 */
public class TestStrip {

    private int id;

    private Set<Integer> positiveDays = new HashSet<>();

    public TestStrip(int i) {
        this.id = i;
    }

    public void addDropOnDay(int day, Bottle bottle) {
        if (bottle == Bottle.POISONED) {
            positiveDays.add(day + 7);
        }
    }

    public int getId() {
        return id;
    }

    public boolean isPositiveOnDay(int day) {
        return positiveDays.contains(day);
    }
}
