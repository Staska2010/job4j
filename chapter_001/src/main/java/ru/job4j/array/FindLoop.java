package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; index < finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        for(int i = 0; i < data.length; i++) {
            int min = data[i];
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                }
            }
            data[indexOf(data, min, i, data.length)] = data[i];
            data[i] = min;
        }
        return data;
    }
}
