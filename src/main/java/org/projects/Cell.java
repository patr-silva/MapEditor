package org.projects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    public static final int PADDING = 20;
    private Rectangle rectangle;
    private boolean painted;



    public Cell(int x, int y) {
        rectangle = new Rectangle(x * PADDING, y * PADDING, PADDING, PADDING);
        rectangle.setColor(Color.ORANGE);
        rectangle.draw();

    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted() {
        this.painted = !this.painted;
        if(painted){
            this.rectangle.setColor(Color.ORANGE);
            this.rectangle.fill();
        } else {
            rectangle.setColor(Color.ORANGE);
            rectangle.draw();
        }
    }


}
