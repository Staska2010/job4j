package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desc1", "6"});
        new StartUI(input, tracker).init();
        String actual = tracker.findAll()[0].getName();
        Assert.assertThat(actual, is("test1"));
    }

    @Test
    public void whenUserReplaceItemThenTrackerHasReplacedItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"2", item2.getId(), "test2_replaced", "desc2_replaced", "6"});
        new StartUI(input, tracker).init();
        String actual = tracker.findById(item2.getId()).getName();
        Assert.assertThat(actual, is("test2_replaced"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasNoSuchItemAnymore() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        Item actual = tracker.findById(item2.getId());
        Assert.assertThat(actual, is(nullValue()));
    }

    @Test
    public void whenUserTryToDeleteNonExistingItemThenTrackerHasSameLength() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        Item item3 = new Item("test3", "desc3");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"3", item3.getId(), "6"});
        new StartUI(input, tracker).init();
        int actual = tracker.findAll().length;
        Assert.assertThat(actual, is(2));
    }

    @Test
    public void whenUserIsLookingForExistingItemThenPrintResultOfSearch() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenUserIsLookingForItemsByNameThenPrintResultOfSearch() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        Item item3 = new Item("test2", "desc3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"5", "test2", "6"});
        new StartUI(input, tracker).init();
    }
}
