package com.example.ilogicrebirth;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGame extends ApplicationAdapter {
	MapGenerator mapGenerator;
	AssetManager assetManager;


	public static MyGame getInstance() {
		return (MyGame) Gdx.app.getApplicationListener();
	}

	@Override
	public void create () {

		assetManager = new AssetManager();
		assetManager.load("tiles/Water.png", Texture.class);
		assetManager.finishLoading();
		mapGenerator = new MapGenerator();
		Pixmap cursor = new Pixmap(Gdx.files.internal("misc/mouse.png"));
		int xHotspot = 7;
		int yHotspot = 0;
		Gdx.graphics.setCursor(Gdx.graphics.newCursor(cursor,xHotspot,yHotspot));
	}

	@Override
	public void render () {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//Add AntiAliasing bit
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));

		mapGenerator.draw();
	}

	
	@Override
	public void dispose () {
		mapGenerator.dispose();
	}
}
