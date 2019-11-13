package ru.job4j.department;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class DepartmentStoreTest {
    @Test
    public void whenSortingInAscendingModeThenSorted(){
        String[] input = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };
        String[] result = DepartmentStore.ascendingSort(input);
        String[] expected = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenSortingInDescendingModeThenSorted(){
        String[] input = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };
        String[] result = DepartmentStore.descendingSort(input);
        String[] expected = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        Assert.assertThat(result, is(expected));
    }
}
