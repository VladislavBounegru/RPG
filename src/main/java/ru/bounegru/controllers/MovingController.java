package ru.bounegru.controllers;

import ru.bounegru.model.Character;

import java.awt.event.KeyEvent;

public class MovingController {
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
                        ? Vertical.UPDOWN :Vertical.DOWN;
                break;
            default:
                break;
        }
    }

    public void releasedKey(int key) {
        switch (key) {
            case KeyEvent.VK_LEFT:
                System.out.println(horizontal);
                horizontal = horizontal == Horizontal.LEFTRIGHT ? Horizontal.RIGHT : Horizontal.NONE;
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println(horizontal);
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
            dx = -2;
        } else if (horizontal == Horizontal.RIGHT) {
            dx = 2;
        } else {
            dx = 0;
        }
        if (vertical == Vertical.UP) {
            dy = -2;
        } else if (vertical == Vertical.DOWN) {
            dy = 2;
        } else {
            dy = 0;
        }
    }

    public void moving() {
        calculateSpeed();
        character.setX(character.getX() + dx);
        character.setY(character.getY() + dy);
    }


}
