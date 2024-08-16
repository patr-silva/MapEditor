package org.projects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private int height;
    private int width;
    private Cell[][] cells;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[width][height];
        this.createCells();
    }

    public void createGrid() {
        Rectangle rectangle;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                rectangle = new Rectangle(i * Cell.PADDING, j * Cell.PADDING, 20, 20);
                rectangle.setColor(Color.ORANGE);
                rectangle.draw();
            /*    if (this.getCell(i, j).isPainted()) {
                    rectangle.setColor(Color.PINK);
                    rectangle.fill();
            }
             */
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

public void createCells() {
    for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            cells[i][j] = new Cell();

        }
    }
}


}
