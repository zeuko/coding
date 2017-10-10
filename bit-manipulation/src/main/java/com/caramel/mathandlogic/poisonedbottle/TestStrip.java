package com.caramel.mathandlogic.poisonedbottle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrycja.lisowska on 10.10.2017.
 */
public class TestStrip {

    private int id;

    private List<Integer> positiveDays = new ArrayList<>();

    public TestStrip(int i) {
        this.id = i;
    }

    public void addDropOnDay(int day, Bottle bottle) {
        if (bottle.isPoisoned()) {
            positiveDays.add(day+7);
        }
    }

    public int getId() {
        return id;
    }

    public boolean isPositiveOnDay(int day) {
        return positiveDays.contains(day);
    }
}
