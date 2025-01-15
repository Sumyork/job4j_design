package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int count = 0;
        for (int index = 0; index < nodes.size(); index++) {
            if (source.hasNext()) {
                nodes.get(index).add(source.next());
                count++;
            }
            if (count == nodes.size() && source.hasNext()) {
                index = -1;
                count = 0;
            }
        }
    }
}
