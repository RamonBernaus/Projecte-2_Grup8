package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

public class ScrollHandler extends Group {




    // zombies
    int numZombies;
    ArrayList<Zombies> zombies;

    @Override
    public void act(float delta) {
        super.act(delta);
        //if (bg.isLeftOfScreen()) {
        //    bg.reset(bg_back.getTailX());

        //} else if (bg_back.isLeftOfScreen()) {
        //    bg_back.reset(bg.getTailX());
        //}
    }

    public ScrollHandler() {
        //Creem els dos fons
        //bg = new BackGround(0, 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT);
        //bg_back = new BackGround(bg.getTailX(), 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT);

        //Afegim els fons (actors) al grup


        // Comencem amb 3 zombies
        numZombies = 3;

        // Creem l'ArrayList
        zombies = new ArrayList<Zombies>();



        // Afegim el primer zombi a l'array i al grup
        Zombies zombie = new Zombies(Settings.ZOMBIES_STARTX,Settings.ZOMBIES_STARTY,Settings.GAME_WIDTH,Settings.GAME_HEIGHT,Settings.ZOMBIES_SPEED);
        zombies.add(zombie);
        addActor(zombie);

        // Des del segon fins l'últim zombie
        for (int i = 1; i < numZombies; i++) {
            // Afegim al zombie
            //zombie = new Zombies(zombies.get(zombies.size() - 1).getTailX() + Settings.ZOMBIES_GAP, r.nextInt(Settings.GAME_HEIGHT - 1), Settings.ZOMBIES_SPEED);
            zombie = new Zombies(zombies.get(zombies.size() -1).getTailX() + Settings.ZOMBIES_GAP,Settings.GAME_HEIGHT, Settings.ZOMBIES_WIDTH, Settings.ZOMBIES_HEIGHT, Settings.ZOMBIES_SPEED);
            // Afegim al zombie a l'ArrayList
            zombies.add(zombie);
            // Afegim al zombi al grup d'actors
            addActor(zombie);
        }
    }
    public ArrayList<Zombies> getZombies() {
        return zombies;
    }
}
