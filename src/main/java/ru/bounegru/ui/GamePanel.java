package ru.bounegru.ui;

import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private ImageIcon backgruondImage;

    public GamePanel() {
        initializeVariables();
        initializeLayout();

    }

    private void initializeVariables() {
        backgruondImage = ImageFactory.createImage(Image.BACKGROUND);
    }

    private void initializeLayout() {
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_Height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgruondImage.getImage(),0,0,null);
    }
}
