package ru.job4j.list;

public class SimpleQueue<E> {
    private SimpleStack<E> queue = new SimpleStack<>();

    public void push(E value) {
        queue.push(value);
    }

    public E poll() {
        E result;
        queue = swap();
        result = queue.pop();
        queue = swap();
        return result;
    }

    private SimpleStack<E> swap() {
        SimpleStack<E> swapped = new SimpleStack<>();
        while (!queue.isEmpty()) {
                swapped.push(queue.pop());
        }
        return swapped;
    }
}
