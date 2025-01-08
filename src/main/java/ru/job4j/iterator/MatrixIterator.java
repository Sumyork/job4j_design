package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data[row].length == column && row < data.length - 1) {
            row++;
            column = 0;
        }
        return column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] input = {
                {1}, {2, 3}, {}, {}, {4}
        };
        int row = 0;
        int column = 0;
        MatrixIterator iterator = new MatrixIterator(input);
        System.out.println(input[row++].length);
        System.out.println(input[row++].length);
        System.out.println(input[row++].length);
        System.out.println(input[row++].length);
        System.out.println(input[row++].length);
//        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
