package ru.job4j.list;

/**
 * Floyd's cycle search algorithm
 * @param <E>
 */
public class DetermineCycle<E> {
    public boolean hasCycle(Node<E> first) {
        boolean result = false;
        Node<E> slow = first;
        Node<E> fast = first;
        Node<E> start = null;
        int length = 0;

        while (true) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
            if (slow == fast) {
                result = true;
                start = startOfCycle(slow, fast, first);
                length = lengthOfCycle(slow, fast);
                break;
            }
            if (slow == null || fast == null) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * search of start of cycle
     * @param fast
     * @param slow
     * @return  node - start of cycle
     */

    private Node<E> startOfCycle(Node<E> fast, Node<E> slow, Node<E> first) {
        slow = first;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * calculate length of cycle
     * @param fast
     * @param slow
     * @return length of cycle
     */
    private int lengthOfCycle(Node<E> fast, Node<E> slow) {
        int num = 0;
        while (fast != slow) {
            fast = fast.next;
            num++;
        }
        return num;
    }
}
