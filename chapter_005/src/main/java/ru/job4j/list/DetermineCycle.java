package ru.job4j.list;

public class DetermineCycle<E> {
    SimpleArrayList<Node<E>> used = new SimpleArrayList<>();

    public boolean hasCycle(Node<E> first) {
        while (first != null) {
            if (!contains(first)) {
                used.add(first);
            } else {
                return true;
            }
            first = first.next;
        }
        return false;
    }

    private boolean contains(Node<E> node) {
        boolean result = false;
        for (int i = 0; i < used.getSize(); i++) {
            if (used.get(i).value == node.value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
