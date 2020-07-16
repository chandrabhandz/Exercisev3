package com.example.filewriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static com.example.filewriter.MainApplication.getRandomText;
import static com.example.filewriter.MainApplication.main;
import static com.example.filewriter.MainApplication.validateInput;
import static com.example.filewriter.MainApplication.writeToFile;

@RunWith(JUnit4.class)
public class MainApplicationTest {

    @Test
    public void check_valid_input() {
        boolean validateInput = validateInput(230);
        assert validateInput;
    }

    @Test(expected = IllegalArgumentException.class)
    public void check_negative_invalid_input() {
        boolean result = validateInput(-1);
        assert !result;
    }

    @Test(expected = IllegalArgumentException.class)
    public void check_larger_invalid_input() {
        boolean result = validateInput(600);
        assert !result;
    }

    @Test
    public void check_random_string() {
        String randomText = getRandomText();
        assert randomText.length() == 100;
    }

    @Test
    public void check_writeToFile() {
        File file = new File("test.txt");
        boolean toFile = writeToFile(100, file);
        file.deleteOnExit();
        assert toFile;
    }

    @Test
    public void check_writeToFile_fail() {
        boolean toFile = writeToFile(100, null);
        assert !toFile;
    }

    @Test(expected = RuntimeException.class)
    public void check_invalid_input_format () {
        String[] args = {"test"};
        main(args);
    }
}