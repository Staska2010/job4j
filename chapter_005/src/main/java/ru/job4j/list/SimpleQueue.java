package ru.job4j.list;

public class SimpleQueue<E> {
    private SimpleStack<E> queue = new SimpleStack<>();
    private SimpleStack<E> swapped = new SimpleStack<>();

    public void push(E value) {
        queue.push(value);
    }

    public E poll() {
        E result;
        swap(queue, swapped);
        result = swapped.pop();
        swap(swapped, queue);
        return result;
    }

    private void swap(SimpleStack<E> out, SimpleStack<E> in) {
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
    }
}
