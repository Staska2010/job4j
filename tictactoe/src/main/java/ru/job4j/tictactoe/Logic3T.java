package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return isWinner(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWinner(Figure3T::hasMarkO);
    }

    public boolean isWinner(Predicate<Figure3T> predicate) {
        boolean isGorisontalFilled = false;
        boolean isVerticalFilled = false;
        for (int index = 0; index < table.length; index++) {
            isGorisontalFilled = isGorisontalFilled || fillBy(predicate, index, 0, 0, 1);
            isVerticalFilled = isVerticalFilled || fillBy(predicate, 0, index, 1, 0);
        }
        return isVerticalFilled || isGorisontalFilled ||  fillBy(predicate, 0, 0, 1, 1)
                || fillBy(predicate, table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        return !Arrays.stream(table)
                .flatMap(Arrays::stream)
                .allMatch(x -> x.hasMarkX() || x.hasMarkO());
    }
}
