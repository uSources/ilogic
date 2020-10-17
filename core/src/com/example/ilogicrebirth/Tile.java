package com.example.ilogicrebirth;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
    private String name;
    private Animation<TextureRegion> animation;
    //Other parameters relating to tiles (ex. visibility, etc.)

    public Tile() {}

    public Tile(String name, Animation<TextureRegion> animation) {
        this.name = name;
        this.animation = animation;
    }

    public String getName() {
        return name;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public TextureRegion getKeyFrame(float stateTime) { return animation.getKeyFrame(stateTime); }

    public TextureRegion getKeyFrame(float stateTime, boolean loop) { return animation.getKeyFrame(stateTime, loop); }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }
}
