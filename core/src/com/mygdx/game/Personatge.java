package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class Personatge extends Actor {
    // Diferents posicions del Personatge: dreta, esquerra, normal
    // Distintes posicions de l'Spacecraft: recta, pujant i baixant
    public static final int CHARACTER_STRAIGHT = 0;
    public static final int CHARACTER_UP = 1;
    public static final int CHARACTER_DOWN = 2;
    public enum State {Straight, Up, Down, Right, Left}
    public State currentState;
    public State previousState;
    private Animation<TextureRegion> Walking;
    private float stateTimer;
    Animation<TextureRegion> walkAnimation;
    Texture walkSheet;
    private static final int FRAME_COLS = 10, FRAME_ROWS = 1;

    // Paràmetres del Personatge
    private Vector2 position;
    private int width, height;
    private int direction;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetsManager.PersonatgeStraight, position.x, position.y, width, height);
    }

    public Personatge(float x, float y, int width, int height) {

        //Inicialitzem els arguments segons la crida del constructor
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);

        //Inicialitzem el Personatge a l'estat normal
        direction = CHARACTER_STRAIGHT;


    }
    public void act(float delta) {// Movem l'Spacecraft depenent de la direcció controlant que no surti de la pantalla
        switch (direction) {
            case CHARACTER_UP:
                if (this.position.y - Settings.CHARACTER_VELOCITY * delta >= 0) {
                    this.position.y -= Settings.CHARACTER_VELOCITY * delta;
                }
                break;
            case CHARACTER_DOWN:
                if (this.position.y + height + Settings.CHARACTER_VELOCITY * delta <= Settings.GAME_HEIGHT) {
                    this.position.y += Settings.CHARACTER_VELOCITY * delta;
                }
                break;
            case CHARACTER_STRAIGHT:
                break;
        }
    }

    public float getX() {
        return position.x;
    }
    public float getY() {
        return position.y;
    }
    public float getHeight() {
        return height;
    }
    public float getWidth() {
        return width;
    }
    // Canviem la direcció de l'Spacecraft: Puja
    public void goUp() {
        direction = CHARACTER_UP;
    }

    // Canviem la direcció de l'Spacecraft: Baixa
    public void goDown() {
        direction = CHARACTER_DOWN;
    }

    // Posem l'Spacecraft al seu estat original
    public void goStraight() {
        direction = CHARACTER_STRAIGHT;
    }
}