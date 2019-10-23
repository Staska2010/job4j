package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        while (tasks.size() < task.getPriority()) {
            tasks.addLast(null);
        }
        tasks.add(task.getPriority() - 1, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
