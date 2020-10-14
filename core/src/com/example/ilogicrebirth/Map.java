package com.example.ilogicrebirth;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.List;


public class Map extends Stage {
    public final int MAP_HEIGHT = 25;
    public final int MAP_WIDTH = 25;
    float stateTime;

    private final List<Tile> tileList;

    private final int[][] map = new int[MAP_HEIGHT][MAP_WIDTH];

    public Map(List<Tile> tileList) {
        this.tileList = tileList;

        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                map[y][x] = (x + y) % tileList.size();
            }
        }

    }

    @Override
    public void draw() {
        Batch batch = this.getBatch();

        stateTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                batch.draw(tileList.get(map[y][x]).getAnimation().getKeyFrame(stateTime, true), x * 32, y * 32);
            }
        }
        batch.end();
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public Tile getTile(int y, int x) {
        return tileList.get(map[y][x]);
    }

    public void setTile(int y, int x, int tileIndex) {
        if(tileIndex < 0 || tileIndex >= tileList.size()) return; //throw exception?

        map[y][x] = tileIndex;
    }
}
