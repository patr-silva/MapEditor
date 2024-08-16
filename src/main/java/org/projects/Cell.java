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

    public void setPainted(boolean painted) {
        this.painted = painted;
        if(painted){
            this.rectangle.setColor(Color.ORANGE);
            this.rectangle.fill();
        } else {
            rectangle.setColor(Color.ORANGE);
            rectangle.draw();
        }
    }


    public String saveCellState(){
        return painted ? "1" : "0";
    }

    public void checkCellState(String state){
        this.setPainted("1".equals(state));
    }

}
