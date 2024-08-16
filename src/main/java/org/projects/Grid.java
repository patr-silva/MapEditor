package org.projects;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private int height;
    private int width;
    private Cell[][] cells;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[width][height];
    }

    public void createGrid() {
        Rectangle rectangle;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

}