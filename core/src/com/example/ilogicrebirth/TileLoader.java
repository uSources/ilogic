package com.example.ilogicrebirth;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

public class TileLoader {
    public Assets assetManager;

    public TileLoader(Assets assetManager) {
        this.assetManager = assetManager;
    }

    //Load some default tile data for testing
    public List<Tile> loadTiles() {
        List<Tile> tileList = new ArrayList<>();

        final TextureRegion[] waterRegions = new TextureRegion[]{
                new TextureRegion(assetManager.<Texture>get("tiles/Water.png")),
                new TextureRegion(assetManager.<Texture>get("tiles/SWater.png")),
        };

        final TextureRegion[] cliffRegions = new TextureRegion[]{
                new TextureRegion(assetManager.<Texture>get("tiles/GrassCliff.png")),
        };

        tileList.add(new Tile("Water", new Animation<>(1f, waterRegions)));
        tileList.add(new Tile("Cliff", new Animation<>(0f, cliffRegions)));

        return tileList;
    }

    //Read tiles data from JSON file
    public List<Tile> loadTiles(String tilesJson, TextureAtlas tilesAtlas) {

        List<Tile> tileList = new ArrayList<>();

        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal(tilesJson));
        for (JsonValue component : base)  {
            String tileName = component.getString("name");
            String tileSheetName = component.getString("tileSheetName");
            int frameDuration = component.getInt("frameDuration");
            Array<TextureAtlas.AtlasRegion> frameRegions = tilesAtlas.findRegions(tileSheetName);
            tileList.add(
                    new Tile(tileName,
                    new Animation<TextureRegion>(frameDuration, frameRegions)));
        }
        return tileList;
    }
}
