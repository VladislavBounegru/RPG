package ru.bounegru.model;

import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Character extends Sprite {
    public Character() {
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.CHARACTER);
        setImage(imageIcon.getImage());

        int startX = Constants.BORDERS + Constants.CHARACTER_WIDTH;
        System.out.println(Constants.HEIGHT / 2 - Constants.CHARACTER_HEIGHT / 2);
        int startY = Constants.HEIGHT / 2 - Constants.CHARACTER_HEIGHT / 2;
        setX(startX);
        setY(startY);
    }

    @Override
    public void move() {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
    }

    public void keyReleased(KeyEvent e) {

    }


}
