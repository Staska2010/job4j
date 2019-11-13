package ru.job4j.department;

import java.util.*;
import java.util.regex.Pattern;

/**
 * DepartmentStore
 * processing of departments store
 *
 * @author Stanislav Klokov (klokovstas2013@gmail.com)
 */
public class DepartmentStore {
    /**
     * Method for checking input String array.
     * if there is not top level department, then add it.
     *
     * @param depts array of departments for check.
     * @return String[] fixedStore - checked and fixed array of departments
     */
    public static String[] parseDept(String[] depts) {
        Set<String> fixedStore = new HashSet<>(Arrays.asList(depts));
        for (String iterator : depts) {
            Pattern pattern = Pattern.compile("\\\\");
            List<String> splittedString = new ArrayList<>(Arrays.asList(pattern.split(iterator)));
            StringBuilder chain = new StringBuilder();
            for(String i : splittedString) {
                chain.append(i);
                if (!fixedStore.contains(chain.toString())) {
                    fixedStore.add(chain.toString());
                }
                chain.append("\\");
            }
        }
        return fixedStore.toArray(new String[fixedStore.size()]);
    }

    /**
     * Method for sorting department array in ascending mode
     *
     * @param depts array of departments for sorting.
     * @return sorted array.
     */
    public static String[] ascendingSort(String[] depts) {
        String[] checkedDepts = parseDept(depts);
        Arrays.sort(checkedDepts);
        return checkedDepts;
    }

    /**
     * descendingSort - Method for sorting array in descending mode
     *
     * @param depts array of departments for sorting.
     * @return sorted array.
     */
    public static String[] descendingSort(String[] depts) {
        String[] checkedString = parseDept(depts);
        Arrays.sort(checkedString, (left, right) -> {
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
            return charsEquals ? left.length() - right.length() : right.charAt(position) - left.charAt(position);
        });
        return checkedString;
    }
}
