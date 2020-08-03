package ru.bounegru.ui;

import ru.bounegru.callbacks.GameEventListener;
import ru.bounegru.constants.Constants;
import ru.bounegru.images.Image;
import ru.bounegru.images.ImageFactory;
import ru.bounegru.model.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private ImageIcon backgroundImage;
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
        backgroundImage = ImageFactory.createImage(Image.BACKGROUND);
        timer = new Timer(10, new GameLoop(this));
        timer.start();
    }

    private void initializeLayout() {
        addKeyListener(new GameEventListener(this));
        setFocusable(true);
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
    }

    private void drawCharacter(Graphics g) {
        g.drawImage(character.getImage(), character.getX(), character.getY(), this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
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
        character.movingAnimation();
    }


    private void update() {
        character.move();
    }

    public void keyPressed(KeyEvent e) {
        this.character.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        this.character.keyReleased(e);
    }


}
