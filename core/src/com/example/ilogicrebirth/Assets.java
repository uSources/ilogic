package com.example.ilogicrebirth;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import javax.swing.text.TabExpander;
import java.util.Dictionary;
import java.util.Hashtable;

public class Assets extends AssetManager {
    public final String water = "tiles/Water.png";
    public final String cliff = "tiles/GrassCliff.png";
    public final Dictionary<Tiles, Texture> tiles = new Hashtable();


    public Assets() {
        this.load(water, Texture.class);
        this.load(cliff, Texture.class);
        this.finishLoading();
        tiles.put(Tiles.Water, this.get(water, Texture.class));
        tiles.put(Tiles.Cliff, this.get(cliff, Texture.class));
    }

    public Texture getTile(Tiles tileType) {
        return tiles.get(tileType);
    }



}
