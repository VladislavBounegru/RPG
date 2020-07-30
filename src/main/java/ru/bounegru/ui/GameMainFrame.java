package ru.bounegru.ui;


import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;

import javax.swing.*;
import java.awt.*;

public class GameMainFrame extends JFrame {

    public GameMainFrame() {
        add(new GamePanel());
        setTitle(Constants.TITLE);
        setIconImage(ImageFactory.createImage(Image.SWORD).getImage());
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setSize(Constants.BOARD_WIDTH,Constants.BOARD_Height);
        setResizable(false);
        setVisible(true);

    }
}
