package ru.bounegru.model;

import ru.bounegru.constants.Constants;
import ru.bounegru.controllers.MovingController;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;

import javax.swing.*;
import java.awt.event.KeyEvent;


public class Character extends Sprite {
    //TODO find a way to do it more elegant instead of use boolean vars
    private MovingController movingController;

    public Character() {
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.CHARACTER);
        setImage(imageIcon.getImage());
        movingController = new MovingController(this);

        int startX = Constants.BORDERS + Constants.CHARACTER_WIDTH;
        System.out.println(Constants.HEIGHT / 2 - Constants.CHARACTER_HEIGHT / 2);
        int startY = Constants.HEIGHT / 2 - Constants.CHARACTER_HEIGHT / 2;
        setX(startX);
        setY(startY);
    }

    public void move() {
        movingController.moving();
    }

    public void keyPressed(KeyEvent e) {
        movingAnimation();
        movingController.pressedKey(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        movingController.releasedKey(e.getKeyCode());
    }

    public void movingAnimation() {

//        Horizontal state - NONE, LEFT, RIGHT, LEFTRIGHT
        String verticalDirection = movingController.getVertical();
        //        Vertical stat - NONE, UP, DOWN, UPDOWN
        String horizontalDirection = movingController.getHorizontal();
//        this string equals only when they are both empty (NONE)
        ImageIcon idleImageIcon = ImageFactory.createImage(Image.CHARACTER);

        if (horizontalDirection.equals(verticalDirection)) {
            setImage(idleImageIcon.getImage());
            return;
        }

        switch (horizontalDirection) {
            case "LEFT":
                setImage(new ImageIcon(Constants.CHARACTER_LEFT).getImage());
                break;
            case "RIGHT":
                setImage(new ImageIcon(Constants.CHARACTER_RIGHT).getImage());
                break;
            default:
                break;
        }

        switch (verticalDirection) {
            case "UP":
                setImage(new ImageIcon(Constants.CHARACTER_UP).getImage());
                break;
            case "DOWN":
                setImage(new ImageIcon(Constants.CHARACTER_DOWN).getImage());
                break;
            default:
                if (horizontalDirection.equals("LEFTRIGHT") || horizontalDirection.equals("NONE")) {
                    setImage(idleImageIcon.getImage());
                }
                break;
        }
    }


}
