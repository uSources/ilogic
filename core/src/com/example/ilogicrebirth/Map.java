package com.example.ilogicrebirth;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Map extends Stage {

    public final int MAP_HEIGHT = 25;
    public final int MAP_WIDTH = 25;
    float stateTime;

    public final Tiles[][] map = new Tiles[MAP_HEIGHT][MAP_WIDTH];


    public Map() {
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                map[y][x] = (x + y) % 2 == 0 ? Tiles.Water : Tiles.Cliff;

            }
        }

    }

    @Override
    public void draw() {
        stateTime += Gdx.graphics.getDeltaTime();
        getBatch().begin();
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                this.getBatch().draw((TextureRegion) MyGame.getInstance().assetManager.getTile(map[x][y]).getKeyFrame(stateTime, true), x * 32, y * 32);
            }
        }
        getBatch().end();
    }


}
