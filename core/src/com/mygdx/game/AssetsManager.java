package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class AssetsManager {
    /*

     */
    // Sprite Sheet
    public static Texture SheetPersonatge, SheetZombie;
    public static Texture Background;
    public static Sprite BackgroundSprite;
    public static SpriteBatch batch;
    public static TextureRegion PersonatgeStraight, PersonatgeRight, PersonatgeLeft, PersonatgeDown;
    public static Sound dropSound;
    public static Music BackgroundMusic;



    //Sons
    public static Sound explosionSound;
    public static Sound LaserGun;
    public static Music music;

    public static void load() {
        // Carreguem les textures i li apliquem el mètode d'escalat 'nearest'
        SheetPersonatge = new Texture("Guts-Sprites-Frente.png");
        SheetPersonatge.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        // Carreguem el batch
        batch = new SpriteBatch();
        // Sprites del Personatge

        // Sprites del BackGround
        Background = new Texture("Fondo.jpg");
        BackgroundSprite =new Sprite(Background);



        // Carguem la música de fons
        BackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Projecte-2-Dam.mp3"));

        // Reproduim la música del joc
        BackgroundMusic.setVolume(0.2f);
        BackgroundMusic.setLooping(true);


    }

    public static void dispose () {
        // Descartem els recursos
        //dropSound.dispose();
        BackgroundMusic.dispose();
        Background.dispose();
    }
}
