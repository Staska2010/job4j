package ru.job4j.set;
import ru.job4j.list.DynamicContainer;

import java.util.Iterator;

public class SimpleSet<E>  implements Iterable<E> {
    private final DynamicContainer<E> sl = new DynamicContainer<>();

    public void add(E value) {
        if (ensureUnique(value)) {
            sl.add(value);
        }

    }

    private boolean ensureUnique(E value) {
        boolean result = true;
        Iterator<E> it = sl.iterator();
        while (it.hasNext()) {
            if (it.next() == value) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> lsIt = sl.iterator();
            @Override
            public boolean hasNext() {
                return lsIt.hasNext();
            }

            @Override
            public E next() {
                return lsIt.next();
            }
        };
    }
}
