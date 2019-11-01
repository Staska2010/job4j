package ru.job4j.strings;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int endPoint = (left.length() - right.length()) >= 0 ? right.length() : left.length();
        boolean charsEquals;
        int position = 0;
        do {
            if (left.charAt(position) == right.charAt(position)) {
                charsEquals = true;
                position++;
            } else {
                charsEquals = false;
            }
        } while (charsEquals && (position < endPoint));
        return charsEquals ? left.length() - right.length() : left.charAt(position) - right.charAt(position);
    }
}
