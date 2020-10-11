package com.example.ilogicrebirth;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Water extends Actor {

    Sprite sprite;

    public Water() {
        sprite = new Sprite(MyGame.getInstance().assetManager.get("tiles/Water.png", Texture.class));
    }

    public Water(int x, int y) {
        this();
        sprite.setX(x);
        sprite.setY(y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
    }
}
