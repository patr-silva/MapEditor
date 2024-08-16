package org.projects;

/*
Cell: This class will represent an individual cell in the grid, and will have a boolean property
to indicate whether the cell is painted or not.
 */

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private boolean painted;
    public static final int PADDING = 20;

    public Cell(){
        this.painted = false;
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted() {
        this.painted = !this.painted;
    }
}
