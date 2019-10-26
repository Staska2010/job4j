package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getName(), is(item1.getName()));
    }

    @Test
    public void whenDeleteExistingItemThenNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        item1.setId("100");
        item2.setId("200");
        tracker.delete("100");
        Item result = tracker.findById(item1.getId());
        Assert.assertNull(result);
    }

    @Test
    public void whenDeleteItemThatNotExistThenFalse() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        item1.setId("100");
        item2.setId("200");
        boolean result = tracker.delete("300");
        assertThat(result, is(false));
    }

    @Test
    public void whenReplaceExistingItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        item1.setId("100");
        item2.setId("100");
        tracker.replace("100", item2);
        Item result = tracker.findById(item2.getId());
        assertThat(result.getName(), is(item2.getName()));
    }

    @Test
    public void whenReplaceItemThatNotExistThanFalse() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        item1.setId("100");
        item2.setId("200");
        boolean result = tracker.replace("200", item2);
        assertThat(result, is(false));
    }

    @Test
    public void whenTrackerHas2ItemFindByNameIs2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test1", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        ArrayList<Item> result = tracker.findByName("test1");
        assertThat(result.size(), is(2));
    }

    @Test
    public void whenFindAllThanTheSameTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        Item item3 = new Item("test3", "desc3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        ArrayList<Item> result = tracker.findAll();
        ArrayList<Item> expected = new ArrayList<>(Arrays.asList(item1, item2, item3));
        assertThat(result, is(expected));
    }
}