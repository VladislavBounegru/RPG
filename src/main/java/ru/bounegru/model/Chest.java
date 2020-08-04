package ru.bounegru.model;

import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;
import ru.bounegru.logic.FieldOfGrid;

import javax.swing.*;
import java.util.Random;

public class Chest extends Sprite {
    private FieldOfGrid fieldOfGrid;


    public Chest() {
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.CHEST);
        setImage(imageIcon.getImage());
        fieldOfGrid = FieldOfGrid.getInstance();
        Random random = new Random();
        int randomX = 0;
        int randomY = 0;
        do {
            randomX = random.nextInt(Constants.COLUMN - 1);
            randomY = random.nextInt(Constants.ROW - 1);
        } while (!fieldOfGrid.isEmpty(randomY, randomX));
        FieldOfGrid.getInstance().markingCell(randomY, randomX, 1);
        setX(randomX * Constants.SIDE_SIZE + Constants.BORDERS);
        setY(randomY * Constants.SIDE_SIZE + Constants.BORDERS);
    }
}
