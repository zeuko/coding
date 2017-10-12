package com.caramel.data.structures.linkedlist;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by patrycja.lisowska on 12.10.2017.
 */
public class DuplicatesRemoval {


    public <T> SingleLinkedList<T> removeDuplicates(SingleLinkedList<T> list) {
        if (list.getSize() < 2) {
            return list;
        }

        SingleLinkedList.Node<T> current = list.getFirst();
        SingleLinkedList.Node<T> previous = null;

        HashSet<T> uniqueElements = new HashSet<>();
        while (current != null) {
            if (uniqueElements.contains(current.value)) {
                previous.next = current.next;
            } else {
                uniqueElements.add(current.value);
                previous = current;
            }
            current = current.next;
        }

        return list;
    }


    public <T> LinkedList<T> removeDuplicatesLong(LinkedList<T> list) {
        LinkedList<T> withoutDuplicates = new LinkedList<>(list);
        removeDuplicatesInPlace(withoutDuplicates);
        return withoutDuplicates;
    }

    public <T> void removeDuplicatesInPlace(LinkedList<T> list) {
        HashSet<T> uniqueElements = new HashSet<>();
        for (Iterator<T> iterator = list.iterator(); iterator.hasNext(); ) {
            T t = iterator.next();
            boolean added = uniqueElements.add(t);
            if (!added) {
                iterator.remove();
            }
        }
    }

    public <T> LinkedList<T> removeDuplicatesShort(LinkedList<T> list) {
        return new LinkedList<>(new HashSet<>(list));
    }


}
