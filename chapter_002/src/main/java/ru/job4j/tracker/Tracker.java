package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        if (position < items.length - 1) {
            item.setId(this.generateId());
            this.items[this.position++] = item;
            return item;
        } else {
            return null;
        }
    }

    private String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i].setName(item.getName());
                items[i].setDesc(item.getDesc());
                result = true;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                if (position - 1 - i >= 0) {
                    System.arraycopy(items, i + 1, items, i, position - 1 - i);
                    position--;
                    result = true;
                }
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
            }
        }
        return result;
    }

    public Item[] findByName(String name) {
        Item[] result = new Item[position];
        int numberOfMatches = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(name)) {
                result[numberOfMatches++] = items[i];
            }
        }
        return Arrays.copyOf(result, numberOfMatches);
    }
}
