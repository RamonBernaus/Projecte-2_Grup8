package com.mygdx.game;


import java.util.Random;

public class Zombies extends Scrollable {
    public Zombies(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height);
    }

    public void reset(float newX) {
        super.reset(newX);
        // La posició serà un valor aleatori entre 0 i l'alçada de l'aplicació menys l'alçada de l'asteroide
        position.y = new Random().nextInt(Settings.GAME_HEIGHT - (int) height);
    }

}
