package org.projects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MapEditor implements KeyboardHandler {
    private Grid grid;
    private Keyboard keyboard;
    private Rectangle cursor;
    private int cursorX = 0;
    private int cursorY = 0;


    public MapEditor(int height, int width) {
        this.grid = new Grid(height, width);
        this.cursor = new Rectangle(cursorX, cursorY, Cell.PADDING, Cell.PADDING);
        this.createCursor();
        this.keyboard = new Keyboard(this);
        addKeyboard();
    }

    public void createCursor() {
        this.cursor.setColor(Color.PINK);
        this.cursor.draw();
        this.cursor.fill();
    }

    public void setGrid() {
        this.grid.createGrid();
    }

    public void addKeyboard() {
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);

        KeyboardEvent paintCell = new KeyboardEvent();
        paintCell.setKey(KeyboardEvent.KEY_SPACE);
        paintCell.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paintCell);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);
    }


    private void moveRight() {
        if (this.cursor.getX() < (this.grid.getHeight() - 1) * Cell.PADDING) {
            this.cursor.translate(Cell.PADDING, 0);
            cursorX += Cell.PADDING;
        }
    }

    private void moveLeft() {
        if (this.cursor.getX() > Cell.PADDING) {
            this.cursor.translate(-Cell.PADDING, 0);
            cursorX -= Cell.PADDING;
        }
    }

    private void moveUp() {
        if (this.cursor.getY() >= Cell.PADDING) {
            this.cursor.translate(0, -Cell.PADDING);
            cursorY -= Cell.PADDING;
        }
    }

    private void moveDown() {
        if (this.cursor.getY() < (this.grid.getWidth() - 1) * Cell.PADDING) {
            this.cursor.translate(0, Cell.PADDING);
            cursorY += Cell.PADDING;
        }
    }

    private void paintCell() {
        int gridX = cursorX / Cell.PADDING;
        int gridY = cursorY / Cell.PADDING;
        Cell cell = grid.getCell(gridX, gridY);
        cell.setPainted(!cell.isPainted());
    }

    private void save() {
        System.out.println("save");
        FileManager.save(grid);
    }

    private void load() {
        System.out.println("load");
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int keyPressed = keyboardEvent.getKey();

        switch (keyPressed) {
            case (KeyboardEvent.KEY_RIGHT):
                moveRight();
                break;
            case (KeyboardEvent.KEY_LEFT):
                moveLeft();
                break;
            case (KeyboardEvent.KEY_UP):
                moveUp();
                break;
            case (KeyboardEvent.KEY_DOWN):
                moveDown();
                break;
            case (KeyboardEvent.KEY_SPACE):
                paintCell();
                break;
            case (KeyboardEvent.KEY_S):
                save();
                break;
            case (KeyboardEvent.KEY_L):
                load();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
