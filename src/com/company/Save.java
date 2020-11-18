package com.company;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {
    public static void saveTheUpdatedFile(String filename, ArrayList<String> lines) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (int i = 0; i < lines.size(); i++) {
            writer.write(lines.get(i));
            writer.newLine();
        }

        writer.close();
    }

    public static void saveTheUpdatedFile2DArray(String filename, String[][] array2D) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                writer.write(array2D[i][j] + " ");
            }
            writer.newLine();
        }

        writer.close();
    }
}

