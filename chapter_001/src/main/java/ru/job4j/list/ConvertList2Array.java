package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() % rows == 0) ?  list.size() / rows :  list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int listIndex = 0;
        boolean finished = false;
        for (int i = 0; i < array.length && finished != true; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (listIndex >= list.size()) {
                    finished = true;
                    break;
                }
                array[i][j] = list.get(listIndex++);
            }
        }
        return array;
    }
}
