package com.example.ilogicrebirth;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Dictionary;
import java.util.Hashtable;

public class Assets extends AssetManager {
    public final String water = "tiles/Water.png";
    public final String sWater = "tiles/SWater.png";
    public final String cliff = "tiles/GrassCliff.png";

    public Assets() {
        this.load(water, Texture.class);
        this.load(cliff, Texture.class);
        this.load(sWater, Texture.class);
        this.finishLoading();
    }

    @Override
    public synchronized void dispose() {
        this.unload(water);
        this.unload(sWater);
        this.unload(cliff);

        super.dispose();
    }
}
