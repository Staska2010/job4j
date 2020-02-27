package io;

<<<<<<< Updated upstream
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SearchTest {
    File tmpDirectory;
    File subDirectoryFirstLevel;
    File fileExtTxt1;
    File fileExtTxt2;
    File subDirectorySecondLevel;
    File fileExtLog1;
    File fileExtLog2;
    File fileExtLog3;

    @Before
    public void init() {
        tmpDirectory = new File(System.getProperty("java.io.tmpdir"));
        subDirectoryFirstLevel = new File(tmpDirectory, "subdirectory");
        fileExtTxt1 = new File(subDirectoryFirstLevel, "file1.txt");
        fileExtTxt2 = new File(subDirectoryFirstLevel, "file2.txt");
        subDirectorySecondLevel = new File(subDirectoryFirstLevel, "subDirectorySecondLevel");
        fileExtLog1 = new File(subDirectoryFirstLevel, "file3.log");
        fileExtLog2 = new File(subDirectorySecondLevel, "file4.log");
        fileExtLog3 = new File(subDirectorySecondLevel, "file5.log");
        try {
            subDirectoryFirstLevel.mkdir();
            subDirectorySecondLevel.mkdir();
            fileExtLog1.createNewFile();
            fileExtTxt1.createNewFile();
            fileExtTxt2.createNewFile();
            fileExtLog2.createNewFile();
            fileExtLog3.createNewFile();
            subDirectoryFirstLevel.deleteOnExit();
            subDirectorySecondLevel.deleteOnExit();
            fileExtLog1.deleteOnExit();
            fileExtTxt1.deleteOnExit();
            fileExtTxt2.deleteOnExit();
            fileExtLog2.deleteOnExit();
            fileExtLog3.deleteOnExit();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }


    @Test
    public void testFileExistence() {
        assertTrue(fileExtLog1.exists());
        assertTrue(fileExtLog1.isFile());
        assertTrue(subDirectoryFirstLevel.exists());
        assertTrue(subDirectoryFirstLevel.isAbsolute());
    }

    @Test
    public void whenSearchTXTExtensionThenGetTwoFiles() {
        Search sc = new Search();
        List<File> result = sc.files(subDirectoryFirstLevel.getAbsolutePath(), Arrays.asList("txt"));
        assertThat(result.size(), is(2));
        assertThat(result.get(0).getName().endsWith(".txt"), is(true));
        assertThat(result.get(1).getName().endsWith(".txt"), is(true));
    }

    @Test
    public void whenSearchLOGExtensionThenGetThreeFiles() {
        Search sc = new Search();
        List<File> result = sc.files(subDirectoryFirstLevel.getAbsolutePath(), Arrays.asList("log"));
        assertThat(result.size(), is(3));
        assertThat(result.get(0).getName().endsWith(".log"), is(true));
        assertThat(result.get(1).getName().endsWith(".log"), is(true));
        assertThat(result.get(2).getName().endsWith(".log"), is(true));
    }

    @Test
    public void whenSearchLOGandTXTExtensionTheGetFiveFiles() {
        Search sc = new Search();
        List<File> result = sc.files(subDirectoryFirstLevel.getAbsolutePath(), Arrays.asList("log", "txt"));
        assertThat(result.size(), is(5));
    }

    @Test
    public void whenSearchForNotExistingExtensionThenGetNothing() {
        Search sc = new Search();
        List<File> result = sc.files(subDirectoryFirstLevel.getAbsolutePath(), Arrays.asList("jpg"));
        assertThat(result, is(Collections.emptyList()));
    }
=======
public class SearchTest {
>>>>>>> Stashed changes
}
