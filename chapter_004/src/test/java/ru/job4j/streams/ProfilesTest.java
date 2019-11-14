package ru.job4j.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    @Test
    public void whenCollectAddressesThenGetListOfAddresses() {
        Profiles testProfiles = new Profiles();
        List<Address> actual = testProfiles.collect(List.of(
                new Profile(new Address("Omsk", "Goncharnaya", 10, 10)),
                new Profile(new Address("Barnaul", "Trubnaya", 20, 20)),
                new Profile(new Address("Moscow", "Vernadskogo", 30, 30))
        ));
        List<Address> expected = List.of(
                new Address("Barnaul", "Trubnaya", 20, 20),
                new Address("Moscow", "Vernadskogo", 30, 30),
                new Address("Omsk", "Goncharnaya", 10, 10)
        );
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void whenCollectAddressesThenGetOriginalSortedListOfAddresses() {
        Profiles testProfiles = new Profiles();
        List<Address> actual = testProfiles.collect(List.of(
                new Profile(new Address("Omsk", "Goncharnaya", 10, 10)),
                new Profile(new Address("Barnaul", "Trubnaya", 20, 20)),
                new Profile(new Address("Moscow", "Vernadskogo", 30, 30)),
                new Profile(new Address("Barnaul", "Trubnaya", 20, 20)),
                new Profile(new Address("Moscow", "Vernadskogo", 30, 30)),
                new Profile(new Address("Tver", "Bunina", 10, 10)),
                new Profile(new Address("Archangelsk", "Pirogova", 20, 20))
        ));
        List<Address> expected = List.of(
                new Address("Archangelsk", "Pirogova", 20, 20),
                new Address("Barnaul", "Trubnaya", 20, 20),
                new Address("Moscow", "Vernadskogo", 30, 30),
                new Address("Omsk", "Goncharnaya", 10, 10),
                new Address("Tver", "Bunina", 10, 10)
        );
        Assert.assertThat(actual, is(expected));
    }
}
