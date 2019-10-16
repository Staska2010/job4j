package ru.job4j.tracker;

import org.junit.Assert;
import ru.job4j.tracker.singletons.*;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class TrackerSingletonTest {
    @Test
    public void whenCreateAnotherEnumSingletonThenTheSameInstance() {
        TrackerSingletonEnum tracker1 = TrackerSingletonEnum.INSTANCE;
        TrackerSingletonEnum tracker2 = TrackerSingletonEnum.INSTANCE;
        Assert.assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenCreateAnotherLazySingletonThenTheSameInstance() {
        TrackerSingletonLazy tracker1 = TrackerSingletonLazy.getInstance();
        TrackerSingletonLazy tracker2 = TrackerSingletonLazy.getInstance();
        Assert.assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenCreateAnotherEagerSingletonThenTheSameInstance() {
        TrackerSingletonEager tracker1 = TrackerSingletonEager.getInstance();
        TrackerSingletonEager tracker2 = TrackerSingletonEager.getInstance();
        Assert.assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenCreateAnotherSingletonWithInnerClassThenTheSameInstance() {
        TrackerSingletonInner tracker1 = TrackerSingletonInner.getInstance();
        TrackerSingletonInner tracker2 = TrackerSingletonInner.getInstance();
        Assert.assertThat(tracker1, is(tracker2));
    }
}
