package ru.bounegru.model;

import java.awt.*;

public abstract class Sprite {
    private Image image;
    private boolean dead;

    protected int x;
    protected int y;
    protected int dx;
    protected int dy;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



    public Sprite() {
        this.dead = false;
    }

    public void die() {
        dead = true;
    }
}
