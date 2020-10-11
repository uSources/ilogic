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

    public final Dictionary<Tiles, Animation> tiles = new Hashtable();


    public Assets() {
        this.load(water, Texture.class);
        this.load(cliff, Texture.class);
        this.load(sWater, Texture.class);
        this.finishLoading();

        final TextureRegion[] waterRegions = new TextureRegion[]{
                new TextureRegion(this.<Texture>get(water)),
                new TextureRegion(this.<Texture>get(sWater)),
        };

        final TextureRegion[] cliffTexture = new TextureRegion[]{
                new TextureRegion(this.<Texture>get(cliff)),
        };

        tiles.put(Tiles.Water, new Animation(0.5f, waterRegions));
        tiles.put(Tiles.Cliff, new Animation(0f, cliffTexture));
    }

    public Animation getTile(Tiles tileType) {
        return tiles.get(tileType);
    }


}
