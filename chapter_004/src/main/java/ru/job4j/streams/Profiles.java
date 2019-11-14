package ru.job4j.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Profiles
 * processing data of profiles
 *
 * @author Stanislav Klokov (klokovstas2013@gmail.com)
 */
public class Profiles {
    /**
     * @param profiles - list of client's profiles
     * @return addresses, extracted from profiles
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(s -> s.getAddress())
                .distinct()
                .sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList()
                );
    }
}
