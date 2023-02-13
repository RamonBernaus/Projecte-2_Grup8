package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Pantalla implements Screen {
    private OrthographicCamera camara;
    private Batch batch;


    @Override
    public void show() {
        Vector2 cameraSize = new Vector2(
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
        camara = new OrthographicCamera(cameraSize.x, cameraSize.y);
        camara.position.set(camara.viewportWidth / 2f, camara.viewportHeight / 2f, 0);
        camara.update();
    }

    @Override
    public void render(float delta) {
        //camara.position.x = jugador.sprite.getX();
        camara.update();
        batch.setProjectionMatrix(camara.combined);
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
