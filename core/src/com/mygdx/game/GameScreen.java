package com.mygdx.game;

import static com.mygdx.game.Settings.CHARACTER_HEIGHT;
import static com.mygdx.game.Settings.CHARACTER_STARTX;
import static com.mygdx.game.Settings.CHARACTER_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;


public class GameScreen implements Screen {
    private Stage stage;
    private Personatge Personatge;
    private ScrollHandler scrollHandler;


    // Per obtenir el batch de l'stage
    private Batch batch;

    public GameScreen() {
        // Creem la càmera de les dimensions del joc
        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        // Posant el paràmetre a true configurem la càmera perquè faci servir el sistema de coordenades Y-Down
        camera.setToOrtho(true);

        // Creem el viewport amb les mateixes dimensions que la càmera
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT , camera);

        // Creem l'stage i assignem el viewport
        stage = new Stage(viewport);

        batch = stage.getBatch();

        // Creem la nau i la resta d'objectes
        Personatge = new Personatge(CHARACTER_STARTX, Settings.CHARACTER_STARTY, CHARACTER_WIDTH, CHARACTER_HEIGHT);
        scrollHandler = new ScrollHandler();

        // Afegim els actors a l'stage
        stage.addActor(scrollHandler);
        //stage.addActor(Personatge);

    }


    @Override
    public void show() {

    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }

    public Personatge getPersonatge() {
        return Personatge;
    }

    public Stage getStage() {
        return stage;
    }


    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
