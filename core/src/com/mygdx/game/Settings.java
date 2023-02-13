package com.mygdx.game;

public class Settings {

    // Mida del joc, s'escalarà segons la necessitat
    public static final int GAME_WIDTH = 240;
    public static final int GAME_HEIGHT = 135;

    // Propietats del Personatge
    public static final float CHARACTER_VELOCITY = 50;
    public static final int CHARACTER_WIDTH = 64;
    public static final int CHARACTER_HEIGHT = 64;
    public static final float CHARACTER_STARTX = 20;
    public static final float CHARACTER_STARTY = GAME_HEIGHT/2 - CHARACTER_HEIGHT/2;
    //Propietats dels Zombis
    public static final int ZOMBIES_WIDTH = 64;
    public static final int ZOMBIES_HEIGHT = 64;
    public static final float ZOMBIES_STARTX = 20;
    public static final float ZOMBIES_STARTY = ZOMBIES_HEIGHT/2 - ZOMBIES_HEIGHT/2;
    // Configuració scrollable
    public static final int ZOMBIES_SPEED = -150;
    public static final int ZOMBIES_GAP = 75;
    public static final int BG_SPEED = -100;

}
