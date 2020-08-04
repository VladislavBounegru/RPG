package ru.bounegru.model;

import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;
import ru.bounegru.logic.FieldOfGrid;

import javax.swing.*;

public class Exit extends Sprite {

    public Exit() {
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.EXIT);
        setImage(imageIcon.getImage());
        final int row = 9;
        final int column = 13;
        FieldOfGrid.getInstance().markingCell(row, column,2);

        setX(column * Constants.SIDE_SIZE + Constants.BORDERS);
        setY(row * Constants.SIDE_SIZE + Constants.BORDERS);
    }
}
