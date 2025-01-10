package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int result = -1;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                result = 0;
                break;
            }
        }
        return result == 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    public static void main(String[] args) {
        EvenNumbersIterator evenNumbersIterator = new  EvenNumbersIterator(new int[] {1, -3, 2, -4});
        System.out.println(evenNumbersIterator.next());
        System.out.println(evenNumbersIterator.next());
        System.out.println(evenNumbersIterator.hasNext());
    }
}
