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
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

public class TileLoader {
    public Assets assetManager;

    public TileLoader(Assets assetManager) {
        this.assetManager = assetManager;
    }


    //Read tiles data from JSON file
    public List<Tile> loadTiles(String tilesJson, TextureAtlas tilesAtlas) {

        HashMap<String, Tile> tileList = new HashMap<>();

        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal(tilesJson));

        for (JsonValue component : base) {
            String tileName = component.getString("name");
            if (!tileList.containsKey(tileName)) {
                String tileSheetName = component.getString("tileSheetName");
                float frameDuration = component.getFloat("frameDuration");
                Array<TextureAtlas.AtlasRegion> frameRegions = tilesAtlas.findRegions(tileSheetName);
                tileList.put(tileName,
                        new Tile(tileName, new Animation<TextureRegion>(frameDuration, frameRegions)));
            }

        }
        return new ArrayList<>(tileList.values());
    }
}
