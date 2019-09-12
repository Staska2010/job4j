package ru.job4j.tracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void initializeOut() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void setStdOutput() {
        System.setOut(System.out);
    }

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

    @Test
    public void whenUserChooseShowAllItemsThenShowItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        Item item3 = new Item("test2", "desc3");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        int i1 = new StringBuilder(out.toString()).indexOf("------------------- Заявки ------------------------");
        int i2 = new StringBuilder(out.toString()).indexOf("---------------------------------------------------");
        String trackerOutput = new StringBuilder(out.toString()).substring(i1, i2 + 2);
        String expected = new StringBuilder().append("------------------- Заявки ------------------------")
                .append(System.lineSeparator())
                .append("ID: ")
                .append(item1.getId())
                .append("; name: ")
                .append(item1.getName())
                .append("; desc: ")
                .append(item1.getDesc())
                .append(System.lineSeparator())
                .append("ID: ")
                .append(item2.getId())
                .append("; name: ")
                .append(item2.getName())
                .append("; desc: ")
                .append(item2.getDesc())
                .append(System.lineSeparator())
                .append("--")
                .toString();
        Assert.assertThat(trackerOutput, is(expected));
    }

    @Test
    public void whenUserChooseFindItemByIdThenOutputItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        Item item3 = new Item("test2", "desc3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        int i1 = new StringBuilder(out.toString()).indexOf("-- Заявка");
        int i2 = new StringBuilder(out.toString()).indexOf("--", i1 + 10);
        String trackerOutput = new StringBuilder(out.toString()).substring(i1, i2 + 2);
        String expected = new StringBuilder().append("-- Заявка: ID")
                .append(item2.getId())
                .append(", name:  ")
                .append(item2.getName())
                .append("; desc: ")
                .append(item2.getDesc())
                .append("--").toString();
        Assert.assertThat(trackerOutput, is(expected));
    }

    @Test
    public void whenUserChooseFindItemsByNameThenShowItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "desc1");
        Item item2 = new Item("test1", "desc2");
        Item item3 = new Item("test2", "desc3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"5", "test1", "6"});
        new StartUI(input, tracker).init();
        int i1 = new StringBuilder(out.toString()).indexOf("------------------- Заявки ------------------------");
        int i2 = new StringBuilder(out.toString()).indexOf("---------------------------------------------------");
        String trackerOutput = new StringBuilder(out.toString()).substring(i1, i2 + 2);
        String expected = new StringBuilder().append("------------------- Заявки ------------------------")
                .append(System.lineSeparator())
                .append("ID: ")
                .append(item1.getId())
                .append("; name: ")
                .append(item1.getName())
                .append("; desc: ")
                .append(item1.getDesc())
                .append(System.lineSeparator())
                .append("ID: ")
                .append(item2.getId())
                .append("; name: ")
                .append(item2.getName())
                .append("; desc: ")
                .append(item2.getDesc())
                .append(System.lineSeparator())
                .append("--")
                .toString();
        Assert.assertThat(trackerOutput, is(expected));
    }
}
