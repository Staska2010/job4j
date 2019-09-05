package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private int positionOfSearch = 0;

    public Item add(Item item) {
        if (position < items.length) {
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

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                this.positionOfSearch = i;
            }
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        Item tmp = findById(id);
        if (tmp != null) {
            this.items[positionOfSearch] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        if (findById(id) != null) {
            if (position - 1 - positionOfSearch >= 0) {
                System.arraycopy(items, positionOfSearch + 1, items, positionOfSearch, position - 1 - positionOfSearch);
                position--;
                result = true;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
}
