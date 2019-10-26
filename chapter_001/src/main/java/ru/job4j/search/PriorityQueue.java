package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int position = tasks.size();
        for (int count = 0; count < tasks.size(); count++) {
            if (task.getPriority() < tasks.get(count).getPriority()) {
                position = count;
                break;
            }
        }
        tasks.add(position, task);
    }

    public Task take() {
        return this.tasks.poll();
    }

    public Task takeLowerPriorityTask() {
        return this.tasks.getLast();
    }
}
