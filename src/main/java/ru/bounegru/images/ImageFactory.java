package ru.bounegru.images;

import ru.bounegru.constants.Constants;

import javax.swing.*;


public class ImageFactory {
    public static ImageIcon createImage(Image image) {
        ImageIcon imageIcon = null;
        switch (image) {
            case CHARACTER:
                imageIcon = new ImageIcon(Constants.CHARACTER_IMAGE_URL);
                break;
            case ENEMY:
                imageIcon = new ImageIcon(Constants.ENEMY_IMAGE_URL);
                break;
            case SWORD:
                imageIcon = new ImageIcon(Constants.SWORD_IMAGE_URL);
                break;
            case ENTRANCE:
                imageIcon = new ImageIcon(Constants.ENTRANCE_IMAGE_URL);
                break;
            case BLOCK:
                imageIcon = new ImageIcon(Constants.BLOCK_IMAGE_URL);
                break;
            case CHEST:
                imageIcon = new ImageIcon(Constants.CHEST_IMAGE_URL);
                break;
            case EXIT:
                imageIcon = new ImageIcon(Constants.EXIT_IMAGE_URL);
                break;
            case BACKGROUND:
                imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
                break;
            default:
                break;
        }
        return imageIcon;
    }
}
