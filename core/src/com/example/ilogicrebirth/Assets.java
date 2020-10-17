package com.example.ilogicrebirth;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class Assets extends AssetManager {
    public final String tilesAltas = "tiles/tiles.atlas";
    public static final String soldierFile = "units/b_Soldier.png";

    public Assets() {
        this.load(tilesAltas, TextureAtlas.class);
        this.load(soldierFile, Texture.class);
        this.finishLoading();
    }

    @Override
    public synchronized void dispose() {
        this.unload(tilesAltas);
        this.unload(soldierFile);
        super.dispose();
    }
}
