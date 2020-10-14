package com.example.ilogicrebirth;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets extends AssetManager {
    public static final String waterFile = "tiles/Water.png";
    public static final String sWaterFile = "tiles/SWater.png";
    public static final String cliffFile = "tiles/GrassCliff.png";
    public static final String soldierFile = "units/b_Soldier.png";

    public Assets() {
        this.load(waterFile, Texture.class);
        this.load(cliffFile, Texture.class);
        this.load(sWaterFile, Texture.class);
        this.load(soldierFile, Texture.class);
        this.finishLoading();
    }

    @Override
    public synchronized void dispose() {
        this.unload(waterFile);
        this.unload(sWaterFile);
        this.unload(cliffFile);
        this.unload(soldierFile);

        super.dispose();
    }
}
