package com.caramel.data.structures.linkedlist;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by patrycja.lisowska on 12.10.2017.
 */
public class DuplicatedRemovalPerformanceTests {

    public static void main(String[] args) {
        DuplicatesRemoval d = new DuplicatesRemoval();

        LinkedList<String> list = createList();


        long start = System.currentTimeMillis();
        d.removeDuplicatesLong(list);
        System.out.println("Iterator approach, with new list: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        d.removeDuplicatesShort(list);
        System.out.println("HashSet to LinkedList with new list: " +(System.currentTimeMillis()  - start));

        start = System.currentTimeMillis();
        d.removeDuplicatesInPlace(list);
        System.out.println("Iterator approach, with list modification: " + (System.currentTimeMillis()  - start));

    }

    private static LinkedList<String> createList() {
        LinkedList<String> list = new LinkedList<>();

        // adding some data that have duplicates
        list.add("abcd"); list.add("abcda");list.add("abcdb");list.add("abcdf");
        list.add("abck"); list.add("abcka");list.add("abckb");list.add("abckf");
        list.add("abcn"); list.add("abcna");list.add("abcnb");list.add("abcnf");
        list.add("abce"); list.add("abcea");list.add("abceb");list.add("abcef");
        list.add("abck"); list.add("abcka");list.add("abckb");list.add("abckf");
        list.add("abcb"); list.add("abcba");list.add("abcbb");list.add("abcbf");
        list.add("abcd"); list.add("abcda");list.add("abcdb");list.add("abcdf");
        list.add("abcl"); list.add("abcla");list.add("abclb");list.add("abclf");
        list.add("abcv"); list.add("abcva");list.add("abcvb");list.add("abcvf");
        list.add("abce"); list.add("abcea");list.add("abceb");list.add("abcef");
        list.add("abcg"); list.add("abcga");list.add("abcgb");list.add("abcgf");
        list.add("abce"); list.add("abcea");list.add("abceb");list.add("abcef");
        list.add("abcf"); list.add("abcfa");list.add("abcfb");list.add("abcff");
        list.add("abcq"); list.add("abcqa");list.add("abcqb");list.add("abcqf");
        list.add("abca"); list.add("abcaa");list.add("abcab");list.add("abcaf");
        list.add("abcf"); list.add("abcfa");list.add("abcfb");list.add("abcff");
        list.add("abcw"); list.add("abcwa");list.add("abcwb");list.add("abcwf");
        list.add("abcd"); list.add("abcda");list.add("abcdb");list.add("abcdf");
        list.add("abcg"); list.add("abcga");list.add("abcgb");list.add("abcgf");
        list.add("abce"); list.add("abcea");list.add("abceb");list.add("abcef");
        list.add("abcc"); list.add("abcca");list.add("abccb");list.add("abccf");
        list.add("abcg"); list.add("abcga");list.add("abcgb");list.add("abcgf");
        list.add("abcr"); list.add("abcra");list.add("abcrb");list.add("abcrf");
        list.add("abca"); list.add("abcaa");list.add("abcab");list.add("abcaf");
        list.add("abch"); list.add("abcha");list.add("abchb");list.add("abchf");
        list.add("abct"); list.add("abcta");list.add("abctb");list.add("abctf");
        list.add("abcz"); list.add("abcza");list.add("abczb");list.add("abczf");
        list.add("abcp"); list.add("abcpa");list.add("abcpb");list.add("abcpf");
        list.add("abcy"); list.add("abcya");list.add("abcyb");list.add("abcyf");
        list.add("abcx"); list.add("abcxa");list.add("abcxb");list.add("abcxf");
        list.add("abco"); list.add("abcoa");list.add("abcob");list.add("abcof");
        list.add("abcu"); list.add("abcua");list.add("abcub");list.add("abcuf");
        list.add("abcm"); list.add("abcma");list.add("abcmb");list.add("abcmf");


        // adding random data for increasing problem size
        RandomString rs = new RandomString(5);
        for (int i = 0; i < 5_000_000; i++) {
            list.add(rs.nextString());
        }
        return list;
    }
}
