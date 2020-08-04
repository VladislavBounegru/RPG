package ru.bounegru.controllers;

import ru.bounegru.constants.Constants;
import ru.bounegru.logic.FieldOfGrid;
import ru.bounegru.model.Character;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MovingController {
    private FieldOfGrid field = FieldOfGrid.getInstance();
    private static final int SPEED = 3;
    enum Vertical {
        NONE,
        UP,
        DOWN,
        UPDOWN
    }

    enum Horizontal {
        NONE,
        LEFT,
        RIGHT,
        LEFTRIGHT
    }

    private int dx;
    private int dy;
    private Vertical vertical;
    private Horizontal horizontal;
    private Character character;

    public String getVertical() {
        return vertical.toString();
    }

    public String getHorizontal() {
        return horizontal.toString();
    }

    public MovingController(Character character) {
        this.character = character;
        vertical = Vertical.NONE;
        horizontal = Horizontal.NONE;
    }

    public void pressedKey(int key) {
        switch (key) {
            case KeyEvent.VK_LEFT:
                horizontal = (horizontal == Horizontal.RIGHT) || (horizontal == Horizontal.LEFTRIGHT)
                        ? Horizontal.LEFTRIGHT : Horizontal.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                horizontal = (horizontal == Horizontal.LEFT) || (horizontal == Horizontal.LEFTRIGHT)
                        ? Horizontal.LEFTRIGHT : Horizontal.RIGHT;
                break;
            case KeyEvent.VK_UP:
                vertical = (vertical == Vertical.DOWN) || (vertical == Vertical.UPDOWN)
                        ? Vertical.UPDOWN : Vertical.UP;
                break;
            case KeyEvent.VK_DOWN:
                vertical = (vertical == Vertical.UP) || (vertical == Vertical.UPDOWN)
                        ? Vertical.UPDOWN : Vertical.DOWN;
                break;
            default:
                break;
        }
    }

    public void releasedKey(int key) {
        switch (key) {
            case KeyEvent.VK_LEFT:
                horizontal = horizontal == Horizontal.LEFTRIGHT ? Horizontal.RIGHT : Horizontal.NONE;
                break;

            case KeyEvent.VK_RIGHT:
                horizontal = horizontal == Horizontal.LEFTRIGHT ? Horizontal.LEFT : Horizontal.NONE;
                break;
            case KeyEvent.VK_UP:
                vertical = vertical == Vertical.UPDOWN ? Vertical.DOWN : Vertical.NONE;
                break;
            case KeyEvent.VK_DOWN:
                vertical = vertical == Vertical.UPDOWN ? Vertical.UP : Vertical.NONE;
                break;
            default:
                break;
        }
    }

    public void calculateSpeed() {

        if (horizontal == Horizontal.LEFT) {
            dx = -SPEED;
        } else if (horizontal == Horizontal.RIGHT) {
            dx = SPEED;
        } else {
            dx = 0;
        }
        if (vertical == Vertical.UP) {
            dy = -SPEED;
        } else if (vertical == Vertical.DOWN) {
            dy = SPEED;
        } else {
            dy = 0;
        }
    }

    public void moving() {
        calculateSpeed();
        int newX = character.getX() + dx;
        int newY = character.getY() + dy;
        newX = Math.max(newX, Constants.BORDERS);
        newX = Math.min(Constants.WIDTH - Constants.CHARACTER_WIDTH - Constants.BORDERS, newX);
        newY = Math.max(newY, Constants.BORDERS);
        newY = Math.min(Constants.HEIGHT - Constants.CHARACTER_HEIGHT - Constants.BORDERS, newY);
        if (checkCollision(newY, character.getX())) {
            character.setY(newY);
        }
        if (checkCollision(character.getY(), newX)) {
            character.setX(newX);
        }
    }

    public boolean checkCollision(int y, int x) {
        List<Integer> list = field.getOccupiedCellsCoordinates();
        for (int i = 0; i < list.size() / 2; i++) {
            System.out.println(y - Constants.BORDERS);
            System.out.println(x - Constants.BORDERS);

            if (y - Constants.BORDERS < list.get(2 * i) * Constants.SIDE_SIZE + Constants.SIDE_SIZE &&
                    y - Constants.BORDERS + Constants.CHARACTER_HEIGHT > list.get(2 * i) * Constants.SIDE_SIZE &&
                    x - Constants.BORDERS < list.get(2 * i + 1) * Constants.SIDE_SIZE + Constants.SIDE_SIZE &&
                    x - Constants.BORDERS + Constants.CHARACTER_WIDTH > list.get(2 * i + 1) * Constants.SIDE_SIZE) {
                return false;
            }
        }
        return true;
    }
}
