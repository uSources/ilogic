package com.example.ilogicrebirth;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MapGenerator extends Stage {

    public final int MAP_HEIGHT = 25;
    public final int MAP_WIDTH = 25;

    public MapGenerator() {


        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                this.addActor(new Water(x * 32,y * 32));
            }
        }

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }



}
