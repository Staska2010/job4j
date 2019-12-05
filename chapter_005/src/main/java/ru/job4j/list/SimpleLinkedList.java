package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List implementaion
 *
 */
public class SimpleLinkedList<E> implements Iterable {
    int listLength = 0;
    Node<E> head = null;
    Node<E> tail = null;
    private int modCount = 0;

    /**
     * Add node to list
     * @param data - data to store in node
     * @return true if everything is Ok
     */
    public boolean add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        listLength++;
        modCount++;
        return true;
    }

    /**
     * Data retrieving from node at index position
     * @param index  - index of node for data retrieving
     * @return data
     */
    public E get(int index) {
        Node<E> searchedNode = head;
        if (index < 0 || index >= listLength) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            searchedNode = searchedNode.next;
        }
        return searchedNode.data;
    }

    /**
     * Implementation of Iterator for linked list
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkForComodification();
                return current != null;
            }

            @Override
            public E next() {
                E result;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                result = current.data;
                current = current.next;
                return result;
            }

            /**
             * check if count of modifications changed since Iterator was created
             */
            private void checkForComodification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
