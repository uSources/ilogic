package com.example.ilogicrebirth;


import com.badlogic.gdx.scenes.scene2d.Stage;



enum Tiles{
    Water,
    Grass,
    Cliff
}

public class Map extends Stage {

    public final int MAP_HEIGHT = 25;
    public final int MAP_WIDTH = 25;

    public final Tiles[][] map = new Tiles[MAP_HEIGHT][MAP_WIDTH];


    public Map() {
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                map[y][x] = (x+y) % 2 == 0 ? Tiles.Water: Tiles.Cliff;

            }
        }

    }

    @Override
    public void draw() {
        getBatch().begin();
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                this.getBatch().draw(MyGame.getInstance().assetManager.getTile(map[x][y]), x * 32 , y * 32);
            }
        }
        getBatch().end();
    }


}
