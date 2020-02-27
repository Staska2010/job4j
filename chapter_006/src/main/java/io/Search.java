package io;

import java.io.File;
import java.util.*;

public class Search {
    List<File> files(String parent, List<String> exts) {
        Queue<File> content = new LinkedList<>();
        List<File> result = new ArrayList<>();
        File file = new File(parent);
        if (file.exists()) {
            content.offer(file);
            while (!content.isEmpty()) {
                File tmp = content.poll();
                if (!tmp.isDirectory()) {
                    for (String extension : exts) {
                        if (tmp.getName().endsWith(extension)) {
                            result.add(tmp);
                        }
                    }
                } else {
                    content.addAll(Arrays.asList(tmp.listFiles()));
                }
            }
        }
        return result;
    }
}
