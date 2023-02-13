package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.security.PublicKey;

public class Guts {
    //Crea el Sprite
    private Sprite sprite;
    //Posicion de X, Y de Guts
    float GutsX, GutsY;
    //La animacion
    Animation<TextureRegion> walkAnimation;
    Animation<TextureRegion> walkAnimationRigth;
    Animation<TextureRegion> walkAnimationLeft;
    //Las texturas
    private TextureRegion[] regions;
    //Tiempo entre sprite de la animacion
    float stateTime;
    private TextureRegion FrameActual;
    private int currentAnimation;
    Texture GutsStraight, GutsRight, GutsLeft, GutsBack, Guts;
    public boolean MoveRight, MoveLeft;

    public Guts(float GutsX, int GutsY) {
        this.GutsX = GutsX;
        this.GutsY = GutsY;
        //Creem l'imatge
        GutsStraight = new Texture("Guts-Sprites-Frente.png");
        GutsRight = new Texture("Guts-Sprites-Dreta.png");
        GutsLeft = new Texture("Guts-Sprites-Esquerra.png");
        //La dividim en els diferents sprites, al ser un 4 * 4 dividim el width i height en 4
        TextureRegion[][] Straigth = TextureRegion.split(GutsStraight, GutsStraight.getWidth() / 4, GutsStraight.getHeight());
        TextureRegion[][] Right = TextureRegion.split(GutsRight, GutsRight.getWidth() / 4, GutsRight.getHeight());
        TextureRegion[][] Left = TextureRegion.split(GutsLeft, GutsRight.getWidth() / 4, GutsLeft.getHeight());


        regions = new TextureRegion[4];

        //Creem l'animacio de caminar
        for (int i = 0; i < 4; i++) regions[i] = Straigth[0][i];
        walkAnimation = new Animation<>(1, regions);
        stateTime = 0.25f;

        for (int i = 0; i < 4; i++) regions[i] = Right[0][i];
        walkAnimationRigth = new Animation<>(1, regions);
        stateTime = 0.25f;

        for (int i = 0; i < 4; i++) regions[i] = Left[0][i];
        walkAnimationLeft = new Animation<>(1, regions);
        stateTime = 0.25f;
    }

    public void create() {

    }

    float PersonatgeSpeed = 100.0f; // 100 pixels per second.

    public void render(final SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime() * 3; // es el temps que ha pasat desde l'ultim render
        FrameActual = walkAnimation.getKeyFrame(stateTime, true);
        currentAnimation = 0;
        //Iniciem el batch
        batch.begin();
        //Dibuixem al personatge
        batch.draw(FrameActual, GutsX, GutsY);
        //Fem que es pugui moure
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
            GutsX -= Gdx.graphics.getDeltaTime() * PersonatgeSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
            GutsX += Gdx.graphics.getDeltaTime() * PersonatgeSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
            GutsY += Gdx.graphics.getDeltaTime() * PersonatgeSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
            GutsY -= Gdx.graphics.getDeltaTime() * PersonatgeSpeed;
        if (currentAnimation == 0) {
            FrameActual = walkAnimation.getKeyFrame(stateTime, true);
        } else {
            FrameActual = walkAnimationRigth.getKeyFrame(stateTime, true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            currentAnimation = (currentAnimation + 1) % 2;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            currentAnimation = (currentAnimation + 1) % 2;
        }
        //Tanquem el batch
        batch.end();
    }




}