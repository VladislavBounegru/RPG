package ru.bounegru.app.generators;

import ru.bounegru.model.Chest;
import ru.bounegru.model.Entrance;
import ru.bounegru.model.Exit;
import ru.bounegru.ui.GamePanel;

import java.awt.*;
import java.util.Random;

public class LevelGenerator {
    private Exit exit;
    private Entrance entrance;
    private Chest chest;


    public LevelGenerator() {
        initialize();
    }

    private void initialize() {
        exit = new Exit();
        entrance = new Entrance();
        int random = new Random().nextInt(9);
//        System.out.println(random);
        chest = random > 4 ? new Chest() : null;
    }

    public void drawLevel(Graphics g, GamePanel gamePanel) {
        g.drawImage(exit.getImage(), exit.getX(), exit.getY(), gamePanel);
        g.drawImage(entrance.getImage(), entrance.getX(), entrance.getY(), gamePanel);
        if (chest != null) {
            g.drawImage(chest.getImage(), chest.getX(), chest.getY(), gamePanel);
        }
    }

}
