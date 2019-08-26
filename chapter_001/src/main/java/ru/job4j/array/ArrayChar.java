package ru.job4j.array;

public class ArrayChar {
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value
        for (int i = 0; i < prefix.length(); i++) {
            result &= (wrd[i] == pref[i]);
        }
        return result;
    }
}
