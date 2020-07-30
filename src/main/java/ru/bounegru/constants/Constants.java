package ru.bounegru.constants;

public class Constants {

    private Constants() {
    }

    public static final String TITLE = "Roguelike";

    public static final int BOARD_WIDTH = 800;
    public static final int BOARD_Height = 600;


    public static final String BASE_IMAGE_DIRECTORY = "src/main/resources/images/";
    public static final String BACKGROUND_IMAGE_URL = BASE_IMAGE_DIRECTORY + "BackgroundClear.png";
    public static final String BLOCK_IMAGE_URL = BASE_IMAGE_DIRECTORY + "block.png";
    public static final String CHARACTER_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Character.png";
    public static final String ENEMY_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Character.png"; //TODO make uniq enemy sprite
    public static final String CHEST_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Chest.png";
    public static final String ENTRANCE_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Entrance.png";
    public static final String EXIT_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Exit.png";
    public static final String SWORD_IMAGE_URL = BASE_IMAGE_DIRECTORY + "Sword.png";
}