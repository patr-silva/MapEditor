package org.projects;

import java.io.*;

public class FileManager {

    public static String file = "file.txt";

    public static void save(Grid grid) {
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);

            for (int i = 0; i < grid.getWidth(); i++) {
                for (int j = 0; j < grid.getWidth(); j++) {
                    writer.write(grid.getCell(i, j).saveCellState());
                    if (j < grid.getHeight() - 1) {
                        writer.write(",");
                    }
                }
                bWriter.newLine();
            }

            bWriter.flush();
            bWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
