package ru.bounegru.model;

import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;
import ru.bounegru.logic.FieldOfGrid;

import javax.swing.*;

public class Entrance extends Sprite {

    public Entrance() {
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.ENTRANCE);
        setImage(imageIcon.getImage());
        final int row = 0;
        final int column = 0;
        FieldOfGrid.getInstance().markingCell(row, column, 2);
        setX(column * Constants.SIDE_SIZE + Constants.BORDERS);
        setY(row * Constants.SIDE_SIZE + Constants.BORDERS);
    }
}
