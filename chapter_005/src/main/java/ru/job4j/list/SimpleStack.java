package ru.job4j.list;
/**
 * Simple Stack Class, based on Linked List
 */

import java.util.Iterator;

public class SimpleStack<E> {
    private SimpleLinkedList<E> stack = new SimpleLinkedList<>();

    /**
     * Push value to stack
     *
     * @param value
     */
    public void push(E value) {
        stack.add(value);
    }

    /**
     * extract value from stack
     * @return E type, stored in stack
     */

    public E pop() {
        E result = null;
        Iterator<E> it = stack.iterator();
        for (int i = 0; i < stack.listLength; i++) {
            result = it.next();
        }
        it.remove();
        return result;
    }
}
