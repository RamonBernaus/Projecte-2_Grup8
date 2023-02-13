package com.mygdx.game;

import static com.mygdx.game.AssetsManager.batch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Main extends Game {

    private Guts guts;
    private BG BG;

    @Override
    public void create() {
        // A l'iniciar el joc carreguem els recursos
        AssetsManager.load();
        BG = new BG();
        guts = new Guts(10,10);
        setScreen(new GameScreen());
    }
    @Override
    public void render(){
        // Creem el BG
        BG.renderBackground();
        // Dibuixem i actualitzem tots els actors de l'stage
        guts.render(batch);

    }
    // Cridem per descartar els recursos carregats.
    @Override
    public void dispose() {
        super.dispose();
        AssetsManager.dispose();
    }
}