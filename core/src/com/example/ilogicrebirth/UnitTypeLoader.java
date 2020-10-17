package com.example.ilogicrebirth;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class UnitTypeLoader {
    public AssetManager assetManager;

    public UnitTypeLoader(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public List<UnitType> loadUnits() {
        List<UnitType> unitList = new ArrayList<>();

        final TextureRegion[] soldierRegions = new TextureRegion[]{
                new TextureRegion(assetManager.<Texture>get(Assets.soldierFile)),
        };

        unitList.add(new UnitType("Soldier", new Animation<>(0f, soldierRegions)));

        return unitList;
    }
}
