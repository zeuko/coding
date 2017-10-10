package com.caramel.mathandlogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by patrycja.lisowska on 10.10.2017.
 * <p>
 * In the new post-apocalyptic world, the world queen is desperately concerned
 * about the birth rate. Therefore, she decrees that all families should ensure that they have one girl or
 * else they face massive fines. If all families abide by this policy-that is, they have continue to have
 * children until they have one girl, at which point they immediately stop-what will the gender ratio
 * of the new generation be? (Assume that the odds of someone having a boy or a girl on any given
 * pregnancy is equal.)
 */
public class Apocalypse {
    private static Random random = new Random();

    public static void main(String[] args) {
        int familyCount = 1_000_000_0;
        int boys = 0;
        int girls = 0;
        for (int i = 0; i < familyCount; i++) {
            ChildrenCount children = getChildren();
            boys += children.getBoys();
            girls += children.getGirls();
        }
        System.out.println((double) boys / (double) girls);
    }

    private enum Child {
        BOY, GIRL;

        static Child getRandom() {
            return random.nextBoolean() ? BOY : GIRL;
        }
    }

    private static class ChildrenCount {
        private final int boys;
        private final int girls;

        public ChildrenCount(int boys, int girls) {
            this.boys = boys;
            this.girls = girls;
        }

        public int getBoys() {
            return boys;
        }

        public int getGirls() {
            return girls;
        }
    }

    private static ChildrenCount getChildren() {

        int boys = 0;

        while (true) {
            Child child = Child.getRandom();
            if (child == Child.BOY) boys++;
            else return new ChildrenCount(boys, 1);
        }

    }
}
