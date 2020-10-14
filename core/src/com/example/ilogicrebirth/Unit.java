package com.example.ilogicrebirth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Unit extends Actor {
    private final UnitType type;
    private int y;
    private int x;
    private float stateTime;

    public Unit(UnitType type, int y, int x) {
        this.type = type;
        this.y = y;
        this.x = x;
        this.stateTime = 0;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        this.stateTime += Gdx.graphics.getDeltaTime();

        batch.draw(type.getAnimation().getKeyFrame(stateTime, true), x * 32, y * 32);
    }
}
