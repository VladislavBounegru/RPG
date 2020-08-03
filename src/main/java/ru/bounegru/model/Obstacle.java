package ru.bounegru.model;

import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;

import javax.swing.*;

public class Obstacle extends Sprite {

    public Obstacle() {
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.BLOCK);
        setImage(imageIcon.getImage());
    }
}
