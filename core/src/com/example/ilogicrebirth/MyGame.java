package com.example.ilogicrebirth;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;

public class MyGame extends ApplicationAdapter {
	Map map;
	Assets assetManager;


	public static MyGame getInstance() {
		return (MyGame) Gdx.app.getApplicationListener();
	}

	@Override
	public void create () {

		assetManager = new Assets();
		assetManager.finishLoading();
		map = new Map();
		Pixmap cursor = new Pixmap(Gdx.files.internal("misc/crosshair.png"));
		Gdx.graphics.setCursor(Gdx.graphics.newCursor(cursor,16,16));
	}

	@Override
	public void render () {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//Add AntiAliasing bit
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));

		map.draw();
	}

	
	@Override
	public void dispose () {
		map.dispose();
	}
}
