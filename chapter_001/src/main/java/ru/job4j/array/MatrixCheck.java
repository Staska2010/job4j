package ru.job4j.array;

import java.util.Arrays;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
            if (data.length % 2 != 0) {
                if ((data[0][0] != data[i][i]) && (data[0][0] != data[i][j])) {
                    result = false;
                    break;
                }
            } else if ((data[0][0] != data[i][i]) && (data[data.length - 1][i] != data[i][j])) {
                result = false;
                break;
            }

        }
        return result;
    }
}
