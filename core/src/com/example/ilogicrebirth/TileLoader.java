package com.example.ilogicrebirth;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class TileLoader {
    public AssetManager assetManager;

    public TileLoader(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    //Load some default tile data for testing
    public List<Tile> loadTiles() {
        List<Tile> tileList = new ArrayList<>();

        final TextureRegion[] waterRegions = new TextureRegion[]{
                new TextureRegion(assetManager.<Texture>get(Assets.waterFile)),
                new TextureRegion(assetManager.<Texture>get(Assets.sWaterFile)),
        };

        final TextureRegion[] cliffRegions = new TextureRegion[]{
                new TextureRegion(assetManager.<Texture>get(Assets.cliffFile)),
        };

        tileList.add(new Tile("Water", new Animation<>(1f, waterRegions)));
        tileList.add(new Tile("Cliff", new Animation<>(0f, cliffRegions)));

        return tileList;
    }

    //Read tiles data from JSON file
    public List<Tile> loadTiles(String fileName) {
        //TODO

        return loadTiles();
    }
}
