package com.example.filewriter;

import java.io.File;
import java.io.PrintStream;
import java.util.Random;

public class MainApplication {

    private static final String FILE_NAME = "output.txt";

    public static void main(String[] args) {
        try {
            int x = Integer.parseInt(args[0]);
            if(validateInput((x))) {
                File file = new File(FILE_NAME);
                System.out.println("file = " + file.getAbsolutePath() + " exists :" + writeToFile(x, file));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static boolean validateInput(int x) {
        if(x<0 || x>230) {
            throw new IllegalArgumentException("x is not belong to range [1, 230]");
        }
        return true;
    }

    public static boolean writeToFile(int numberOfLine, File file) {
        try {
            if(file.createNewFile()) {
                PrintStream fileStream = new PrintStream(file);
                while (numberOfLine>0) {
                    fileStream.println(getRandomText());
                    numberOfLine--;
                }
                fileStream.close();
                System.out.println(numberOfLine + " written into the file :" + file.getName());
            }
            return file.exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static String getRandomText() {
        StringBuilder b = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i<100;i++) {
            char c = (char)(65+r.nextInt(25));
            b.append(c);
        }
        return b.toString();
    }
}
