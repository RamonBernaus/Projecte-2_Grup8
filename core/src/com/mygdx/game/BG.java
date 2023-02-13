package com.mygdx.game;


import static com.mygdx.game.AssetsManager.BackgroundSprite;
import static com.mygdx.game.AssetsManager.batch;

public class BG {
    public void renderBackground() {
        batch.begin();
        BackgroundSprite.draw(batch);
        batch.end();
    }
}
