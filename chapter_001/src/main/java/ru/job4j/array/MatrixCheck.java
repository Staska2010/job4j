package ru.job4j.array;

import java.util.Arrays;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
          if ((data[0][0] != data[i][i]) || (data[data.length - 1 - i][i] != data[i][j])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
