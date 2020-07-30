package ru.bounegru.ui;

import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;
import ru.bounegru.model.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private ImageIcon backgruondImage;
    private Timer timer;
    private Character character;
    private boolean inGame;

    public GamePanel() {
        initializeVariables();
        initializeLayout();

    }

    private void initializeVariables() {
        inGame = true;
        character = new Character();
        backgruondImage = ImageFactory.createImage(Image.BACKGROUND);
        timer = new Timer(200, new GameLoop(this));
        timer.start();
    }

    private void initializeLayout() {
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
    }

    private void drawCharacter(Graphics g) {
        g.drawImage(character.getImage(), character.getX(), character.getY(), this);
        System.out.println("das");
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgruondImage.getImage(), 0, 0, null);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            drawCharacter(g);
        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void doOneLoop() {
        update();
        repaint();
    }


    private void update() {

    }

    public void keyPressed(KeyEvent e) {
        this.character.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        this.character.keyReleased(e);
    }


}
