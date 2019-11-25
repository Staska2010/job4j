package ru.job4j.generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int endPointer = 0;
    private int itCursor = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    public void add(T model) {
        if (endPointer >= array.length - 1) {
          throw new ArrayIndexOutOfBoundsException();
        } else {
            array[endPointer++] = model;
        }
    }

    public void set(int index, T model) {
        array[index] = model;
    }

    public void remove(int index) {
        for (int i = index; i <= endPointer; i++) {
            array[i] = array[i + 1];
        }
        array[endPointer--] = null;
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return itCursor < endPointer;
            }

            @Override
            public T next() {
                return (T) array[itCursor++];
            }
        };
    }
}
