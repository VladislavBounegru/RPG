package ru.bounegru.model;

import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;

import javax.swing.*;
import java.awt.event.KeyEvent;


public class Character extends Sprite {
    //TODO find a way to do it more elegant instead of use boolean vars
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

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
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent e) {
        movingAnimation();
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && !left) {
            left = true;
            dx += -2;
        }
        if (key == KeyEvent.VK_RIGHT && !right) {
            right = true;
            dx += 2;
        }
        if (key == KeyEvent.VK_UP && !up) {
            up = true;
            dy += -2;
        }
        if (key == KeyEvent.VK_DOWN && !down) {
            down = true;
            dy += 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                left = false;
                dx += 2;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                dx += -2;
                break;
            case KeyEvent.VK_UP:
                up = false;
                dy += 2;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                dy += -2;
                break;
            default:
                break;
        }
    }

//    public boolean canCharacterMove(int x, int y) {
//        if(this.x==1)
//    }

    //TODO find a way to do it more elegant
    public void movingAnimation() {
        if ((!left && !right && !up && !down) ||
                (left && right && !up && !down) ||
                (!left && !right && up && down)) {
            setImage(new ImageIcon(Constants.CHARACTER_IMAGE_URL).getImage());
            return;
        }
        if (left) {
            setImage(new ImageIcon(Constants.CHARACTER_LEFT).getImage());
        }
        if (right) {
            setImage(new ImageIcon(Constants.CHARACTER_RIGHT).getImage());
        }
        if (left && !right) {
            setImage(new ImageIcon(Constants.CHARACTER_LEFT).getImage());
        }
        if (!left && right) {
            setImage(new ImageIcon(Constants.CHARACTER_RIGHT).getImage());
        }
        if (up && !down) {
            setImage(new ImageIcon(Constants.CHARACTER_UP).getImage());
        }
        if (!up && down) {
            setImage(new ImageIcon(Constants.CHARACTER_DOWN).getImage());
        }
    }


}
