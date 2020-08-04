package ru.bounegru.constants;

public class Constants {

    private Constants() {
    }

    public static final String TITLE = "Roguelike";

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int BORDERS = 50;
    public static final int SIDE_SIZE = 50;
    public static final int CHARACTER_WIDTH = 34;
    public static final int CHARACTER_HEIGHT = 50;
    public static final int ROW = 10;
    public static final int COLUMN = 14;

    //sped of the app
    public static final int GAME_SPEED = 10;

    // images
    public static final String BASE_IMAGE_DIRECTORY = "src/main/resources/images/";
    public static final String CHARACTER_DIRECTORY = BASE_IMAGE_DIRECTORY + "Character/";
    public static final String BACKGROUND_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Background.png";
    public static final String BLOCK_IMAGE_URL = BASE_IMAGE_DIRECTORY + "block.png";
    public static final String CHARACTER_IMAGE_URL = CHARACTER_DIRECTORY + "CharacterDown.png";
    public static final String CHARACTER_LEFT = CHARACTER_DIRECTORY + "Left.gif";
    public static final String CHARACTER_RIGHT = CHARACTER_DIRECTORY + "Right.gif";
    public static final String CHARACTER_UP = CHARACTER_DIRECTORY + "Up.gif";
    public static final String CHARACTER_DOWN = CHARACTER_DIRECTORY + "Down.gif";
    public static final String ENEMY_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Character.png"; //TODO make uniq enemy sprite
    public static final String CHEST_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Chest.png";
    public static final String ENTRANCE_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Entrance.png";
    public static final String EXIT_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Exit.png";
    public static final String SWORD_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Sword.png";
}
