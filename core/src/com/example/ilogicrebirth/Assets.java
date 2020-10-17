package com.example.ilogicrebirth;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;

import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;

public class Assets extends AssetManager {
    public final String tilesAltas = "tiles/tiles.atlas";

    public Assets() {
        this.load(tilesAltas, TextureAtlas.class);
        this.finishLoading();
    }

    @Override
    public synchronized void dispose() {
        this.unload(tilesAltas);

        super.dispose();
    }
}
