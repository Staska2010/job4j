package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    Node<E> root;
    int modCount = 0;

    public Tree(E rootValue) {
        root = new Node<>(rootValue);
    }

    @Override
    public boolean add(E parent, E child) {
        if (!findBy(child).isPresent()) {
            findBy(parent).ifPresent(foundNode -> foundNode.add(new Node<>(child)));
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Queue<Node<E>> nodes = new LinkedList<>();

            {
                nodes.offer(root);
            }

            @Override
            public boolean hasNext() {
                checkModCount();
                return !nodes.isEmpty();
            }

            @Override
            public E next() {
                Node<E> nextNode = nodes.poll();
                if (nextNode != null) {
                    for (Node<E> leave : nextNode.leaves()) {
                        nodes.offer(leave);
                    }
                }
                return nextNode.getValue();
            }

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
